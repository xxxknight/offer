package chap6;

/**
 * 数组中只出现一次的数字
 * 
 * 题目描述
 * 
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 
 * @author founder
 * 
 */

public class Solution40 {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array == null || array.length < 2) {
			return;
		} else {
			int xor = array[0];
			for (int i = 1; i < array.length; i++) {
				xor ^= array[i];
			}
			int mask = 1;
			while ((mask & xor) == 0) {
				mask <<= 1;
			}
			num1[0] = 0;
			num2[0] = 0;
			for (int i = 0; i < array.length; i++) {
				if ((array[i] & mask) == 0) {
					num1[0] ^= array[i];
				} else {
					num2[0] ^= array[i];
				}
			}
		}
	}

}
