package chap6;

/**
 * 翻转单词顺序列
 * 
 * 题目描述
 * 
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a
 * student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 
 * @author founder
 * 
 */

public class Solution42_1 {
	/***** 反转单个字符串函数 ****/
	public void reverseStr(char[] StrArr, int start, int end) {
		if (StrArr == null)
			return;

		while (start < end) {
			char temp = StrArr[start];
			StrArr[start++] = StrArr[end];
			StrArr[end--] = temp;
		}

		// return StrArr;
	}

	/**
	 * 根据单词进行反转 策略是先反转整个字符串，在根据空格划分单词，然后依次反转每个单词
	 */
	public String ReverseSentence(String dataStr) {
		if (dataStr == null || dataStr.length() == 0)
			return dataStr;

		char[] dataArr = dataStr.toCharArray();

		// 反转整个字符串
		int start = 0;
		int end = dataStr.length() - 1;

		reverseStr(dataArr, start, end);

		for (int i = 0; i < dataArr.length; i++) {
			System.out.println(dataArr[i]);
		}

		// 类似于双指针法，根据空格划分单词
		start = end = 0;

		while (start < dataStr.length()) {
			// 如果start为空格，则跳过它不把它识别为单词的一部分
			if (dataArr[start] == ' ') {
				start++;
				end++;
			}
			// 当end指针移到字符串数组末尾，或者当前为空格，则start指针到end指针之间构成一个单词
			else if (end == dataStr.length() || dataArr[end] == ' ') {
				// 注意end已经对应单词末尾后面一位，要注意先自减
				reverseStr(dataArr, start, --end);
				// 开始识别下一个单词
				start = ++end;
			} else {
				// 此为一般情况，end指针一直后移
				end++;
			}
		}

		return new String(dataArr);

	}

}
