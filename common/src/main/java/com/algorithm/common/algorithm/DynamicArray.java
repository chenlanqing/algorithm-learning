package com.algorithm.common.algorithm;


/**
 * @author QingFan 2020-11-12
 * @version 1.0.0
 */
public class DynamicArray<E> {
    private E[] data;
    private int size;

    public DynamicArray(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public DynamicArray() {
        this(10);
    }

    public int capacity() {
        return data.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Argument failed, Require index >= 0 or index <= size");
        }
        if (size == data.length) {
            // 扩容两倍
            resize(2 * data.length);
        }
        // 往后移一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addLast(E e) {
        add(e, size);
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Argument failed, Require index >= 0 or index <= size");
        }
        return data[index];
    }

    public void set(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Argument failed, Require index >= 0 or index <= size");
        }
        data[index] = e;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contain(E e) {
        return find(e) != -1;
    }

    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        if (size >= 0) {
            System.arraycopy(data, 0, newData, 0, size);
        }
        data = newData;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Argument failed, Require index >= 0 or index <= size");
        }
        E result = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        // 缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return result;
    }
}
