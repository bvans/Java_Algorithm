package towardOffer;

import java.util.ArrayDeque;
import java.util.Arrays;

public class ReplaceBlank {

	public static void main(String[] args) {
		String test = " fads afds afds  ";
		char[] chars = Arrays.copyOf(test.toCharArray(), 100);
		replaceBlank(chars);
		System.out.println(chars);

	}

	/**
	 * 从后向前开始检索(显著减少移动次数)
	 */
	public static void replaceBlank(char[] chars) {
		int blankCount = 0;
		int realLen = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				blankCount++;
			} else if (chars[i] == 0) {
				realLen = i;
				break;
			}
		}

		int finalLen = realLen + blankCount * 2;

		int j = realLen - 1;
		for (int i = finalLen - 1; i >= 0 && j >= 0;) {
			if (chars[j] != ' ') {
				chars[i] = chars[j];
				i--;
			} else {
				chars[i--] = '0';
				chars[i--] = '2';
				chars[i--] = '%';
			}
			j--;
		}
	}
}
