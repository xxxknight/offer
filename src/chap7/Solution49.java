package chap7;

/**
 * 把字符串转换成整数
 * 
 * 题目描述
 * 
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 
 * @author founder
 * 
 */

public class Solution49 {
	public int StrToInt(String str) {
		str = str.trim();
		if (null == str || "".equals(str)) {
			return 0;
		} else {
			long res = 0;
			int flag = 1;
			if (str.charAt(0) == '-') {
				flag = -1;
			} else if (str.charAt(0) == '+') {
				flag = 1;
			} else if (isNum(str.charAt(0))) {
				res = str.charAt(0) - '0';
			} else {
				return 0;
			}
			for (int i = 1; i < str.length(); i++) {
				if (!isNum(str.charAt(i))) {
					return 0;
				} else {
					res = res * 10 + (str.charAt(i) - '0');
				}
			}

			res *= flag;
			if (res > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if (res < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}

			return (int) (res);

		}

	}

	public boolean isNum(char c) {
		if (c <= '9' && c >= '0') {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution49().StrToInt("-123"));
	}

}
