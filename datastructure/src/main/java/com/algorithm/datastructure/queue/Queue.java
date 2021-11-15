package com.algorithm.datastructure.queue;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月14日 22:46
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
