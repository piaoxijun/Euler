package utils;

public class CommonDivisor {

	/**
	 * @param a
	 * @param b
	 * @return 求两个数的最大公约数
	 */
	public static long getMaxCommonDivisor(long a, long b) {
		long m = 1;
		// 如果a小于b则交换位置
		if (a < b) {
			m = a;
			a = b;
			b = m;
		}
		while (m != 0) {
			m = a % b;
			a = b;
			b = m;
		}
		return a;
	}
}
