package com.algorithm.interview.largesum;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过CyclicBarrier来计算List中所有整数的之和
 */
@Slf4j
public class CyclicBarrierCountListSum {
    /**
     * 存放整数的和
     */
    private long sum;

    /**
     * 同步器
     */
    private CyclicBarrier barrier;

    /**
     * 整数集合List
     */
    private List<Integer> list;
    /**
     * 使用的线程数
     */
    private int threadCounts;

    public CyclicBarrierCountListSum(List<Integer> list, int threadCounts) {
        this.list = list;
        this.threadCounts = threadCounts;
    }

    /**
     * 获取List中所有整数的和
     *
     * @return
     */
    public long getIntegerSum() {
        ExecutorService exec = Executors.newFixedThreadPool(threadCounts);
        // 平均分割List
        int len = list.size() / threadCounts;
        // List中的数量没有线程数多（很少存在）
        if (len == 0) {
            // 采用一个线程处理任务
            threadCounts = list.size();
            len = list.size() / threadCounts;
        }

        barrier = new CyclicBarrier(threadCounts + 1);
        for (int i = 0; i < threadCounts; i++) {
            if (i == threadCounts - 1) {
                // 最后一个线程承担剩下的所有元素的计算
                exec.execute(new SubIntegerTask(list.subList(i * len, list.size())));
            } else {
                exec.execute(new SubIntegerTask(list.subList(i * len, len * (i + 1) > list.size() ? list.size() : len * (i + 1))));
            }
        }
        try {
            // 使该线程在障栅处等待，直到所有的线程都到达障栅处
            barrier.await();
        } catch (InterruptedException e) {
            log.info("{}:Interrupted", Thread.currentThread().getName());
        } catch (BrokenBarrierException e) {
            log.info("{}:BrokenBarrier", Thread.currentThread().getName());
        }
        exec.shutdown();
        return sum;
    }

    /**
     * 分割计算List整数和的线程任务
     */
    public class SubIntegerTask implements Runnable {
        private List<Integer> subList;

        public SubIntegerTask(List<Integer> subList) {
            this.subList = subList;
        }

        @Override
        public void run() {
            long subSum = 0L;
            for (Integer i : subList) {
                subSum += i;
            }
            synchronized (CyclicBarrierCountListSum.this) {
                sum += subSum;
            }
            try {
                // 使该线程在障栅处等待，直到所有的线程都到达障栅处
                barrier.await();
            } catch (InterruptedException e) {
                log.info("{}:Interrupted", Thread.currentThread().getName());
            } catch (BrokenBarrierException e) {
                log.info("{}:BrokenBarrier", Thread.currentThread().getName());
            }
            log.info("分配给线程：{} 那一部分List整数和为 subSum={}", Thread.currentThread().getName(), subSum);
        }
    }
}
