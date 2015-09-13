package towardOffer;

public class NumberOf1 {

	public static int getNumOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}

		return count;
	}
}
