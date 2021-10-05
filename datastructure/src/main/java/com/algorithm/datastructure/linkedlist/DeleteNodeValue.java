package com.algorithm.datastructure.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * @author QingFan 2021/9/5
 * @version 1.0.0
 */
public class DeleteNodeValue {

    public void deleteNode(ListNode node) {
        // 用后一个节点的值覆盖当前节点的值
        node.val = node.next.val;
        // 改变当前节点的 next 指针的指向，来删除后一个节点
        node.next = node.next.next;
    }
}
