package chap4;

/**
 * 二叉搜索树的后序遍历序列
 * 
 * 题目描述
 * 
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

public class Solution24 {
	// check if 后序遍历
	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence.length < 1) {
			return false;
		}
		return helper(sequence, 0, sequence.length - 1);
	}

	private boolean helper(int[] array, int first, int last) {
		if (array == null || last - first < 1) {
			return true;
		}
		int root = array[last];
		int index = first;
		while (index < last) {
			if (array[index] > root) {
				break;
			}
			index++;
		}
		int j = index;
		while (j < last) {
			if (array[j] < root) {
				return false;
			}
			j++;
		}
		boolean left = helper(array, first, index - 1);
		boolean right = helper(array, index, last - 1);
		return left && right;
	}

	// check if 前序遍历
	public boolean VerifySquenceOfBST2(int[] sequence) {
		if (sequence.length < 1) {
			return false;
		}
		return helper2(sequence, 0, sequence.length - 1);
	}

	public boolean helper2(int[] arr, int first, int end) {
		if (arr == null || end - first < 1) {
			return true;
		}
		int root = arr[first];
		int index = first + 1;
		while (index <= end && arr[index] < root) {
			index++;
		}
		int tmp = index;
		while (index <= end) {
			if (arr[index] < root) {
				return false;
			}
			index++;
		}
		boolean left = helper(arr, first + 1, tmp - 1);
		boolean right = helper(arr, tmp, end);
		return left && right;
	}

	public static void main(String[] args) {
		int[] num1 = { 5, 7, 6, 9, 11, 10, 8 };
		int[] num2 = { 4, 2, 3, 1 };
		Solution24 test = new Solution24();

		System.out.println(test.VerifySquenceOfBST(num1));
		System.out.println(test.VerifySquenceOfBST2(num2));
	}
}
