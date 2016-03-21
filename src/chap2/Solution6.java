package chap2;

/**
 * 重建二叉树
 * 
 * 题目描述
 * 
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,
 * 5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 */

public class Solution6 {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length <= 0 || in.length <= 0
				|| pre.length != in.length) {
			return null;
		}
		return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	public TreeNode construct(int[] pre, int pStart, int pEnd, int[] in,
			int iStart, int iEnd) {
		if (pStart > pEnd || iStart > iEnd) {
			return null;
		}

		int rootVal = pre[pStart];
		TreeNode root = new TreeNode(rootVal);
		if (pStart == pEnd) {
			return root;
		}
		int index = 0;
		for (int i = iStart; i <= iEnd; i++) {
			if (rootVal == in[i]) {
				index = i;
				break;
			}
		}

		int leftSize = index - iStart;
		int rightSize = iEnd - index;

		root.left = construct(pre, pStart + 1, pStart + leftSize, in, iStart,
				index - 1);
		root.right = construct(pre, pEnd - rightSize + 1, pEnd, in, index + 1,
				iEnd);
		return root;

	}
}