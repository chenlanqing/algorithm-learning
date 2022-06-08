package com.algorithm.interview.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年03月18日 20:06
 */
public class LongNoDupStr {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbb"));
    }

    private static int lengthOfLongestSubstring(String s) {
        //获取原字符串的长度
        int len = s.length();
        //维护一个哈希集合的窗口
        Set<Character> windows = new HashSet<>();
        int left = 0, right = 0;
        int res = 0;

        while (right < len) {
            char c = s.charAt(right);
            //窗口右移
            right++;

            //判断是否左边窗口需要缩减，如果已经包含，那就需要缩减
            while (windows.contains(c)) {
                windows.remove(s.charAt(left));
                left++;
            }
            windows.add(c);
            //比较更新答案
            res = Math.max(res, windows.size());
        }
        return res;
    }
}
