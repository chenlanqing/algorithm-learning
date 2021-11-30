package com.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * 删除最外层的括号
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月22日 16:56
 */
public class _1021_RemoveOuterParentheses {

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())"));
        System.out.println(removeOuterParentheses_1("(()()) (()) (()(()))"));
    }

    public static String removeOuterParentheses(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int i = 0;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                sb.append(c);
            }
            if (c == '(') {
                stack.push(c);
            }
            i++;
        }
        return sb.toString();
    }

    public static String removeOuterParentheses_1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int i = 0;
        int left = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(' && left++ > 0) {
                sb.append('(');
            }
            if (c == ')' && --left > 0) {
                sb.append(')');
            }
            i++;
        }
        return sb.toString();
    }
}
