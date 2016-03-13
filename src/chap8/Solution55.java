package chap8;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 字符流中第一个不重复的字符
 * 
 * 题目描述
 * 
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。 输出描述: 如果当前字符流没有存在出现一次的字符，返回#字符。
 * 
 * @author founder
 * 
 */

public class Solution55 {
	private ArrayList<Character> list = new ArrayList<Character>();

	// Insert one char from stringstream
	public void Insert(char ch) {
		list.add(ch);
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		int len = list.size();
		if (len == 0) {
			return '#';
		} else if (len == 1) {
			return list.get(0);
		} else {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < list.size(); i++) {
				if (map.containsKey(list.get(i))) {
					map.put(list.get(i), map.get(list.get(i)) + 1);
				} else {
					map.put(list.get(i), 1);
				}
			}

			for (int i = 0; i < list.size(); i++) {
				if (map.get(list.get(i)) == 1) {
					return list.get(i);
				}
			}
		}
		return '#';
	}
}
