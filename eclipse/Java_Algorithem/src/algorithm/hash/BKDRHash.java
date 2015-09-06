package algorithm.hash;

public class BKDRHash {
	/**
	 * 默认的一个素数用于hash处理
	 */
	public static final int PRIME1 = 131;
	public static final int PRIME2 = 1000000 + 3;
	public static final int PRIME3 = 10000000 + 19;

	public static int hashString(String key) {
		int hash = 0;
		for (int i = 0; i < key.length(); i++) {
			hash = hash * PRIME1 + key.charAt(i);
		}
		return hash & 0x7fffffff;
	}
}
