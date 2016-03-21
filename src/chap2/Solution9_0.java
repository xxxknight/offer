package chap2;

/**
 * 斐波那契数列
 * 
 * 题目描述
 * 
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项 0 1 1 2 ....
 * 
 */
public class Solution9_0 {
	public int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else {
			int sum = 1;
			int t1 = 0;
			int t2 = 1;
			for (int i = 1; i < n; i++) {
				sum = t1 + t2;
				t1 = t2;
				t2 = sum;
			}
			return sum;
		}
	}
}
