package chap5;

import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * 数组中的逆序对
 * 
 * 题目描述
 * 
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 
 * 
 * 利用归并排序的思想
 * 
 * 
 * @author founder
 * 
 */

public class Solution36 {
	public int InversePairs(int[] array) {
		if (null == array || array.length <= 1) {
			return 0;
		}
		int[] copy = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		int res = helper(array, copy, 0, array.length - 1);
		return res;
	}

	public int helper(int[] array, int[] copy, int start, int end) {
		if (start == end) {
			copy[start] = array[start];
			return 0;
		}
		int len = (end - start) / 2;
		int left = helper(copy, array, start, start + len);
		int right = helper(copy, array, start + len + 1, end);

		int cnt = 0;
		int i = start + len;
		int j = end;
		int indexCopy = end;

		while (i >= start && j >= start + len + 1) {
			if (array[i] > array[j]) {
				copy[indexCopy--] = array[i--];
				cnt += j - start - len;
			} else {
				copy[indexCopy--] = array[j--];
			}
		}

		while (i >= start) {
			copy[indexCopy--] = array[i--];
		}

		while (j >= start + len + 1) {
			copy[indexCopy--] = array[j--];
		}
		return cnt + left + right;
	}

	public static void main(String[] args) {
		System.out.println(new Solution36()
				.InversePairs(new int[] { 7, 5, 6, 4 }));
	}

}
