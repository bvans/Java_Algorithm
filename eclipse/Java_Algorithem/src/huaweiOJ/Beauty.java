package huaweiOJ;

import java.util.*;

public class Beauty {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();

		for (int i = 0; i < size; ++i) {
			String word = sc.next();
			int count = getBeauty(word);
			System.out.println(count);
		}
		sc.close();

	}

	public static int getBeauty(String word) {
		word = word.toLowerCase(Locale.US).trim();
		char[] chs = word.toCharArray();
		int[] res = new int[26];

		for (int i = 0; i < chs.length; ++i) {
			char ch = chs[i];
			res[ch - 'a']++;
		}

		Arrays.sort(res);
		int digit = 26;
		int beauty = 0;
		for (int i = res.length - 1; res[i] != 0; --i) {
			beauty += res[i] * digit;
			digit--;
		}

		return beauty;
	}
}
