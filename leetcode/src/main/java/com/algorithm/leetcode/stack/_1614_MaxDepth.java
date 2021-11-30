package com.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * 括号的最大嵌套深度
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月22日 16:15
 */
public class _1614_MaxDepth {

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
        System.out.println(maxDepth("1+(2*3)/(2-1)"));
        System.out.println(maxDepth("8*((1*(5+6))*(8/6))"));
    }

    /**
     * 比如：(1+(2*3)+((8)/4))+1 其最大嵌套深度是 3
     */
    public static int maxDepth(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int max = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                // 考虑到多重嵌套，大于0就减去，否则直接赋值
                if (max > 0) {
                    max--;
                } else {
                    max = 0;
                }
            } else if (c == ')') {
                max++;
            }
            i++;
        }
        return max;
    }
}
