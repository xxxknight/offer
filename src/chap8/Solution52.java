package chap8;

import java.util.Arrays;

/**
 * 构建乘积数组
 * 
 * 题目描述
 * 
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A
 * [i+1]*...*A[n-1]。不能使用除法。
 * 
 * @author founder
 * 
 */
public class Solution52 {
	public int[] multiply(int[] A) {
		if (A == null || A.length <= 1) {
			return A;
		}
		int[] B = new int[A.length];

		int len = A.length;

		B[0] =1;
		for (int i = 1; i < len; i++) {
			B[i] = B[i - 1] * A[i - 1];
		}

		int tmp = 1;
		for (int i = len - 2; i >= 0; i--) {
			tmp *= A[i + 1];
			B[i] *= tmp;
		}
		return B;

	}

}
