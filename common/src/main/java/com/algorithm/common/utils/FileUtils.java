package com.algorithm.common.utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

/**
 * 文件操作类
 */
public class FileUtils {

    public static boolean readFile(InputStream in, Vector<String> words) {
        if (in == null) {
            return false;
        }
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedInputStream(in), "UTF-8");
            scanner.useLocale(Locale.ENGLISH);
        } catch (Exception e) {
            System.out.println("Cannot open" + e);
            return false;
        }
        if (scanner.hasNextLine()) {
            String contents = scanner.useDelimiter("\\A").next();
            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); ) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else
                    i++;
            }
        }
        return false;
    }

    /**
     * 寻找字符串s中，从start的位置开始的第一个字母字符的位置
     *
     * @param s
     * @param start
     * @return
     */
    private static int firstCharacterIndex(String s, int start) {

        for (int i = start; i < s.length(); i++)
            if (Character.isLetter(s.charAt(i)))
                return i;
        return s.length();
    }
}
