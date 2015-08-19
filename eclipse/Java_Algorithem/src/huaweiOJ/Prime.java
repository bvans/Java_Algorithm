package huaweiOJ;

import java.util.Scanner;

public class Prime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int num = sc.nextInt();

			int p1 = -1;
			int p2 = -1;
			for (int i = 2; i <= num / 2; i++) {
				if (isPrime(i) && isPrime(num - i)) {
					p2 = i;
					if (getDist(p2, num) < getDist(p1, num)) {
						p1 = p2;
						p2 = -1;
					}
				}
			}

			System.out.printf("%d %d", p1, num - p1);
			System.out.println();
		}

	}

	public static int getDist(int p, int num) {
		return Math.abs(p - (num - p));
	}

	public static boolean isPrime(int num) {
		if (num == 2) {
			return true;
		}

		if (num == 1 || num <= 0) {
			return false;
		}

		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
