package chap3;

import chap2.ListNode;

/**
 * 反转链表
 * 
 * 题目描述
 * 
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * 
 * 
 */
public class Solution16 {
	public ListNode ReverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);

		while (head != null) {
			ListNode temp = head.next;
			head.next = dummy.next;
			dummy.next = head;
			head = temp;
		}
		return dummy.next;
	}

}
