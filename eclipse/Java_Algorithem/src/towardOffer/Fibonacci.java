package towardOffer;

public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(new Fibonacci().fibonacci(4));
	}

	public int fibonacci(int n) {
		if (n < 2) {
			return n;
		}

		int pre = 1;
		int prepre = 0;
		for (int i = 1; i < n; i++) {
			int tmp = prepre;
			prepre = pre;
			pre = pre + tmp;
		}
		return pre;
	}
}
