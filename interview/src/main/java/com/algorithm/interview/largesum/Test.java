package com.algorithm.interview.largesum;

import com.google.common.primitives.Ints;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

    public static void main(String[] args) {
        Instant start = Instant.now();
        int[] array = IntStream.rangeClosed(0, 999999).toArray();

        List<Integer> list = Ints.asList(array);

        System.out.println(list.size());

        CyclicBarrierCountListSum barrier = new CyclicBarrierCountListSum(list, 10);

        long integerSum = barrier.getIntegerSum();
        System.out.println(integerSum);

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());
    }
}
