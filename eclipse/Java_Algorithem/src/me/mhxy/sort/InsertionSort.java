package me.mhxy.sort;

import java.util.Arrays;

public class InsertionSort {

	/**
	 * i的左边是已排好序的 每次从i右边选择一个插入左边, i++
	 */
	public static void insertionSort(int[] data) {
		// 可以减少比较次数
		int tmp;
		for (int i = 1; i < data.length; i++) {
			tmp = data[i];
			int j = i;

			// 边界条件:退出时j=0;因此确保 j > 0
			for (; j >= 1 && tmp < data[j - 1]; j--) {
				// 比data[j]大的都向右移
				data[j] = data[j - 1];
			}
			data[j] = tmp;
		}
	}

	public static void shellSort(int[] data) {
		// 分组个数
		int gap = 1;
		// h取1, 4, 13, 40, 121
		// 但是小于等于data.length/3
		while (gap < data.length / 3) {
			gap = gap * 3 + 1;
		}

		for (; gap >= 1; gap /= 3) {
			// 共有h个分组
			for (int group = 0; group < gap; group++) {
				// 对每个分组进行直接插入排序
				for (int i = group + gap; i < data.length; i += gap) {
					int tmp = data[i];
					int j = i - gap;
					for (; j >= group && data[j] > tmp; j -= gap) {
						data[j + gap] = data[j];
					}
					data[j + gap] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		for (int j = 0; j < 10e4; j++) {
			int[] sample = new int[10];
			for (int i = 0; i < 10; i++) {
				sample[i] = (int) Math.floor(Math.random() * 21);
			}

			int[] sorted = Arrays.copyOf(sample, sample.length);
			Arrays.sort(sorted);
			shellSort(sample);

			if (!Arrays.equals(sorted, sample)) {
				try {
					throw new Exception("排序失败");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("排序算法正确");
		return;
	}
}
