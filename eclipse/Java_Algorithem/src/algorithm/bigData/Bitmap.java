package algorithm.bigData;
/**
 * @author fan
 * 腾讯面试题：给20亿个不重复的unsigned int的整数，没排过序的，然后再给一个数，
 * 如何快速判断这个数是否在那40亿个数当中并且所耗内存尽可能的少？
 * 
 *输出:
 *存储用时:7131毫秒
 *存储消耗内存:715MB 
 *989898 false 
 *查询用时:0毫秒
 *
 */
public class Bitmap {
	public static void main(String[] args) {
		long beforeMem = Runtime.getRuntime().totalMemory();
		long start1 = System.currentTimeMillis();
		MyBitSet set = new MyBitSet(2000000000);

		for (int i = 0; i < 20000000 + 1; i++) {
			if (i != 989898) {
				set.set(i);
			}
		}

		long afterMem = Runtime.getRuntime().totalMemory();
		long end1 = System.currentTimeMillis();

		System.out.println("存储用时:" + (end1 - start1) + "毫秒");
		System.out.println("存储消耗内存:" + (afterMem - beforeMem) / 1024 / 1024
				+ "MB");

		long start2 = System.currentTimeMillis();
		System.out.println("989898 " + set.get(989898));
		System.out.println("234234 " + set.get(234234));
		System.out.println("1111 " + set.get(1111));
		long end2 = System.currentTimeMillis();
		System.out.println("查询用时:" + (end2 - start2) + "毫秒");
	}

}
