package chap8;

import java.util.Stack;

/**
 * 机器人的运动范围
 * 
 * 题目描述
 * 
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 =
 * 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 
 * @author founder
 * 
 */

public class Solution67 {
	class Pointer {
		int x;
		int y;

		public Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int movingCount(int threshold, int rows, int cols) {
		if (threshold <= 0) {
			return 0;
		}
		int count = 0;
		boolean[][] flag = new boolean[rows][cols];
		Stack<Pointer> stack = new Stack<Pointer>();
		stack.push(new Pointer(0, 0));
		flag[0][0] = true;
		while (!stack.isEmpty()) {
			Pointer p = stack.peek();
			// 向上走
			if ((p.x - 1 > 0) && !flag[p.x - 1][p.y]
					&& canTouch(p.x - 1, p.y, threshold)) {
				stack.push(new Pointer(p.x - 1, p.y));
				flag[p.x - 1][p.y] = true;
				continue;
			}
			if ((p.x + 1 < rows) && !flag[p.x + 1][p.y]
					&& canTouch(p.x + 1, p.y, threshold)) {
				stack.push(new Pointer(p.x + 1, p.y));
				flag[p.x + 1][p.y] = true;
				continue;
			}
			if ((p.y - 1 > 0) && !flag[p.x][p.y - 1]
					&& canTouch(p.x, p.y - 1, threshold)) {
				stack.push(new Pointer(p.x, p.y - 1));
				flag[p.x][p.y - 1] = true;
				continue;
			}
			if ((p.y + 1 < cols) && !flag[p.x][p.y + 1]
					&& canTouch(p.x, p.y + 1, threshold)) {
				stack.push(new Pointer(p.x, p.y + 1));
				flag[p.x][p.y + 1] = true;
				continue;
			}
			stack.pop();
			count++;
		}
		return count;

	}

	private boolean canTouch(int x, int y, int threshold) {
		int sum = 0;
		while (x > 0) {
			sum += x % 10;
			x /= 10;
		}
		while (y > 0) {
			sum += y % 10;
			y /= 10;
		}
		return sum > threshold ? false : true;
	}

}