package chap5;

/**
 * 把数组排成最小的数
 * 
 * 题目描述
 * 
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 * 
 * @author founder
 * 
 */

public class Solution33 {
	public String PrintMinNumber(int[] numbers) {
		String res = "";
		if (numbers.length == 0) {
			return res;
		}

		for (int i = 0; i < numbers.length; i++) {
			int index = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (compare(numbers[j], numbers[index]) == -1) {
					index = j;
				}
			}
			if (index != i) {
				int temp = numbers[i];
				numbers[i] = numbers[index];
				numbers[index] = temp;
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			res += numbers[i];
		}
		return res;

	}

	public int compare(int a, int b) {
		String s1 = String.valueOf(a);
		String s2 = String.valueOf(b);
		int len1 = s1.length();
		int len2 = s2.length();
		int len = Math.min(len1, len2);
		int i = 0;
		for (; i < len; i++) {
			if (s1.charAt(i) > s2.charAt(i)) {
				return 1;
			} else if (s1.charAt(i) < s2.charAt(i)) {
				return -1;
			}
		}

		if (len < len1) {
			int j = i;
			int tail2 = s2.charAt(i - 1);
			while (j < len1) {
				if (s1.charAt(j) > tail2) {
					return 1;
				} else if (s1.charAt(j) < tail2) {
					return -1;
				}
				j++;
			}
		}

		if (len < len2) {
			int k = i;
			int tail1 = s1.charAt(i - 1);
			while (k < len2) {
				if (tail1 > s2.charAt(k)) {
					return 1;
				} else if (tail1 < s2.charAt(k)) {
					return -1;
				}
				k++;
			}
		}
		return 0;
	}

}
