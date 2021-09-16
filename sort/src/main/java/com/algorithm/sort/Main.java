package com.algorithm.sort;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = reader.readLine()) != null) {
            int n = Integer.valueOf(str);
            List<String> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                list.add(line);
            }

            for (String s : list) {
                int length = s.length();
                if (length <= 8) {
                    System.out.println(endZero(s));
                } else {
                    int count = length % 8 == 0 ? length / 8 : length / 8 + 1;
                    for (int i = 0; i < count; i++) {
                        int start = i * 8;
                        int end = (i + 1) * 8 > length ? length : (i + 1) * 8;
                        String split = s.substring(start, end);
                        System.out.println(endZero(split));
                    }
                }
            }
        }
    }

    private static String endZero(String s) {
        int size = s.length();
        int zeroLen = 8 - size;
        StringBuilder sBuilder = new StringBuilder(s);
        for (int i = 0; i < zeroLen; i++) {
            sBuilder.append("0");
        }
        return sBuilder.toString();
    }
}
