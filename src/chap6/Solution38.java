package chap6;

/**
 * 数字在排序数组中出现的次数
 * 
 * 题目描述
 * 
 * 统计一个数字在排序数组中出现的次数。
 * 
 * @author founder
 * 
 */

public class Solution38 {
	public int GetNumberOfK(int[] array, int k) {
		int number = 0;
		if (null != array && array.length > 0) {
			int first = getFirstK(array, k);
			int last = getLastK(array, k);
			if (first > -1 && last > -1) {
				number = last - first + 1;
			}
		}
		return number;
	}

	public int getFirstK(int[] array, int k) {
		int start = 0;
		int end = array.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == k) {
				if (mid == 0 || array[mid - 1] != k) {
					return mid;
				} else {
					end = mid - 1;
				}
			} else if (array[mid] > k) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public int getLastK(int[] array, int k) {
		int start = 0;
		int end = array.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == k) {
				if (mid == array.length - 1 || array[mid + 1] != k) {
					return mid;
				} else {
					start = mid + 1;
				}
			} else if (array[mid] > k) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 3, 3, 3, 4, 5 };
		System.out.println(new Solution38().GetNumberOfK(array, 3));
	}
}
