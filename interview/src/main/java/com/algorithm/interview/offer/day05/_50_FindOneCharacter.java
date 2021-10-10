package com.algorithm.interview.offer.day05;

import java.util.HashMap;

/**
 * @author QingFan 2021/10/9
 * @version 1.0.0
 */
public class _50_FindOneCharacter {

    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母
     * <pre>
     * 输入：s = "abaccdeff"
     * 输出：'b'
     * </pre>
     * 使用hashmap存储，key为字符，value为布尔，如果出现一次，为true，出现两次或两次以上为false
     */
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        HashMap<Character, Boolean> map = new HashMap<>(s.length());
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, false);
            } else {
                map.put(c, true);
            }
        }
        for (char c : chars) {
            Boolean res = map.get(c);
            if (res) {
                return c;
            }
        }
        return ' ';
    }
}
