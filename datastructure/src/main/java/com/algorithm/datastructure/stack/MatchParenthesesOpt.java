package com.algorithm.datastructure.stack;

/**
 * 括号匹配优化版本：存在问题
 *
 * @author QingFan 2021/9/11
 * @version 1.0.0
 * @see MatchParenthesesOpt
 */
public class MatchParenthesesOpt {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        // 小括号
        int parentheses = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                parentheses++;
            } else {
                if (parentheses == 0) {
                    return false;
                } else {
                    parentheses --;
                }
            }
        }
        return parentheses == 0;
    }
}
