package chap3;

import chap2.ListNode;

/**
 * 链表中倒数第k个结点
 * 
 * 题目描述
 * 
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 */

public class Solution15 {
	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k <= 0) {
			return null;
		}

		ListNode fast = head;
		ListNode slow = fast;
		int cnt = 0;
		while (cnt < k) {
			if (fast == null) {
				return null;
			} else {
				fast = fast.next;
				cnt++;
			}
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;
	}

}
