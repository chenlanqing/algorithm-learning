package com.algorithm.interview.offer.day03;

/**
 * @author QingFan 2021/10/7
 * @version 1.0.0
 */
public class _05_ReplaceSpace {

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        char[] arr = new char[len * 3];
        int size = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                arr[size++] = '%';
                arr[size++] = '2';
                arr[size++] = '0';
            } else {
                arr[size++] = c;
            }
        }
        return new String(arr, 0, size);
    }

    public String replaceSpace_1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
