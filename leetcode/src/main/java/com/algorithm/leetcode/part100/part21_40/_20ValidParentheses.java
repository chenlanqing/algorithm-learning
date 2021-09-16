package com.algorithm.leetcode.part100.part21_40;

import java.util.Stack;

/**
 * 括号匹配： https://leetcode.com/problems/valid-parentheses/
 *
 * @author QingFan 2020-11-08
 * @version 1.0.0
 */
public class _20ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
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

    public static void main(String[] args) {
        _20ValidParentheses valid = new _20ValidParentheses();
        System.out.println(valid.isValid("()"));
        System.out.println(valid.isValid("()[]{}"));
        System.out.println(valid.isValid("([)]"));
    }
}
