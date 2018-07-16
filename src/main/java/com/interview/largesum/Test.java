package com.interview.largesum;

import com.google.common.primitives.Ints;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class Test {

    public static void main(String[] args) {
        int[] array = IntStream.rangeClosed(0, 999999).toArray();

        List<Integer> list = Ints.asList(array);

       log.info("{}", list);

        CyclicBarrierCountListSum barrier = new CyclicBarrierCountListSum(list, 10);

        long integerSum = barrier.getIntegerSum();
        log.info("{}",integerSum);
    }
}
