package chap8;

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
	// Insert one char from stringstream
	private HashMap<Character, Integer> hs = new HashMap<>();
	private static int index = 0;

	public void Insert(char ch) {
		if (hs.containsKey(ch)) {
			hs.put(ch, -2);
		} else {
			hs.put(ch, ++index);
		}

	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		int minIndex = Integer.MAX_VALUE;
		char ch = '#';
		for (int i = 0; i < 256; i++) {
			char c = (char) ('#' + i - 35);
			if (hs.containsKey(c) && hs.get(c) > 0 && hs.get(c) < minIndex) {
				minIndex = hs.get(c);
				ch = c;
			}
		}
		return ch;
	}

	public static void main(String[] args) {
		Solution55 solution55 = new Solution55();
		solution55.Insert('g');
		System.out.println(solution55.FirstAppearingOnce());
		solution55.Insert('o');
		System.out.println(solution55.FirstAppearingOnce());
		solution55.Insert('o');
		System.out.println(solution55.FirstAppearingOnce());
		solution55.Insert('g');
		System.out.println(solution55.FirstAppearingOnce());
		solution55.Insert('l');
		System.out.println(solution55.FirstAppearingOnce());
		solution55.Insert('e');
		System.out.println(solution55.FirstAppearingOnce());

	}
}
