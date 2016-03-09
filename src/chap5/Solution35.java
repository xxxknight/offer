package chap5;

import java.util.Arrays;

/**
 * 第一个只出现一次的字符位置
 * 
 * 题目描述
 * 
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符的位置。若为空串，返回-1。位置索引从0开始
 * 
 * 
 * @author founder
 * 
 */

public class Solution35 {
	public int FirstNotRepeatingChar(String str) {
		if (str == null || str.length() == 0) {
			return -1;
		}
		int[] num = new int[256];
		Arrays.fill(num, 0);
		for (int i = 0; i < str.length(); i++) {
			num[str.charAt(i) - 'A']++;
		}
		for (int i = 0; i < str.length(); i++) {
			if (num[str.charAt(i) - 'A'] == 1) {
				return i;
			}
		}
		return -1;
	}

}
