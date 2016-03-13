package chap8;

import chap2.ListNode;

/**
 * 删除链表中重复的结点
 * 
 * 题目描述
 * 
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 * 
 * @author founder
 * 
 */

public class Solution57 {
	public ListNode deleteDuplication(ListNode pHead) {
		ListNode dummy = new ListNode(0);
		dummy.next = pHead;
		pHead = dummy;
		while (pHead.next != null && pHead.next.next != null) {
			if (pHead.next.val == pHead.next.next.val) {
				int val = pHead.next.val;
				while (pHead.next != null && pHead.next.val == val) {
					pHead.next = pHead.next.next;
				}
			} else {
				pHead = pHead.next;
			}
		}
		return dummy.next;
	}

}
