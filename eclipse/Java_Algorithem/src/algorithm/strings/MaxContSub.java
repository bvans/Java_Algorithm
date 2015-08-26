package algorithm.strings;

public abstract class MaxContSub {
	public static void main(String[] args) {
		System.out.println(getMaxContSub("acbac", "acaccbabb"));
	}

	/**
	 * 给定一个query和一个text，均由小写字母组成。要求在text中找出以同样的顺序连续出现在query中的最长连续字母序列的长度。例如，
	 * query为 "acbac",text为"acaccbabb",那么text中的"cba"为最长的连续出现在query中的字母序列，因此，
	 * 返回结果应该为其长度3。请注意程序效率。
	 */
	public static String getMaxContSub(String query, String text) {
		for(int j = text.length(); j >= 0; j--) {
			for(int i = 0; i < text.length(); i++) {
				if(i + j <= text.length()) {
					String sub = text.substring(i, i + j);
					if(query.contains(sub)) {
						return sub;
					}
				}
			}
		}
			
		return "";
	}
}
