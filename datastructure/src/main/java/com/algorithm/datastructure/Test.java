package com.algorithm.datastructure;

import com.algorithm.datastructure.array.DynamicArray;
import com.algorithm.datastructure.stack.ArrayStack;
import java.util.Arrays;

/**
 * @author bluefish 2019-04-04
 * @version 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
