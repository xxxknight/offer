package chap6;

/**
 * 左旋转字符串
 * 
 * 题目描述
 * 
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出
 * 。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * 
 * @author founder
 * 
 */

public class Solution42_2 {
	public String LeftRotateString(String str, int n) {
		if (null == str || str.length() <= 1 || n <= 0) {
			return str;
		}
		int len = str.length();
		n = n % len;
		char[] chars = str.toCharArray();

		reverseStr(chars, 0, len - 1);
		reverseStr(chars, 0, len - n - 1);
		reverseStr(chars, len - n, len - 1);
		return new String(chars);
	}

	/***** 反转单个字符串函数 ****/
	public void reverseStr(char[] StrArr, int start, int end) {
		if (StrArr == null)
			return;

		while (start < end) {
			char temp = StrArr[start];
			StrArr[start++] = StrArr[end];
			StrArr[end--] = temp;
		}

		// return StrArr;
	}

}
