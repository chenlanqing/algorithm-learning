package com.algorithm.datastructure.queue;

/**
 * 实现循环队列：循环队列关键是如何确定队列是空的或者什么时候扩容的；
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月14日 22:50
 */
@SuppressWarnings("unchecked")
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        // 数据存储容量 + 1，保证有一个元素是空着的；
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public int getCapacity() {
        return data.length - 1;
    }

//    @Override
//    public int getSize() {
//        return size;
//    }

    @Override
    public int getSize(){
        // 如果没有size属性：
        // 注意此时getSize的逻辑:
        // 如果tail >= front，非常简单，队列中的元素个数就是tail - front
        // 如果tail < front，说明我们的循环队列"循环"起来了，此时，队列中的元素个数为：
        // tail - front + data.length
        // 也可以理解成，此时，data中没有元素的数目为front - tail,
        // 整体元素个数就是 data.length - (front - tail) = data.length + tail - front
        return tail >= front ? tail - front : tail - front + data.length;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        // 循环队列，对数组长度取模
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        // 如果容量小于1/4，则缩容到一半数据；
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){

        LoopQueue<Integer> queue = new LoopQueue<>(5);
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}
