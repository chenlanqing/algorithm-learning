package com.algorithm.induction;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2023年03月07日 20:17
 */
public class ProveInductionTest {

    @Test
    public void test_prove() {
        int grid = 63;
        ProveInduction.Result result = new ProveInduction.Result();
        boolean prove = ProveInduction.prove(grid, result);
        Assertions.assertTrue(prove);
    }
}
