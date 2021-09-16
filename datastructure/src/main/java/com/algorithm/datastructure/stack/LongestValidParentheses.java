package com.algorithm.datastructure.stack;

import java.util.Stack;

/**
 * @author QingFan 2021/9/12
 * @version 1.0.0
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
