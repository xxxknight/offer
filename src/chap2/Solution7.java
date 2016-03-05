package chap2;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 
 * 题目描述
 * 
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

public class Solution7 {
	// stack1负责添加元素，stack2负责删除元素
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);

	}

	public int pop() {
		if (!stack2.isEmpty()) {
			return stack2.pop();
		}
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}

}
