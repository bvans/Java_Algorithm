package huaweiOJ;

import java.util.Scanner;

public class DrinkBottles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int total = sc.nextInt();
			if (total == 0) {
				return;
			} else {
				System.out.println(total / 2);
			}

		}
	}
}
