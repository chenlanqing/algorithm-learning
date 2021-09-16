package com.algorithm.common.algorithm;


/**
 * @author bluefish 2019-07-21
 * @version 1.0.0
 */
public class SumBigNumber {

    public static void main(String[] args) {
        String result = sumBigNumber("571234599999999678", "456782424222424909");
        System.out.println(result);
    }

    /**
     * 大数的加法：按照小学学的列竖式的方式实现加法
     * <pre>
     *      1 2 3 4 5 6 7 8
     * +    4 5 6 7 8 9 0 9
     * ---------------------
     *      5 8 0 2 4 5 8 7
     * </pre>
     * <p>
     * 一般超过long的数据我们可以用字符串来存储，可以将其存入到数据组，把整数倒序存储，整数的个位存于数组0下标位置，最高位存于数组长度-1下标位置
     *
     * @param aNum
     * @param bNum
     * @return
     */
    public static String sumBigNumber(String aNum, String bNum) {
        int aLen = aNum.length();
        int bLen = bNum.length();
        int maxLength = aLen > bLen ? aLen : bLen;

        // 构建数组
        int[] arrA = new int[maxLength + 1];
        for (int i = 0; i < aLen; i++) {
            arrA[i] = aNum.charAt(aLen - 1 - i) - '0';
        }
        // 构建数据
        int[] arrB = new int[maxLength + 1];
        for (int i = 0; i < bLen; i++) {
            arrB[i] = bNum.charAt(bLen - 1 - i) - '0';
        }

        // 定义的结果数组要比最长的数组加1，防止进位
        int[] result = new int[maxLength + 1];
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            temp += arrA[i];
            temp += arrB[i];
            // 判断是否需要进位操作
            if (temp >= 10) {
                temp = temp - 10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }

        // 将result数组转换成字符串，需要注意下最高位是否为0，即数组的最后的数据是否为0
        StringBuilder sb = new StringBuilder();
        boolean firstZero = false;

        for (int i = result.length - 1; i >= 0; i--) {
            if (!firstZero) {
                if (result[i] == 0) {
                    continue;
                }
                firstZero = true;
            }
            sb.append(result[i]);
        }


        return sb.toString();
    }
}
