package chap3;

/**
 * 数值的整数次方
 * 
 * 题目描述
 * 
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 
 * 
 */

public class Solution11 {
	public double Power(double base, int exponent) {
		if (base == 0 && exponent < 0) {
			return -1;
		}
		long newExp = Math.abs((long) exponent);
		double result = PowerWithUnsignedExponent(base, newExp);
		return exponent < 0 ? 1.0 / result : result;
	}

	public double PowerWithUnsignedExponent(double base, long exponent) {
		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}

		double result = PowerWithUnsignedExponent(base, exponent >> 1);
		result *= result;
		if ((exponent & 0x1) == 1) {
			result *= base;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new Solution11().Power(1, -2147483648));
	}

}
