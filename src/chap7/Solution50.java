package chap7;

import java.util.Stack;

import chap2.TreeNode;

/**
 * 二叉树中两个结点的最低公共祖先
 * 
 * 1、情况一 该二叉树为二叉搜索树 2、情况二 该二叉树为二叉树（不一定为搜索树）
 * 
 * @author founder
 * 
 */

public class Solution50 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}

	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return left == null ? right : right == null ? left : root;
	}

	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		Stack<TreeNode> stack1 = new Stack<>();
		getNodePath(root, p, stack1);
		Stack<TreeNode> stack2 = new Stack<>();
		getNodePath(root, q, stack2);
		return getCommonNode(stack1, stack2);
	}

	public TreeNode getCommonNode(Stack<TreeNode> stack1, Stack<TreeNode> stack2) {
		int len1 = stack1.size();
		int len2 = stack2.size();

		if (len1 == 0 || len2 == 0) {
			return null;
		}

		int diff = len1 - len2;
		if (diff > 0) {
			int i = 0;
			while (!stack1.isEmpty() && i < diff) {
				stack1.pop();
			}
		} else if (diff < 0) {
			int i = 0;
			while (!stack2.isEmpty() && i < diff) {
				stack2.pop();
			}
		}

		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			TreeNode n1 = stack1.pop();
			TreeNode n2 = stack2.pop();
			if (n1 == n2) {
				return n1;
			}
		}
		return null;
	}

	public boolean getNodePath(TreeNode pRoot, TreeNode pNode,
			Stack<TreeNode> path) {
		if (pRoot == pNode) {
			return true;
		}
		boolean found = false;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(pRoot);
		while (!stack.isEmpty()) {
			TreeNode tmpNode = stack.pop();
			if (tmpNode == pNode) {
				stack.push(tmpNode);
				found = true;
				break;
			}

			if (tmpNode.left != null) {
				stack.add(tmpNode.left);
			}

			if (tmpNode.right != null) {
				stack.add(tmpNode.right);
			}

		}
		return found;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);

		root.left = t1;
		root.right = t2;

		System.out
				.println(new Solution50().lowestCommonAncestor3(root, t1, t2));
	}

}
