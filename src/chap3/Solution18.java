package chap3;

import chap2.TreeNode;

/**
 * 树的子结构
 * 
 * 题目描述
 * 
 * 输入两颗二叉树A，B，判断B是不是A的子结构。
 * 
 * 
 */

public class Solution18 {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				result = isTree1HaveTree2(root1, root2);
			}
			if (!result) {
				result = HasSubtree(root1.left, root2);
			}
			if (!result) {
				result = HasSubtree(root1.right, root2);
			}
		}
		return result;
	}

	public boolean isTree1HaveTree2(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}

		if (root1.val != root2.val) {
			return false;
		}
		return isTree1HaveTree2(root1.left, root2.left)
				&& isTree1HaveTree2(root1.right, root2.right);

	}
}
