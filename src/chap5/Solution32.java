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

	public static void main(String[] args) {
		System.out.println(new Solution32().NumberOf1Between1AndN_Solution(521));
	}

}
