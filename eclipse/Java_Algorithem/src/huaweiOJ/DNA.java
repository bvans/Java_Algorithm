package huaweiOJ;

import java.util.Scanner;

public class DNA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] data = sc.next().toCharArray();
		int size = sc.nextInt();

		int start1 = -1;
		int gcCount1 = 0;

		int start2 = -1;
		int gcCount2 = 0;

		if (data.length <= size) {
			start1 = 0;
			for (int i = 0; i < data.length; i++) {
				if (data[i] == 'G' || data[i] == 'C') {
					gcCount1++;
				}
			}
		} else {
			for (int i = 0; i < data.length - size; i++) {
				start2 = i;
				gcCount2 = 0;
				for (int j = i; j < i + size; j++) {
					if (data[j] == 'G' || data[j] == 'C' || data[j] == 'g'
							|| data[j] == 'c') {
						gcCount2++;
					}
				}
				if (gcCount2 > gcCount1) {
					gcCount1 = gcCount2;
					start1 = start2;
				}
			}
		}

		for (int i = start1; i < start1 + size; i++) {
			System.out.print(data[i]);
		}
		System.out.println();
	}

}
