package chap8;

/**
 * 题目描述
 * 
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"
 * 都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 
 * @author founder
 * 
 */
public class Solution54 {
	public boolean isNumeric(char[] str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
		}
		String s = sb.toString();
		s = s.trim();
		if (s == null || s.length() == 0) {
			return false;
		}
		String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*([e|E][-+]?\\d+)?";
		if (s.matches(regex)) {
			return true;
		} else {
			return false;
		}
	}
}
