package chap8;

import java.util.Arrays;
import java.util.Stack;

/**
 * 矩阵中的路径
 * 
 * 题目描述
 * 
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，
 * 向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e
 * 
 * 矩阵中包含一条字符串
 * "bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * 
 * @author founder
 * 
 */

public class Solution66 {
	boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (matrix == null || str == null || cols == 0 || rows == 0) {
			return false;
		}
		boolean[] ins = new boolean[matrix.length];

		// 需要遍历
		for (int i = 0; i < matrix.length; i++) {
			Arrays.fill(ins, false);
			if (matrix[i] == str[0]) {
				ins[i] = true;
				Stack<Integer> stack = new Stack<Integer>();
				stack.add(i);
				int count = 1; // 计算已匹配的字符数量
				int index = 0;
				while (count != str.length && stack.size() != 0) {
					int j = stack.peek();
					// 上
					index = (j / cols - 1) * cols + j % cols;
					if ((j / cols - 1) >= 0 && !ins[index]
							&& matrix[index] == str[count]) {
						stack.add(index);
						ins[index] = true;
						count++;
						continue;
					}
					// 下
					index = (j / cols + 1) * cols + j % cols;
					if ((j / cols + 1) < rows && !ins[index]
							&& matrix[index] == str[count]) {
						stack.add(index);
						ins[index] = true;
						count++;
						continue;
					}
					// 左
					index = (j / cols) * cols + j % cols - 1;
					if ((j % cols - 1) >= 0 && !ins[index]
							&& matrix[index] == str[count]) {
						stack.add(index);
						ins[index] = true;
						count++;
						continue;
					}
					// 右
					index = (j / cols) * cols + j % cols + 1;
					if ((j % cols + 1) < cols && !ins[index]
							&& matrix[index] == str[count]) {
						stack.add(index);
						ins[index] = true;
						count++;
						continue;
					}
					stack.pop();
					count--;
				}
				if (count == str.length)
					return true;
			}
		}
		return false;
	}

}
