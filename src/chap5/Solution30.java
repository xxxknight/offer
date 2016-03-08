package chap5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的K个数
 * 
 * 题目描述
 * 
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 * @author Administrator
 * 
 */

public class Solution30 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		if (input == null || input.length <= 0 || k <= 0 || k > input.length) {
			return res;
		}
		Queue<Integer> queue = new PriorityQueue<>(11,
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return o2 - o1;
					}
				});

		for (int i = 0; i < k; i++) {
			queue.offer(input[i]);
		}

		for (int i = k; i < input.length; i++) {
			int max = queue.peek();
			if (input[i] >= max) {
				continue;
			} else {
				queue.poll();
				queue.offer(input[i]);
			}
		}

		Iterator<Integer> iterator = queue.iterator();
		while (iterator.hasNext()) {
			res.add(iterator.next());
		}
		return res;

	}

	public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		if (input == null || input.length <= 0 || k <= 0 || k > input.length) {
			return res;
		}
		int start = 0;
		int end = input.length - 1;
		int index = partition(input, start, end);
		while (index != k - 1) {
			if (index > k - 1) {
				end = index - 1;
				index = partition(input, start, end);
			} else {
				start = index + 1;
				index = partition(input, start, end);
			}
		}

		for (int i = 0; i < k; i++) {
			res.add(input[i]);
		}
		return res;

	}

	public int partition(int[] input, int i, int j) {
		int pivot = input[i];
		while (i < j) {
			while ((i < j) && input[j] > pivot) {
				j--;
			}
			input[i] = input[j];
			while ((i < j) && input[i] < pivot) {
				i++;
			}
			input[j] = input[i];
		}
		input[j] = pivot;
		return i;
	}

	public static void main(String[] args) {
		System.out.println(new Solution30().GetLeastNumbers_Solution(new int[] {
				4, 5, 1, 6, 2, 7, 3, 8 }, 4));
	}

}
