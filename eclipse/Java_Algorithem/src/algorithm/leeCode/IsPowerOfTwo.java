package algorithm.leeCode;

public class IsPowerOfTwo {
	public static void main(String[] args) {
		for (int i = -242523; i < 999999; i++) {
			if (isPowerOfTwo(i))
				System.out.printf("%d ", i);
		}
	}

	public static boolean isPowerOfTwo(int n) {
		if (n == 1) {
			return true;
		}

		if (n <= 0 || n % 2 != 0) {
			return false;
		}

		return isPowerOfTwo(n >> 1);
	}

	public static boolean isPowerOfTwo2(int n) {
		if (n <= 1) {
			return false;
		}
		return (n & (n - 1)) == 0;
	}
}
