package com.algorithm.datastructure.bitmap;

public class KBitMap {

    private volatile long[] bitArray = new long[16];
    private volatile boolean free = true;

    public KBitMap(int size) {
        size = size >> 6;
        if (size < 8) {
            size = 8;
        }
        bitArray = new long[size];
    }

    public KBitMap(long[] arr) {
        bitArray = arr;
    }

    public int size() {
        return bitArray.length;
    }

    public void setBitOn(int i) {
        while (!free) {

        }
        if (i >= bitArray.length * 64) {
            resize(i);
        }

        bitArray[i >> 6] = (bitArray[i >> 6] | (1l << (i % 64)));
    }

    public void setBitOff(int i) {
        while (!free) {

        }
        if (i >= bitArray.length * 64) {
            resize(i);
        }

        bitArray[i >> 6] = (bitArray[i >> 6] & (Long.MAX_VALUE ^ (1l << i % 64)));
    }

    public int getBit(int i) {
        if (i >= bitArray.length * 64) {
            resize(i);
        }

        return (bitArray[i >> 6] & (1l << (i % 64))) > 0 ? 1 : 0;
    }

    private synchronized void resize(int i) {
        int len = bitArray.length;
        if (i >= len * 64) {
            free = false;
            int reLen = len;
            do {
                reLen = reLen + (reLen >> 3);
            } while (i >= reLen * 64);

            long[] newArry = new long[reLen];

            for (int j = 0; j < len - 1; j++) {
                newArry[j] = bitArray[j];
            }

            bitArray = newArry;
            free = true;
        }
    }

    public long[] getBitArray() {
        return bitArray;
    }

    public void setBitArray(long[] bitArray) {
        this.bitArray = bitArray;
    }
}