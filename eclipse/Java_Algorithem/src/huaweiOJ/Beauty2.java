package huaweiOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Beauty2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		for (int i = 0; i < size; ++i) {
			String name = sc.next();
			System.out.println(getBeauty(name));
		}
	}

	public static int getBeauty(String name) {
		name = name.toLowerCase();
		int[] count = new int[26];
		char[] names = name.toCharArray();
		for (int i = 0; i < names.length; ++i) {
			count[names[i] - 'a']++;
		}
		Arrays.sort(count);
		
		int res = 0;
		int digit = 26;
		for(int i = count.length - 1; i >= 0; i--) {
			res += count[i] * digit--;
		}
		
		return res;
	}
}
