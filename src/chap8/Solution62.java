package chap8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import chap2.TreeNode;

/**
 * 序列化二叉树
 * 
 * 题目描述
 * 
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 
 * @author founder
 * 
 */

public class Solution62 {
	String Serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		helper(root, sb);
		return sb.toString();
	}

	public void helper(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#,");
			return;
		}
		sb.append(root.val).append(",");
		helper(root.left, sb);
		helper(root.right, sb);
	}

	public TreeNode Deserialize(String str) {
		if (str == null || str.length() <= 0) {
			return null;
		}
		Queue<String> queue = new LinkedList<>(Arrays.asList(str.split(",")));
		return helper2(queue);
	}

	public TreeNode helper2(Queue<String> queue) {
		if (!queue.isEmpty()) {
			String val = queue.poll();
			if (val.equals("#")) {
				return null;
			} else {
				TreeNode node = new TreeNode(Integer.valueOf(val));
				node.left = helper2(queue);
				node.right = helper2(queue);
				return node;
			}
		}
		return null;
		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);

		root.left = t1;
		root.right = t2;

		Solution62 solution62 = new Solution62();
		String res = solution62.Serialize(root);
		System.out.println(res);
		System.out.println(solution62.Deserialize(res));

	}

}
