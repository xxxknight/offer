package chap3;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 
 * 题目描述
 * 
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，
 * 偶数和偶数之间的相对位置不变。
 * 
 * 
 */
public class Solution14 {
	public void reOrderArray(int[] a) {
		if (a == null || a.length == 0)
			return;
		int i = 0, j;
		while (i < a.length) {
			while (i < a.length && !isEven(a[i]))
				i++;
			j = i + 1;
			while (j < a.length && isEven(a[j]))
				j++;
			if (j < a.length) {
				int tmp = a[j];
				for (int j2 = j - 1; j2 >= i; j2--) {
					a[j2 + 1] = a[j2];
				}
				a[i++] = tmp;
			} else {// 查找失敗
				break;
			}
		}
		System.out.println(Arrays.toString(a));
	}

	boolean isEven(int n) {
		if (n % 2 == 0)
			return true;
		return false;
	}

	public void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static void main(String[] args) {
		new Solution14().reOrderArray(new int[] { 5, 4, 3, 2, 1 });
	}

}
