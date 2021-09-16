package com.algorithm.datastructure.stack;

/**
 * @author QingFan 2021/9/12
 * @version 1.0.0
 */
public class LongestValidParenthesesOpt {

    public static void main(String[] args) {
        longestValidParentheses("))((");
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0, max = 0;
        // 从左到右
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        // 从右到左
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }
}
