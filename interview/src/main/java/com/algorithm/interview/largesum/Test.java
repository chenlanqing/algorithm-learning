package com.algorithm.interview.largesum;

import com.google.common.primitives.Ints;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class Test {

    public static void main(String[] args) {
        Instant start = Instant.now();
        int[] array = IntStream.rangeClosed(0, 999999).toArray();

        List<Integer> list = Ints.asList(array);


        log.info("{}", list);

        CyclicBarrierCountListSum barrier = new CyclicBarrierCountListSum(list, 10);

        long integerSum = barrier.getIntegerSum();
        log.info("{}", integerSum);

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());
    }
}
