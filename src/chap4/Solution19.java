package chap4;

import chap2.TreeNode;

/**
 * 二叉树的镜像
 * 
 * 题目描述

操作给定的二叉树，将其变换为源二叉树的镜像。 
输入描述:
二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 * 
 * @author Administrator
 *
 */
public class Solution19 {
	public void Mirror(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			return;
		}
		TreeNode tmpNode = root.left;
		root.left = root.right;
		root.right = tmpNode;
		
		if (root.left != null) {
			Mirror(root.left);
		}
		
		if (root.right != null) {
			Mirror(root.right);
		}
    }

}
