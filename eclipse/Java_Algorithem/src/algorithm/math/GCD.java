package algorithm.math;

public class GCD {
	/**
	 * 求最大公约数
	 */
	public static int get(int m, int n) {
		if(m % n == 0) {
			return n;
		} else {
			return get(n, n % m);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(get(12, 6));
	}
}
