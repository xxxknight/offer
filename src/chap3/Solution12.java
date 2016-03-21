package chap3;

import java.util.Arrays;

/**
 * 打印1到最大的n位数
 * 
 * 题目描述
 * 
 * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999
 * 
 */

public class Solution12 {
	public void print(int n) {
		if (n <= 0) {
			return;
		}
		char[] chars = new char[n];
		Arrays.fill(chars, '0');
		while (!increment(chars)) {
			System.out.println(helper(chars));
		}
	}

	public String helper(char[] chars) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < chars.length) {
			if (chars[i] != '0') {
				break;
			}
			i++;
		}
		for (int j = i; j < chars.length; j++) {
			sb.append(chars[j]);
		}
		return sb.toString();
	}

	public boolean increment(char[] chars) {
		boolean isOverflow = false;
		int nTakeOver = 0;
		int len = chars.length;
		for (int i = len - 1; i >= 0; i--) {
			int nSum = chars[i] - '0' + nTakeOver;
			if (i == len - 1) {
				nSum++;
			}

			if (nSum == 10) {
				if (i == 0) {
					isOverflow = true;
				} else {
					nSum = 0;
					nTakeOver = 1;
					chars[i] = '0';
				}
			} else {
				chars[i] = (char) ('0' + nSum);
				break;
			}
		}
		return isOverflow;
	}

	public static void main(String[] args) {
		new Solution12().print(2);
	}

}
