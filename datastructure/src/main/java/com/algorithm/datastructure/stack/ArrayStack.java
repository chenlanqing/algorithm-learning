package com.algorithm.datastructure.stack;

import com.algorithm.common.datastructure.primitive.Array;
import com.algorithm.datastructure.array.DynamicArray;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月14日 12:06
 */
public class ArrayStack<E> implements Stack<E> {

    private DynamicArray<E> array;

    public ArrayStack() {
        array = new DynamicArray<>();
    }

    public ArrayStack(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
