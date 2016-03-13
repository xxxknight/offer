package chap8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import chap2.TreeNode;

/**
 * 按之字形顺序打印二叉树
 * 
 * 题目描述
 * 
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印， 第三行按照从左到右的顺序打印，其他行以此类推。
 * 
 * @author founder
 * 
 */

public class Solution61 {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(pRoot);

		int i = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			while (size > 0) {
				TreeNode outNode = queue.poll();
				if (i % 2 == 0) {
					tempList.add(outNode.val);
				} else {
					tempList.add(0, outNode.val);
				}

				if (outNode.left != null) {
					queue.add(outNode.left);
				}
				if (outNode.right != null) {
					queue.add(outNode.right);
				}
				size--;
			}
			res.add(tempList);
			i++;
		}
		return res;
	}
}
