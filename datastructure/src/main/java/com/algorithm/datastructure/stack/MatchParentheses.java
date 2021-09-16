package com.algorithm.datastructure.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * @author QingFan 2021/9/11
 * @version 1.0.0
 */
public class MatchParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop == '(' && c != ')') {
                    return false;
                }
                if (pop == '[' && c != ']') {
                    return false;
                }
                if (pop == '{' && c != '}') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
