package algorithm.dynamicPrograme;

import java.util.Random;

public class LCS {

	public static void main(String[] args) {
		Random r = new Random();
		for (int i = 0; i < 10000; i++) {
			int len1 = r.nextInt(10);
			char[] chars1 = new char[len1];
			for (int j = 0; j < len1; j++) {
				int diff = 'Z' - 'A' + 1;
				chars1[j] = (char) (r.nextInt(200) % diff + 'A');
			}

			int len2 = r.nextInt(10);
			char[] chars2 = new char[len2];
			for (int j = 0; j < len2; j++) {
				int diff = 'Z' - 'A' + 1;
				chars2[j] = (char) (r.nextInt(200) % diff + 'A');
			}

			String str1 = new String(chars1);
			String str2 = new String(chars2);

			String res1 = getLCS(str1, str2);
			String res2 = LCSs.getLCS(str1, str2);
			if (!res1.equals(res2)) {
				System.err.println("失败");
				getLCS(str1, str2);
				System.out.println();
			}

		}

	}

	public static String getLCS(String s1, String s2) {
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		int len1 = str1.length;
		int len2 = str2.length;

		final int LEFT = 1;
		final int UP = 2;
		final int LEFT_UP = 0;

		// 最长子序列的长度
		int[][] lcs = new int[len1 + 1][len2 + 1];
		// 当前最长子序列由何处而来
		int[][] direction = new int[len1 + 1][len2 + 1];

		for (int i = 0; i < len1 + 1; i++) {
			lcs[i][0] = 0;
		}
		for (int j = 0; j < len2 + 1; j++) {
			lcs[0][j] = 0;
		}

		for (int i = 1; i < len1 + 1; i++) {
			for (int j = 1; j < len2 + 1; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
					direction[i][j] = LEFT_UP;
				} else if (lcs[i][j - 1] < lcs[i - 1][j]) {
					lcs[i][j] = lcs[i - 1][j];
					direction[i][j] = UP;
				} else {
					lcs[i][j] = lcs[i][j - 1];
					direction[i][j] = LEFT;
				}

			}
		}

		// 根据方向,如果指向左上角则说明最长子序列包含当前字符
		int i = len1;
		int j = len2;
		char[] res = new char[lcs[len1][len2]];
		int k = res.length;

		while (i > 0 && j > 0) {
			if (direction[i][j] == LEFT_UP) {
				res[--k] = str1[i - 1];
				i--;
				j--;
			} else if (direction[i][j] == LEFT) {
				j--;
			} else {
				i--;
			}
		}

		return new String(res);
	}

}
