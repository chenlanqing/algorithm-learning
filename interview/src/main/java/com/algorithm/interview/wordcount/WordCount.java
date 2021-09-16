package com.algorithm.interview.wordcount;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;

/**
 * @author QingFan 2021-06-05
 * @version 1.0.0
 */
public class WordCount {

    ForkJoinPool pool = ForkJoinPool.commonPool();

    static class CounterTask implements Callable<HashMap<String, Integer>> {
        private final long start;
        private final long end;
        private final String fileName;

        public CounterTask(long start, long end, String fileName) {
            this.start = start;
            this.end = end;
            this.fileName = fileName;
        }

        @Override
        public HashMap<String, Integer> call() throws Exception {
            FileChannel channel = new RandomAccessFile(this.fileName, "rw").getChannel();
            MappedByteBuffer buffer = channel.map(
                    FileChannel.MapMode.READ_ONLY,
                    start,
                    end - start
            );
            String str = StandardCharsets.US_ASCII.decode(buffer).toString();
            return countByString(str);
        }
    }

    public void run(String fileName, long chunkSize) throws Exception {
        File file = new File(fileName);
        long len = file.length();
        long position = 0;
        long startTime = System.currentTimeMillis();
        ArrayList<Future<HashMap<String, Integer>>> tasks = new ArrayList<>();
        while (position < len) {
            long next = Math.min(position + chunkSize, len);
            CounterTask task = new CounterTask(position, next, fileName);
            ForkJoinTask<HashMap<String, Integer>> joinTask = pool.submit(task);
            tasks.add(joinTask);
            position = next;
        }
        System.out.format("split to %d tasks\n", tasks.size());

        HashMap<String, Integer> totalMap = new HashMap<>();
        for (Future<HashMap<String, Integer>> future : tasks) {
            HashMap<String, Integer> map = future.get();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                incKey(entry.getKey(), totalMap, entry.getValue());
            }
        }

        System.out.println("time:" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("total:" + totalMap.size());

        System.out.println(totalMap.get("ababb"));
    }

    @Test
    public void count_multi_thread() throws Exception {
        WordCount count = new WordCount();
        System.out.println("processors:" + Runtime.getRuntime().availableProcessors());
        count.run("word", 1024 * 1024 * 20);
    }

    @Test
    public void count_single_thread() throws Exception {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("word"));
        byte[] buffer = new byte[4 * 1024];
        int len;
        HashMap<String, Integer> hashMap = new HashMap<>();
        long startTime = System.currentTimeMillis();
        while ((len = inputStream.read(buffer)) != -1) {
            byte[] bytes = Arrays.copyOfRange(buffer, 0, len);
            String str = new String(bytes);
            HashMap<String, Integer> map = countByString(str);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                incKey(entry.getKey(), hashMap, entry.getValue());
            }
        }

        System.out.println("time:" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println(hashMap.get("ababb"));
        System.out.println(hashMap.size());
    }

    private static HashMap<String, Integer> countByString(String str) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            incKey(token, hashMap, 1);
        }
        return hashMap;
    }

    private static void incKey(String key, HashMap<String, Integer> map, Integer n) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + n);
        } else {
            map.put(key, n);
        }
    }
}
