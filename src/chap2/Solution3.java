package chap2;

/**
 * 题目描述
 * 
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。 输入描述: array： 待查找的二维数组 target：查找的数字
 * 
 * 
 * 输出描述: 查找到返回true，查找不到返回false
 * 
 * tag: 二分查找
 * 
 * @author xxxknight
 *
 */
public class Solution3 {
	public boolean Find(int[][] array, int target) {
		if (null == array || null == array[0]) {
			return false;
		}
		int row = array.length;
		int col = array[0].length;
		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
