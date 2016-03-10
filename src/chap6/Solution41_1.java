package chap6;

import java.util.ArrayList;

/**
 * 和为S的两个数字
 * 
 * 题目描述
 * 
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * 
 * @author founder
 * 
 */
public class Solution41_1 {

	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (array == null || array.length <= 1) {
			return res;
		}
		int head = 0;
		int tail = array.length - 1;
		while (head < tail) {
			if (array[head] + array[tail] < sum) {
				head++;
			} else if (array[head] + array[tail] > sum) {
				tail--;
			} else {
				res.add(array[head]);
				res.add(array[tail]);
				break;

			}
		}
		return res;
	}

}
