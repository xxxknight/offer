package chap6;

import chap2.TreeNode;

/**
 * 平衡二叉树
 * 
 * 题目描述
 * 
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 
 * @author founder
 * 
 */

public class Solution39_2 {
	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root) != -1;

	}

	public int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left);
		if (left == -1) {
			return -1;
		}
		int right = helper(root.right);
		if (right == -1) {
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
}
