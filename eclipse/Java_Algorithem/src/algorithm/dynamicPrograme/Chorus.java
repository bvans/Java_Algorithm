package algorithm.dynamicPrograme;

import java.util.Scanner;

/**
 * 使用动态规划的思想,分别对数组中的每一个元素求解该元素左边最长的递增子序列和右边最长的递减子序列
 * 
 * 然后遍历所有元素,最长递增子序列和最长递减子序列的最大值即是我们要求的
 */
public class Chorus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] data = new int[size];

		for (int i = 0; i < size; ++i) {
			data[i] = sc.nextInt();
		}

		int len = data.length;
		int[] ascend = new int[len];
		int[] descend = new int[len];

		for (int i = 1; i <= len - 1; ++i) {
			for (int j = i - 1; j >= 0; --j) {
				if ((data[j] < data[i]) && (ascend[j] + 1 > ascend[i])) {
					ascend[i] = ascend[j] + 1;
				}
			}
		}

		for (int i = len - 2; i >= 1; i--) {
			for (int j = i + 1; j < len; ++j) {
				if ((data[i] > data[j]) && (descend[j] + 1 > descend[i])) {
					descend[i] = descend[j] + 1;
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < len; i++) {
			if (ans < ascend[i] + descend[i])
				ans = ascend[i] + descend[i];
		}
		System.out.println(len - ans - 1);

	}
}
