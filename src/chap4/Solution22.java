package chap4;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 
 * 题目描述
 * 
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5
 * 是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * 
 */

public class Solution22 {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || popA == null) {
			return false;
		}

		int pushALen = pushA.length;
		int popALen = popA.length;
		if (pushALen == 0 || popALen == 0 || pushALen != popALen) {
			return false;
		}
		Stack<Integer> stack = new Stack<Integer>();

		int iPush = 0;
		int iPop = 0;
		while (iPop < popALen) {
			while (stack.isEmpty() || stack.peek() != popA[iPop]) {
				if (iPush == pushALen) {
					break;
				}
				stack.push(pushA[iPush]);
				iPush++;
			}

			if (stack.peek() != popA[iPop]) {
				return false;
			}
			stack.pop();
			iPop++;
		}

		if (stack.isEmpty() && iPop == popALen) {
			return true;
		}
		return false;
	}

}
