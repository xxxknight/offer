package chap4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符串的排列
 * 
 * 题目描述
 * 
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,
 * bca,cab和cba。 结果请按字母顺序输出。 输入描述: 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 
 * 
 */
public class Solution28 {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> res = new ArrayList<>();
		if (str == null || str.length() <= 0) {
			return res;
		}
		helper(res, str.toCharArray(), 0, str.length() - 1);
		Collections.sort(res);
		return res;
	}

	public void helper(ArrayList<String> res, char[] chars, int start, int end) {
		if (start == end) {
			StringBuilder sb = new StringBuilder();
			for (char c : chars) {
				sb.append(c);
			}
			if (sb.length() > 0) {
				res.add(sb.toString());
			}
		} else {
			for (int i = start; i <= end; i++) {
				if (i != start && chars[i] == chars[start]) {
					continue;
				}
				char tmp = chars[i];
				chars[i] = chars[start];
				chars[start] = tmp;

				helper(res, chars, start + 1, end);

				tmp = chars[i];
				chars[i] = chars[start];
				chars[start] = tmp;
			}

		}

	}

	public static void main(String[] args) {
		System.out.println(new Solution28().Permutation("aabc"));
	}
}
