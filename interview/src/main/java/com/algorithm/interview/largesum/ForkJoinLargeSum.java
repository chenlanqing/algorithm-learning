package com.algorithm.interview.largesum;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * @author bluefish 2018/6/26
 * @version 1.0.0
 */
public class ForkJoinLargeSum {

    public static void main(String[] args) throws Exception {
        int[] array = IntStream.rangeClosed(0, 100).toArray();
        ForkJoinPool pool = new ForkJoinPool();
        Task task = new Task(0, array.length, 100, array);
        Future<Integer> future = pool.submit(task);
        System.out.println(future.get());

        pool.shutdown();
    }

    static class Task extends RecursiveTask<Integer> {
        public static final int DEFAULT_THRESHOLD = 1000;
        private int high, low;
        private int threshold;
        private int[] array;

        public Task(int low, int high, int threshold, int[] array) {
            this.high = high;
            this.low = low;
            this.threshold = threshold;
            this.array = array;
        }

        @Override
        protected Integer compute() {
            if (high - low <= threshold) {
                int sum = 0;
                for (int i = low; i < high; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int middle = (high - low) / 2 + low;
                Task leftTask = new Task(low, middle, threshold, array);
                Task rightTask = new Task(middle, high, threshold, array);
                leftTask.fork();
                rightTask.fork();
                return leftTask.join() + rightTask.join();
            }
        }
    }
}
