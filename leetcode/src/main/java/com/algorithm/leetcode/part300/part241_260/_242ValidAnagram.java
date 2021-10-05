package com.algorithm.leetcode.part300.part241_260;

import java.util.HashMap;
import java.util.Map;

/**
 * @author QingFan 2020-10-29
 * @version 1.0.0
 */
public class _242ValidAnagram {

    public static void main(String[] args) {
        System.out.println(new _242ValidAnagram().isAnagram_1("abc", "cba"));
        System.out.println(new _242ValidAnagram().isAnagram_1("anagram", "nagaram"));
        System.out.println(new _242ValidAnagram().isAnagram_1("rat", "car"));
    }

    public boolean isAnagram_1(String s, String t) {
        // 两个字符串必须长度相同，这个是前提，否则直接返回 False
        if ((s == null) || (t == null) || (t.length() != s.length())) {
            return false;
        }

        int n = s.length();

        // 创建哈希表
        Map<Character, Integer> counts = new HashMap<>();

        // 遍历其中一个字符串，记录字符出现的个数
        for (int i = 0; i < n; ++i) {
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
        }

        // 遍历另一个字符，在遍历过程中更新哈希表中的元素个数
        for (int i = 0; i < n; ++i) {
            counts.put(t.charAt(i), counts.getOrDefault(t.charAt(i), 0) - 1);
            // 如果发现哈希表中有不存在的元素或者计数为负数，直接返回 false
            if (counts.getOrDefault(t.charAt(i), -1) < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int size = s.length();
        char[] array = new char[26];
        for (int i = 0; i < size; i++) {
            array[s.charAt(i) - 'a']++;
            array[t.charAt(i) - 'a']--;
        }
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
