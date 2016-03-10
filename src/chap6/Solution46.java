package chap6;

/**
 * 求1+2+3+...+n
 * 
 * 题目描述
 * 
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 
 * 
 */

public class Solution46 {
	public int Sum_Solution(int n) {
		int sum = n;
		boolean f = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new Solution46().Sum_Solution(10));
	}
}
