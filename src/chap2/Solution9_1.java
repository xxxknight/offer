package chap2;

/**
 * 跳台阶
 * 
 * 题目描述
 * 
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 */
public class Solution9_1 {
	public int JumpFloor(int target) {
		if (target == 0) {
			return 0;
		}
		int sum = 1;
		int t1 = 1;
		int t2 = 1;
		for (int i = 2; i <= target; i++) {
			sum = t1 + t2;
			t1 = t2;
			t2 = sum;
		}

		return sum;

	}
}
