package chap4;

import java.util.Stack;

/**
 * 包含min函数的栈(leetcode 最小栈问题)
 * 
 * 题目描述
 * 
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 
 * 
 */

public class Solution21 {
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();

	public void push(int node) {
		stack.push(node);
		if (minStack.isEmpty() || node < minStack.peek()) {
			minStack.push(node);
		}
	}

	public void pop() {
		if (!minStack.isEmpty() && minStack.peek() == stack.peek()) {
			minStack.pop();
		}
		stack.pop();
	}

	public int top() {
		if (!stack.isEmpty()) {
			return stack.peek();
		} else {
			return -1;
		}
	}

	public int min() {
		if (!minStack.isEmpty()) {
			return minStack.peek();
		} else {
			return -1;
		}
	}

}
