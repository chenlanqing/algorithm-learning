package com.algorithm.hash.consistent;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2023年02月21日 20:20
 */
public interface HashFunction {

    long hash(String key);
}
