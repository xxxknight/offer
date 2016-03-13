package chap8;

import chap2.ListNode;

/**
 * 链表中环的入口结点
 * 
 * 题目描述
 * 
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * 
 * @author founder
 * 
 */

public class Solution56 {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return null;
		}
		ListNode res = searchMeeting(pHead);
		ListNode temp = pHead;
		while (res != temp) {
			res = res.next;
			temp = temp.next;
		}
		return res;

	}

	// 寻找快慢指针相遇点
	public ListNode searchMeeting(ListNode pHead) {
		ListNode fast;
		ListNode slow;
		slow = fast = pHead;
		while (slow.next != null || fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return fast;
			}
		}
		return null;
	}

}
