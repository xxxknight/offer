package chap8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import chap2.TreeNode;

/**
 * 把二叉树打印成多行
 * 
 * 题目描述
 * 
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 
 * @author founder
 * 
 */
public class Solution60 {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		if (pRoot == null) {
			return res;
		}
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(pRoot);

		while (!queue.isEmpty()) {

			ArrayList<Integer> temp2 = new ArrayList<Integer>();
			int size = queue.size();
			while (size > 0) {
				TreeNode curNode = queue.poll();
				temp2.add(curNode.val);
				if (curNode.left != null) {
					queue.add(curNode.left);
				}
				if (curNode.right != null) {
					queue.add(curNode.right);
				}
				size--;
			}
			res.add(temp2);
		}
		return res;
	}

}
