package huaweiOJ;

import java.util.Scanner;

public class CountOf1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int data = sc.nextInt();
			int count = 0;
			while (data != 0) {
				count++;
				data = data & (data - 1);
			}
			System.out.println(count);
		}

	}
}
