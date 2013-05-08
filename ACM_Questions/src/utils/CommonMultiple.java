package utils;

public class CommonMultiple {

	
	/**
	 * @param a
	 * @param b
	 * @return 求两个数的最小公倍数
	 */
	public static long getMinCommonMultiple(long a, long b) {
		long gb = 0;
		gb = (a / CommonDivisor.getMaxCommonDivisor(a, b))*b;
		return gb;
	}
	     
	     
	     
}
