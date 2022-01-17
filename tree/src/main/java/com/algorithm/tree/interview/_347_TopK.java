package com.algorithm.tree.interview;

import com.algorithm.common.utils.ArrayUtils;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年01月14日 15:32
 */
public class _347_TopK {

    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        ArrayUtils.print(topKFrequent(nums, 2), 6);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.add(entry.getKey());
            } else if (entry.getValue() > map.get(pq.peek())) {
                pq.remove();
                pq.add(entry.getKey());
            }
        }
        int[] res = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.remove();
        }
        return res;
    }
}
