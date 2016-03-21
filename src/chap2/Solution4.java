package chap2;

/**
 * 替换空格
 * 
 * 题目描述
 * 
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * 
 */
public class Solution4 {
	public String replaceSpace(StringBuffer str) {
		if (str == null) {
			return null;
		} else {
			int cnt0 = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '0') {
					cnt0++;
				}
			}
			// 算出长度以减少数组的复制
			StringBuffer sb = new StringBuffer(cnt0);
			for (int i = str.length() - 1; i >= 0; i--) {
				char c = str.charAt(i);
				if (c == ' ') {
					sb.insert(0, "%20");
				} else {
					sb.insert(0, str.charAt(i));
				}

			}
			return sb.toString();
		}

	}

}
