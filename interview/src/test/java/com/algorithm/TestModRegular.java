package com.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author QingFan 2021/9/15
 * @version 1.0.0
 */
public class TestModRegular {

    private void mod(int a, int b, int p) {
        int r1 = (a + b) % p;
        int r2 = (a % p + b % p) % p;
        Assert.assertEquals(r1, r2);
    }

    private void mod1(int a, int b, int p) {
        int r1 = (a - b) % p;
        int r2 = (a % p - b % p + p) % p;
        Assert.assertEquals(r1, r2);
    }

    private void mod2(int a, int b, int p) {
        int r1 = (a * b) % p;
        int r2 = (a % p * b % p) % p;
        Assert.assertEquals(r1, r2);
    }

    private void mod3(int a, int b, int p) {
        int r1 = a ^ b % p;
        int r2 = ((a % p) ^ b) % p;
        Assert.assertEquals(r1, r2);
    }

    @Test
    public void testMod() {
        mod(25, 23, 7);
    }

    @Test
    public void testMod1() {
        mod1(25, 23, 7);
    }

    @Test
    public void testMod2() {
        mod2(25, 23, 7);
    }

    @Test
    public void testMod3() {
        mod3(25, 23, 7);
    }
}
