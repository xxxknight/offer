package chap8;

import java.util.Stack;

import chap2.TreeNode;

/**
 * 二叉搜索树的第k个结点
 * 
 * 题目描述
 * 
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * 
 * @author founder
 * 
 */

public class Solution63 {
	public TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k <= 0) {
			return null;
		}

		Stack<TreeNode> stack = new Stack<>();
		int cnt = 1;
		while (!stack.isEmpty() || pRoot != null) {
			if (pRoot != null) {
				stack.add(pRoot);
				pRoot = pRoot.left;
			} else {
				pRoot = stack.pop();
				if (k == cnt) {
					return pRoot;
				}
				cnt++;
				pRoot = pRoot.right;
			}
		}
		return null;
	}
}
