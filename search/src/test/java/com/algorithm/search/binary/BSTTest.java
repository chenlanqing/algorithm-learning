package com.algorithm.search.binary;

import org.junit.Test;

import java.io.InputStream;
import java.util.Vector;

/**
 * Created by BlueFish on 2017/5/13.
 */
public class BSTTest {

    @Test
    public void testBSTAndSST(){
        String fileName = "bible-short.txt";
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
        Vector<String> words = new Vector<String>();
//        FileUtils.readFile(in, words);
        System.out.println("There are totally " + words.size() + " word in " + fileName);
        System.out.println("****************************************************");

        // 测试BST
        long start = System.currentTimeMillis();
        BST<String, Integer> bst = new BST<String, Integer>();

        for (String word :words){
            Integer res = bst.search(word);
            if (res == null){
                bst.insert(word, 1);
            } else {
                bst.insert(word ,res + 1);
            }
        }

        if (bst.contain("god")){
            System.out.println("'god' :" + bst.search("god"));
        } else {
            System.out.println("No word 'god' in " + fileName);
        }
        long end = System.currentTimeMillis();
        System.out.println("BST , time: " + (end - start) + "ms.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
