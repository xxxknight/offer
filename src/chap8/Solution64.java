package chap8;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 
 * 题目描述
 * 
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。 如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * 
 * @author founder
 * 
 */

public class Solution64 {
	// 大根堆
	private PriorityQueue<Integer> pq1 = new PriorityQueue<>(11,
			new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});

	// 小根堆
	private PriorityQueue<Integer> pq2 = new PriorityQueue<>();

	public void Insert(Integer num) {
		if (pq1.isEmpty()) {
			pq1.add(num);
		} else if (pq1.size() > pq2.size()) {
			if (num >= pq1.peek()) {
				pq2.add(num);
			} else {
				pq2.add(pq1.poll());
				pq1.add(num);
			}
		} else {
			if (num <= pq2.peek()) {
				pq1.add(num);
			} else {
				pq1.add(pq2.poll());
				pq2.add(num);
			}
		}
	}

	public Double GetMedian() {
		if (pq1.size() == pq2.size()) {
			return (pq1.peek() + pq2.peek()) / 2.0;
		} else {
			return pq1.peek() / 1.0;
		}
	}

}
