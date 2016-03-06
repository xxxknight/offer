package chap4;

import java.util.ArrayList;

import chap2.TreeNode;

/**
 * 二叉树中和为某一值的路径
 * 
 * 题目描述
 * 
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 
 */

public class Solution25 {
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return res;
		}
		help(res, root, target, new ArrayList<Integer>(), 0);
		return res;
	}

	private void help(ArrayList<ArrayList<Integer>> res, TreeNode root,
			int sum, ArrayList<Integer> cur, int curSum) {
		if (root == null) {
			return;
		}
		curSum += root.val;
		cur.add(root.val);
		if (root.left == null && root.right == null && curSum == sum) {
			res.add(new ArrayList<Integer>(cur));
		}
		if (root.left != null) {
			help(res, root.left, sum, cur, curSum);
		}
		if (root.right != null) {
			help(res, root.right, sum, cur, curSum);
		}
		cur.remove(cur.size() - 1);
	}

}
