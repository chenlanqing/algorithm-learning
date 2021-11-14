package com.algorithm.datastructure.array;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月14日 10:08
 */
@SuppressWarnings("unchecked")
public class DynamicArray<E> {

    private E[] tables;
    private int capacity;
    private int size;

    private final static int DEFAULT_CAPACITY = 1 << 4;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }


    public DynamicArray(int capacity) {
        tables = (E[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        add(e, size);
    }

    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("非法参数");
        }
        if (size >= capacity - 1) {
            resize(capacity * 2);
        }
        if (index < size) {
            System.arraycopy(tables, index, tables, index + 1, size - index + 1);
        }
        tables[index] = e;
        size++;
    }

    public void set(E e, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("非法参数");
        }
        tables[index] = e;
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public void addLast(E e) {
        add(e);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("非法参数");
        }
        E e = tables[index];
        System.arraycopy(tables, index + 1, tables, index, size - index + 1);
        size--;
        return e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("非法参数");
        }
        return tables[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return tables[size - 1];
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (tables[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (tables[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 比较容量与实际大小
     */
    private void resize(int capacity) {
        this.capacity = capacity;
        E[] newTable = (E[]) new Object[capacity];
        System.arraycopy(tables, 0, newTable, 0, size);
        tables = newTable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(tables[i]).append("\t");
        }
        return sb.toString();
    }

}
