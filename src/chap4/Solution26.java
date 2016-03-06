package chap4;

import java.util.HashMap;

/**
 * 复杂链表的复制
 * 
 * 题目描述
 * 
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 * 
 * 
 */
public class Solution26 {
	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null) {
			return null;
		}
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode temp = pHead;
		while (temp != null) {
			map.put(temp, new RandomListNode(temp.label));
			temp = temp.next;
		}

		temp = pHead;
		while (temp != null) {
			map.get(temp).next = map.get(temp.next);
			map.get(temp).random = map.get(temp.random);
			temp = temp.next;
		}
		return map.get(pHead);

	}

}
