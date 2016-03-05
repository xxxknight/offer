package chap2;

/**
 * 二进制中1的个数
 * 
 * 题目描述
 * 
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 
 */

public class Solution10 {
	public int NumberOf1(int n) {
		int res = 0;
		while (n != 0) {
			n = n & (n - 1); // 常用
			res++;
		}
		return res;
	}

}
