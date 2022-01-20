package com.algorithm.tree.trie;

import com.algorithm.common.utils.FileUtils;
import java.util.ArrayList;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年01月17日 12:13
 */
public class TrieTest {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(FileUtils.readFile("pride-and-prejudice.txt", words)){
            long startTime = System.nanoTime();
            Trie trie = new Trie();
            for(String word: words)
                trie.add(word);
            for(String word: words)
                trie.contains(word);
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: " + time + " s");
        }
    }
}
