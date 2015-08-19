package huaweiOJ;

import java.util.*;

public class ChCounts {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] chs = sc.nextLine().toCharArray();
		char target = sc.next().charAt(0);

		int count = 0;
		for (char c : chs) {
			if (c == target) {
				count++;
			}
		}
		System.out.println(count);
	}
}
