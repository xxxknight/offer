package chap6;

import java.text.DecimalFormat;

/**
 * n个骰子的点数
 * 
 * 题目描述：
 * 
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n,打印出s的所有可能。
 * 
 * @author founder
 * 
 */

public class Solution43 {
	public void print(int number) {
		if (number < 1) {
			return;
		}
		int[][] pro = new int[2][6 * number + 1];
		int flag = 0;
		for (int i = 1; i <= 6; i++) {
			pro[flag][i] = 1;
		}

		for (int k = 2; k <= number; k++) {
			for (int i = 0; i < k; i++) {
				pro[1 - flag][i] = 0;
			}

			for (int i = k; i <= 6 * k; i++) {
				pro[1 - flag][i] = 0;
				for (int j = 1; j <= i && j <= 6; j++) {
					pro[1 - flag][i] += pro[flag][i - j];
				}
			}
			flag = 1 - flag;
		}

		DecimalFormat df = new DecimalFormat("0.0000");
		double total = Math.pow(6, number);
		double sum = 0;
		for (int i = number; i <= 6 * number; i++) {
			double ratio = pro[flag][i] / total;
			sum += ratio;
			System.out.println(i + ": " + df.format(ratio));
		}
		System.out.println("sum: " + df.format(sum));
	}

	public static void main(String[] args) {
		new Solution43().print(2);
	}

}
