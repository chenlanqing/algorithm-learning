package com.algorithm.interview.offer.day01;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * @author QingFan 2021/10/5
 * @version 1.0.0
 */
public class _09_QueueByTwoStack {

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

    static class CQueue {

        private Stack<Integer> in;
        private Stack<Integer> out;

        public CQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void appendTail(int value) {
            in.push(value);

        }

        public int deleteHead() {
            if (out.isEmpty() && in.isEmpty()) {
                return -1;
            }
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }
    }
}
