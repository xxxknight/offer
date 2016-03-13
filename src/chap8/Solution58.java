package chap8;

/**
 * 二叉树的下一个结点
 * 
 * 题目描述
 * 
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 
 * 
 */
public class Solution58 {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		}
		// 保存要查找的下一个节点
		TreeLinkNode target = null;

		if (pNode.right != null) {
			target = pNode.right;
			while (target.left != null) {
				target = target.left;
			}
			return target;
		} else if (pNode.next != null) {
			target = pNode.next;
			TreeLinkNode cur = pNode;
			// 如果当前节点是父节点的左孩子，则直接返回父节点即可
			// 如果父新结点不为空，并且，子结点不是父结点的左孩子
			while (target != null && target.left != cur) {
				cur = target;
				target = target.next;
			}
			return target;
		}

		return null;
	}

}
