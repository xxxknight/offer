package chap2;

/**
 * 旋转数组的最小数字
 * 
 * 题目描述
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减序列的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{
 * 1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * 
 * 注意：有可能存在相同元素
 */

public class Solution8 {
	public int minNumberInRotateArray(int[] array) {
		if (null == array || array.length <= 0) {
			return 0;
		}
		int low = 0;
		int high = array.length - 1;
		int mid = 0;

		while (low < high) {
			mid = low + (high - low) / 2;
			if (array[mid] > array[high]) {
				low = mid + 1;
			} else if (array[mid] < array[high]) {
				high = mid;
			} else {
				high--;
			}
		}
		return array[low];
	}
}
