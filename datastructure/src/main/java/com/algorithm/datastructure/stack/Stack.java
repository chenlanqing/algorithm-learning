package com.algorithm.datastructure.stack;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月14日 11:10
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
