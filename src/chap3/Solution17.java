package chap3;

import chap2.ListNode;

/**
 * 合并两个排序的链表
 * 
 * 题目描述
 * 
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * 
 */

public class Solution17 {
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				head.next = list1;
				list1 = list1.next;
			} else {
				head.next = list2;
				list2 = list2.next;
			}
			head = head.next;

		}
		while (list1 != null) {
			head.next = list1;
			list1 = list1.next;
		}
		while (list2 != null) {
			head.next = list2;
			list2 = list2.next;
		}
		return dummy.next;
	}

}
