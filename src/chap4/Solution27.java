package chap4;

import java.util.Stack;

import chap2.TreeNode;

/**
 * 二叉搜索树与双向链表
 * 
 * 题目描述
 * 
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 */

public class Solution27 {
	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null
				|| (pRootOfTree.left == null && pRootOfTree.right == null)) {
			return pRootOfTree;
		}
		boolean isRoot = true;
		TreeNode p = pRootOfTree;
		TreeNode pre = null;

		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				if (isRoot) {
					pRootOfTree = p;
					pre = pRootOfTree;
					isRoot = false;
				} else {
					pre.right = p;
					p.left = pre;
					pre = p;
				}
				p = p.right;
			}
		}
		return pRootOfTree;
	}

}
