package chap5;

/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * 
 * 题目描述
 * 
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13
 * 因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * 
 * @author Administrator
 * 
 */

public class Solution32 {
	public int NumberOf1Between1AndN_Solution(int n) {
		int res = 0;
		long curDigit = 0;
		long highDigit = 0;
		long lowDigit = 0;
		long factor = 1;

		while (n / factor > 0) {
			curDigit = (n % (factor * 10)) / factor;
			highDigit = n / (factor * 10);
			if (curDigit == 0) {
				res += highDigit * factor;
			} else if (curDigit == 1) {
				res += highDigit * factor + lowDigit + 1;
			} else {
				res += (highDigit + 1) * factor;
			}
			lowDigit += curDigit * factor;
			factor *= 10;
		}
		return res;
	}

	public int NumberOf1Between1AndN_Solution2(int n) {
		if (n <= 0) {
			return 0;
		}
		return helper(n + "");
	}

	private int helper(String str) {
		if (null == str || "".equals(str) || str.charAt(0) < '0'
				|| str.charAt(0) > '9') {
			return 0;
		}

		int first = str.charAt(0) - '0';

		int len = str.length();

		if (len == 1 && first == 0) {
			return 0;
		}

		if (len == 1 && first > 0) {
			return 1;
		}

		int numFirstDigit = 0;
		if (first > 1) {
			numFirstDigit = (int) Math.pow(10, len - 1);
		} else if (first == 1) {
			numFirstDigit = Integer.parseInt(str.substring(1)) + 1;
		}

		int numOtherDigits = (int) (first * (len - 1) * Math.pow(10, len - 2));
		int numRecursive = helper(str.substring(1));

		return numFirstDigit + numOtherDigits + numRecursive;
	}

	public static void main(String[] args) {
		System.out
				.println(new Solution32().NumberOf1Between1AndN_Solution(521));
	}

}
