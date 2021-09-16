package com.algorithm.leetcode.part300.part241_260;

/**
 * @author QingFan 2020-10-29
 * @version 1.0.0
 */
public class _242ValidAnagram {

    public static void main(String[] args) {
        System.out.println(new _242ValidAnagram().isAnagram("abc", "cba"));
        System.out.println(new _242ValidAnagram().isAnagram("anagram", "nagaram"));
        System.out.println(new _242ValidAnagram().isAnagram("rat", "car"));
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
