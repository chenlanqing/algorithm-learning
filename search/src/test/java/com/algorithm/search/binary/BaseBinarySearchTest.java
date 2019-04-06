package com.algorithm.search.binary;

import org.junit.Before;
import org.junit.Test;

public class BaseBinarySearchTest {

    BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
    int N = 10;
    int M = 100;

    int temp;

    @Before
    public void init(){
        for(int i = 0 ; i < N ; i ++){
            Integer key = new Integer((int)(Math.random()*M));
            // 为了后续测试方便,这里value值取和key值一样
            bst.insert(key, key);
            if (i == 5){
                temp = key;
            }
            System.out.print(key + " ");
        }
        System.out.println();
    }

    @Test
    public void test6(){
//        bst = new BinarySearchTree<Integer, Integer>();
//        bst.insert(41, 41);
//        bst.insert(22, 22);
//        bst.insert(15, 15);
//        bst.insert(13, 13);
//        bst.insert(33, 33);
//        bst.insert(37, 37);
//        bst.insert(58, 58);
//        bst.insert(50, 50);
//        bst.insert(60, 60);
//        bst.insert(42, 42);
//        bst.insert(53, 53);
//        bst.insert(59, 59);
//        bst.insert(63, 63);


        System.out.println("size: " + bst.size());
        System.out.print("preOrder: ");
        bst.preOrder();
        System.out.println();
        bst.remove(temp);
        System.out.print("preOrder: ");
        bst.preOrder();
    }

    public void test5(){
        System.out.println("size: " + bst.size());
        System.out.print("preOrder: ");
        bst.preOrder();
        System.out.println();
        bst.removeMax();
        System.out.print("remove: ");
        bst.preOrder();
    }


    public void test4(){
        System.out.println("minimum: " + bst.minimum());
        System.out.println("maximum: " + bst.maximum());
    }


    // 测试二分搜索树的遍历
    @Test
    public void test3(){
        // 测试二分搜索树的size()
        System.out.println("size: " + bst.size());
        System.out.println();

        // 测试二分搜索树的前序遍历 preOrder
        System.out.println("preOrder: ");
        bst.preOrder();
        System.out.println();

        // 测试二分搜索树的中序遍历 inOrder
        System.out.println("inOrder: ");
        bst.midOrder();
        System.out.println();

        // 测试二分搜索树的后序遍历 postOrder
        System.out.println("postOrder: ");
        bst.postOrder();
        System.out.println();

        // 测试二分搜索树的层序遍历 levelOrder
        System.out.println("levelOrder: ");
        bst.levelOrder();
        System.out.println();

        // 测试二分搜索树的层序遍历 maxDepth
        System.out.println("maxDepth: ");
        System.out.println(bst.maxDepth());
    }
}
