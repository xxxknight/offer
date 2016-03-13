package chap8;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 滑动窗口的最大值
 * 
 * 题目描述
 * 
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 
 * @author founder
 * 
 */

public class Solution65 {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> res = new ArrayList<>();
		if (num.length >= size && size >= 1) {
			Deque<Integer> index = new LinkedList<>();

			for (int i = 0; i < size; i++) {
				while (!index.isEmpty() && num[i] >= num[index.peekLast()]) {
					index.poll();
				}
				index.push(i);
			}

			for (int i = size; i < num.length; i++) {
				res.add(num[index.getFirst()]);
				while (!index.isEmpty() && num[i] >= num[index.peekLast()]) {
					index.poll();
				}
				if (!index.isEmpty() && index.getFirst() <= (i - size)) {
					index.pollFirst();
				}
				index.push(i);
			}
			res.add(num[index.getFirst()]);
		}
		return res;

	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 2, 6, 2, 5, 1 };
		System.out.println(new Solution65().maxInWindows(arr, 3));
	}

}
