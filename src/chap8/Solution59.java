package chap8;

import chap2.TreeNode;

/**
 * 对称的二叉树
 * 
 * 题目描述
 * 
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 
 * @author founder
 * 
 */
public class Solution59 {
	boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null) {
			return true;
		}
		return helper(pRoot.left, pRoot.right);
	}

	boolean helper(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		
		if (t1 == null || t2 == null) {
			return false;
		}

		if (t1.val != t2.val) {
			return false;
		}
		return helper(t1.right, t2.left) && helper(t1.left, t2.right);
	}

}
