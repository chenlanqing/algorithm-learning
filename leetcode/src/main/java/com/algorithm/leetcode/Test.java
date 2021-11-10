package com.algorithm.leetcode;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月10日 17:35
 */
public class Test {

    public static void main(String[] args) {
//        System.out.println(Integer.parseInt("1010", 2));
//        System.out.println(Integer.toBinaryString(10));
        System.out.println(toBinary(10));
    }

    static String toBinary(int num) {
        String str = "";
        while (num != 0) {
            System.out.print(num + " % 2 = " + (num % 2) + ",\t");
            str = num % 2 + str;
            System.out.println(num + " / 2 = " + (num / 2));
            num = num / 2;
        }
        return str;
    }
}
