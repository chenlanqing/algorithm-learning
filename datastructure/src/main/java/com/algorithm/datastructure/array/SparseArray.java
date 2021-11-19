package com.algorithm.datastructure.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月17日 21:36
 */
public class SparseArray {

    public static void main(String[] args) {
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        System.out.println("原始数组");
        printArray(chessArr);
        System.out.println("稀疏数组");
        int[][] sparseArray = chessToSparseArray(chessArr);
        printArray(sparseArray);
        saveFile(sparseArray, "map.data");
        System.out.println("还原数组");

        printArray(sparseToChessArray(sparseArray));
        System.out.println("读文件还原");
        printArray(readFile("map.data"));
    }

    private static int[][] readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filename)))) {

            List<String> list = new ArrayList<>();
            String str = "";
            while ((str = reader.readLine()) != null) {
                list.add(str);
            }
            String lines = list.get(0);
            String[] split = lines.split("\t");
            int row = Integer.parseInt(split[0]);
            int col = Integer.parseInt(split[1]);
            int[][] res = new int[row][col];

            for (int i = 1; i < list.size(); i++) {
                split = list.get(i).split("\t");
                int m = Integer.parseInt(split[0]);
                int n = Integer.parseInt(split[1]);
                int val = Integer.parseInt(split[2]);
                res[m][n] = val;
            }
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveFile(int[][] arr, String filename) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filename)))) {
            StringBuilder sb;
            for (int i = 0; i < arr.length; i++) {
                sb = new StringBuilder();
                for (int j = 0; j < arr[0].length; j++) {
                    sb.append(arr[i][j]);
                    if (j != arr[0].length - 1) {
                        sb.append("\t");
                    }
                }
                sb.append("\n");
                writer.write(sb.toString());
                sb = null;
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[][] sparseToChessArray(int[][] arr) {
        int[][] chess = new int[arr[0][0]][arr[0][1]];
        for (int i = 1; i < arr.length; i++) {
            int[] rows = arr[i];
            chess[rows[0]][rows[1]] = rows[2];
        }
        return chess;
    }

    private static int[][] chessToSparseArray(int[][] arr) {
        int sum = getDataSum(arr);
        // 稀疏数组的每一行表示原始数组 arr 中的一个有效值；
        // sparse[?][0] 表示有效值的行索引；
        // sparse[?][1] 表示有效值的列索引；
        // sparse[?][2] 表示有效值的具体值数据；
        int[][] sparse = new int[sum + 1][3];
        // sparse[0][0] 表示原始数组的行数
        // sparse[0][1] 表示原始数组的列数
        // sparse[0][2] 表示原始数组中有效的数据个数
        // 所以其是从第一行开始存储有效值的数据
        sparse[0][0] = arr.length;
        sparse[0][1] = arr[0].length;
        sparse[0][2] = sum;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    // 第一行存储的是原始数组的信息
                    count++;
                    sparse[count][0] = i;
                    sparse[count][1] = j;
                    sparse[count][2] = arr[i][j];
                }
            }
        }
        return sparse;
    }

    /**
     * 获取二维数组中有效的数据个数：非0为有效数据个数
     */
    private static int getDataSum(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }
        return sum;
    }


    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
//            System.out.printf("[%d]\t\t", i);
            for (int j = 0; j < arr[0].length; j++) {
                // 左对齐，使用两个空格补齐 2 位数
                System.out.printf("%-2d\t", arr[i][j]);
            }
            System.out.println("");
        }
    }
}
