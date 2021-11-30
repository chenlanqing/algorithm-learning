package com.algorithm.datastructure.bitmap;

import com.googlecode.javaewah.EWAHCompressedBitmap;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月28日 15:43
 */
public class BitMapDemo {

    public static void main(String[] args) {
        EWAHCompressedBitmap map = new EWAHCompressedBitmap();
        map.set(1);
        map.set(2);
        map.set(400000);

        System.out.println(map.toString());
    }
}
