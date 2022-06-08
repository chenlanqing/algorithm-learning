package com.algorithm.tree.balance;

import com.algorithm.common.utils.FileUtils;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年01月19日 20:46
 */
public class TestAVL {

    public static void main(String[] args) {

        System.out.println(new Date());

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileUtils.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }

}
