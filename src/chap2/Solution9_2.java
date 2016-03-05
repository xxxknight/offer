package chap2;

/**
 * 矩形覆盖
 * 
 * 题目描述
 * 
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 */
public class Solution9_2 {
	public int RectCover(int target) {

		int res = 1;
		int a1 = 1;
		int a2 = 1;
		for (int i = 2; i <= target; i++) {
			res = a1 + a2;
			a1 = a2;
			a2 = res;
		}
		return res;
	}
}
