package com.algorithm.interview.offer.day01;

import java.util.LinkedList;

/**
 * @author QingFan 2021/10/5
 * @version 1.0.0
 */
public class _30_MinStack {

    static class MinStack {

        private final LinkedList<Integer> list;
        private final LinkedList<Integer> minList;

        public MinStack() {
            list = new LinkedList<>();
            minList = new LinkedList<>();
        }

        public void push(int x) {
            if (list.isEmpty()) {
                list.push(x);
                minList.push(x);
            } else {
                list.push(x);
                int k = minList.peek();
                minList.push(Math.min(k, x));
            }
        }

        public void pop() {
            list.pop();
            minList.pop();
        }

        public int top() {
           return list.peek();
        }

        public int min() {
            return minList.peek();
        }
    }
}
