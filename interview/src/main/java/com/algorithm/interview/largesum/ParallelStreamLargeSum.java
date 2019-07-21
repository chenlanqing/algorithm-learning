package com.algorithm.interview.largesum;

import com.google.common.primitives.Longs;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.LongStream;

/**
 * 使用JDK并行流
 *
 * @author bluefish 2019-07-21
 * @version 1.0.0
 */
public class ParallelStreamLargeSum {

    public long sumList(List<Long> list) {
        return list.parallelStream().reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        long reduce = LongStream.rangeClosed(0, 999999L).parallel().reduce(0, Long::sum);

        long[] array = LongStream.rangeClosed(0, 999999L).toArray();

        List<Long> list = Longs.asList(array);

        list.parallelStream().reduce(0L, Long::sum);

        System.out.println(reduce);

        Instant end = Instant.now();

        System.out.println(Duration.between(start, end).getSeconds());

    }
}
