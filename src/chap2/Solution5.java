package chap2;

import java.util.ArrayList;

/**
 * 从尾到头打印链表
 * 
 * 题目描述
 * 
 * 输入一个链表，从尾到头打印链表每个节点的值。 输入描述: 输入为链表的表头
 * 
 * 
 * 输出描述: 输出为需要打印的“新链表”的表头
 * 
 * 
 */

public class Solution5 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (listNode == null) {
			return res;
		} else {
			while (listNode != null) {
				res.add(0, listNode.val);
				listNode = listNode.next;
			}
			return res;
		}
	}

	// 利用递归
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (listNode == null) {
			return res;
		} else {
			helper(listNode, res);
			return res;
		}

	}

	private void helper(ListNode node, ArrayList<Integer> list) {
		if (node == null) {
			return;
		}
		helper(node.next, list);
		list.add(node.val);

	}

}
