package chap3;

import chap2.ListNode;

/**
 * 在O(1)的时间内删除节点
 * 
 * 题目描述
 * 
 * 给定单项链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 * 
 * 
 */

public class Solution13 {
	public void DeleteNode(ListNode head, ListNode node) {
		if (head == null || node == null) {
			return;
		}
		if (node.next != null) {
			node.val = node.next.val;
			node.next = node.next.next;
		} else if (head == node) {
			node = null;
			head = null;
		} else {
			ListNode tmp = head;
			while (tmp.next != node) {
				tmp = tmp.next;
			}
			tmp.next = null;
			node = null;
		}

	}

	public static void main(String[] args) {
	}

}
