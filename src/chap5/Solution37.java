package chap5;

import chap2.ListNode;

/**
 * 两个链表的第一个公共结点
 * 
 * 题目描述 输入两个链表，找出它们的第一个公共结点。
 * 
 * @author Administrator
 * 
 */
public class Solution37 {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		}
		int len1 = 0;
		int len2 = 0;
		ListNode dummy1 = pHead1;
		ListNode dummy2 = pHead2;
		while (pHead1 != null) {
			len1++;
			pHead1 = pHead1.next;
		}
		while (pHead2 != null) {
			len2++;
			pHead2 = pHead2.next;
		}
		if (len1 > len2) {
			int diff = len1 - len2;
			for (int i = 0; i < diff; i++) {
				dummy1 = dummy1.next;
			}
		} else {
			int diff = len2 - len1;
			for (int i = 0; i < diff; i++) {
				dummy2 = dummy2.next;
			}
		}
		while (dummy1 != null) {
			if (dummy1 == dummy2) {
				return dummy1;
			}
			dummy1 = dummy1.next;
			dummy2 = dummy2.next;
		}
		return null;
	}

}
