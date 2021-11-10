package com.algorithm.leetcode.number.part100.part1_20;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 *
 * @author bluefish 2019-04-06
 * @version 1.0.0
 */
public class _17LetterCombinationsOfPhoneNumber {


    private List<String> result = new ArrayList<>();

    private static String[] array = {
            "  ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "qprs",
            "tuv",
            "wxyz"
    };

    /**
     * s中保存了此时从digits[0~index-1]翻译得到的一个字母字符串，寻找和digits[index]匹配的字母，获得digits[0~index]翻译得到的解
     *
     * @param digits
     * @param index
     * @param s
     */
    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            result.add(s);
            return;
        }

        char c = digits.charAt(index);

        assert c >= '0' && c <= '9' && c != '1';

        String letter = array[c - '0'];
        for (int i = 0; i < letter.length(); i++) {
            findCombination(digits, index + 1, s + letter.charAt(i));
        }
    }

    public List<String> letterCombinations(String digits) {
        result.clear();

        if (StringUtils.isEmpty(digits)) {
            return new ArrayList<>();
        }

        findCombination(digits, 0, "");

        return result;
    }
}
