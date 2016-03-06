package chap4;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * 
 * 题目描述
 * 
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * 
 */

public class Solution20 {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int rlen = matrix.length;
		if (rlen == 0) {
			return res;
		}
		int clen = matrix[0].length;

		int x = 0;
		int y = 0;
		while (rlen > 0 && clen > 0) {
			if (rlen == 1 && clen == 1) {
				res.add(matrix[x][y]);
				break;
			} else if (rlen > 1 && clen == 1) {
				for (int i = 0; i < rlen; i++) {
					res.add(matrix[x + i][y]);
				}
				break;
			} else if (rlen == 1 && clen > 1) {
				for (int i = 0; i < clen; i++) {
					res.add(matrix[x][y + i]);
				}
				break;
			}
			for (int i = 0; i < clen - 1; i++) {
				res.add(matrix[x][y + i]);
			}
			for (int i = 0; i < rlen - 1; i++) {
				res.add(matrix[x + i][y + clen - 1]);
			}
			for (int i = 0; i < clen - 1; i++) {
				res.add(matrix[x + rlen - 1][y + clen - 1 - i]);
			}
			for (int i = 0; i < rlen - 1; i++) {
				res.add(matrix[x + rlen - 1 - i][y]);
			}
			x++;
			y++;
			rlen -= 2;
			clen -= 2;
		}
		return res;

	}

}
