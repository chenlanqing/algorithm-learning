package com.algorithm.common.datastructure.generic;

/**
 * @author QingFan 2021/10/5
 * @version 1.0.0
 */
public class ListNode<T> {
    public T value;
    public ListNode<T> next;
    public ListNode<T> pre;

    public ListNode() {
    }

    public ListNode(T value) {
        this.value = value;
    }


}
