package com.algorithm.utils.array;

/**
 * @author bluefish 2019-05-04
 * @version 1.0.0
 */
public class Array {
    private int[] data;

    private int size;

    /**
     * 传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造器，默认数组的容量是10
     */
    public Array() {
        this(10);
    }

    /**
     * 数组元素的个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 将元素添加到最后
     *
     * @param e
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 将元素添加到第一个位置
     *
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在第index个位置插入一个元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            // TODO
            throw new IllegalArgumentException("Add failed, Array is full");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素
     *
     * @param index
     * @return
     */
    int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Get failed, Array index out of bound");
        }
        return data[index];
    }

    /**
     * 覆盖某个索引
     *
     * @param index
     * @param e
     */
    void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Get failed, Array index out of bound");
        }
        data[index] = e;
    }

    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找不到索引，返回-1
     *
     * @param e
     * @return
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array:size=%d, capacity=%d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
