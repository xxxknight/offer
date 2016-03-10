package chap6;

import java.util.LinkedList;

/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 * 
 * 题目描述
 * 
 * 每年六一儿童节,NowCoder都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为NowCoder的资深元老,自然也准备了一些小游戏。其中,
 * 有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m的那个小朋友要出列唱首歌,
 * 然后可以在礼品箱中任意的挑选礼物
 * ,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演
 * ,并且拿到NowCoder名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？
 * 
 * @author founder
 * 
 */

public class Solution45 {
	public int LastRemaining_Solution(int n, int m) {
		if (n <= 0 || m <= 0) {
			return -1;
		}
		LinkedList<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			queue.offer(i);
		}

		int cur = 0;
		while (queue.size() > 1) {
			cur += m;
			cur = cur % queue.size() - 1;
			if (cur >= 0) {
				queue.remove(cur);
			} else {
				queue.remove(queue.size() - 1);
				cur = 0;
			}
		}
		return queue.get(0);

	}

	public int LastRemaining_Solution2(int n, int m) {
		if (n <= 0 || m <= 0) {
			return -1;
		}
		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
		return last;
	}

	public static void main(String[] args) {
		System.out.println(new Solution45().LastRemaining_Solution2(5, 3));
	}
}
