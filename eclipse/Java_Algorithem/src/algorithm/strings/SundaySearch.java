package algorithm.strings;

import java.util.HashMap;

public class SundaySearch {

	/**字符串匹配函数
	 * @param 长串
	 * @param 目标串
	 * @return 目标串第一次在长串中出现的位置,如果没有则返回-1
	 */
	public static int search(String parent, String child) {
		int srcLen = parent.length();
		int patternLen = child.length();
		
		if (srcLen < patternLen)
			return -1;

		char[] src = parent.toCharArray();
		char[] sub = child.toCharArray();

		

		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();

		for (int i = 0; i < patternLen; i++)
			hashMap.put(sub[i], patternLen - i);

		int head = 0;
		int rail = head + patternLen - 1;

		while (rail <= srcLen - 1 ) {
			int i;
			for (i = 0; i < patternLen; i++) {
				if (sub[i] != src[head + i])
					break;
			}

			if (i == patternLen) {
				return head;
			}

			if ((rail + 1) > srcLen - 1)
				return -1;

			Integer tmp = hashMap.get(src[rail + 1]);
			int step = tmp == null ? patternLen + 1 : tmp;

			head = head + step;
			rail = head + patternLen - 1;

		}

		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String parent = "bcfadsf";
		String child = "dcf";

		System.out.println(parent);
		System.out.println(child);

		int result = search(parent, child);
		System.out.println(result);

	}

}
