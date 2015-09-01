package algorithm.hash;

import java.util.BitSet;
import java.util.HashSet;

public class SimpleHash {
	public static void main(String[] args) {
		Integer a = 1232;
		Integer b = 1232;
		int i = 89;
		System.out.println(a == b);
	}

	public static int hash(int src) {
		src ^= (src >>> 20) ^ (src >>> 12);
		return src ^ (src >>> 7) ^ (src >>> 4);
	}

	public static int getHashLength(int length) {
		int k = 0;
		for (;;) {
			length = length >> 1;
			k++;
			if (length == 0) {
				return 1 << k;
			}
		}
	}
}
