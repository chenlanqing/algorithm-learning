package com.algorithm.leetcode.array;

import java.util.PriorityQueue;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年08月07日 17:25
 */
public class _295_MedianFinder {

}

class MedianFinder {

	/**
	 * 小顶堆
	 */
	private PriorityQueue<Integer> large;
	/**
	 * 大顶堆
	 */
	private PriorityQueue<Integer> small;

	public MedianFinder() {
		// 小顶堆
		large = new PriorityQueue<>();
		// 大顶堆
		small = new PriorityQueue<>((a, b) -> {
			return b - a;
		});
	}

	public double findMedian() {
		// 如果元素不一样多，多的那个堆的堆顶元素就是中位数
		if (large.size() < small.size()) {
			return small.peek();
		} else if (large.size() > small.size()) {
			return large.peek();
		}
		// 如果元素一样多，两个堆堆顶元素的平均数是中位数
		return (large.peek() + small.peek()) / 2.0;
	}

	public void addNum(int num) {
		// 维护 large 和 small 的元素个数之差不超过 1，还要维护 large 堆的堆顶元素要大于等于 small 堆的堆顶元素
		if (small.size() >= large.size()) {
			small.offer(num);
			large.offer(small.poll());
		} else {
			large.offer(num);
			small.offer(large.poll());
		}
	}
}

