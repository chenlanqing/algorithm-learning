package com.algorithm.datastructure.queue;

import com.algorithm.datastructure.linkedlist.LinkedList;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月14日 22:49
 */
public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> head;

    public LinkedListQueue() {
        head = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return head.getSize();
    }

    @Override
    public boolean isEmpty() {
        return head.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        head.addFirst(e);
    }

    @Override
    public E dequeue() {
        return head.removeLast();
    }

    @Override
    public E getFront() {
        return head.getFirst();
    }
}
