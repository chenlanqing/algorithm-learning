package com.algorithm.interview.offer.day03;

/**
 * @author QingFan 2021/10/7
 * @version 1.0.0
 */
public class _58_RotateString {

    public static void main(String[] args) {
        _58_RotateString d = new _58_RotateString();
        System.out.println(d.reverseLeftWords("abcdefg", 2));
        System.out.println(d.reverseLeftWords("lrloseumgh", 6));
    }

    public String reverseLeftWords(String s, int n) {
        if (s == null) {
            return "";
        }
        int len = s.length();
        if (len < n || n <= 0) {
            return "";
        }
        return "";
    }

    /**
     * abcdefg bagfedc cdefgab
     */
    public String reverseLeftWords_1(String s, int n) {
        if (s == null) {
            return "";
        }
        int len = s.length();
        if (len < n || n <= 0) {
            return "";
        }
        char[] arr = s.toCharArray();

        reverse(arr, 0, n - 1);
        reverse(arr, n, len - 1);
        reverse(arr, 0, len - 1);

        return new String(arr);
    }

    public void reverse(char[] arr, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
