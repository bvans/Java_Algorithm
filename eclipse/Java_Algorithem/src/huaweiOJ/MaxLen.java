package huaweiOJ;

import java.util.Scanner;

public class MaxLen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char data[] = sc.nextLine().toCharArray();

		int start1 = -1;
		int end1 = -1;
		int start2 = -1;
		int end2 = -1;

		for (int i = 0; i < data.length; i++) {
			char ch = data[i];
			if (Character.isDigit(ch)) {
				if (start2 == -1) {
					// 刚开始
					start2 = i;
					end2 = i;
				} else {
					// 上一个也是数字
					end2++;
				}
			} else {
				// 是字母
				if (start2 != -1) {
					if ((end2 - start2 + 1) > (end1 - start1 + 1)) {
						// 新序列更长
						start1 = start2;
						end1 = end2;
					}
					start2 = -1;
					end2 = -1;
				}
			}
		}
		
		for(int i = start1; i <= end1; i++) {
			System.out.print(data[i]);
		}
		System.out.println();
		System.out.print(",");
		System.out.println(end1 - start1 + 1);
	}

}
