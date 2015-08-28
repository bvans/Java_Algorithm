package algorithm.sort;

import java.util.Arrays;

import javax.annotation.Generated;

public class MergeSort {

	private static void mergeSort(int[] data, int[] temp, int start, int end) {
		if (start < end) {
			//直到子数组的长度为1, 直接合并
			int mid = ((start + end) >> 1);
			mergeSort(data, temp, start, mid);
			mergeSort(data, temp, mid + 1, end);
			merge(data, temp, start, end);
		}
	}

	private static void merge(int[] data, int[] temp, int start, int end) {
		int mid = ((start + end) >> 1);

		int i = start; // temp的指针
		int j = start; // 左半部分的指针
		int k = mid + 1; // 右半部的指针
		while (j <= mid && k <= end) {
			if (data[j] < data[k]) {
				temp[i++] = data[j++];
			} else {
				temp[i++] = data[k++];
			}
		}
		while (j <= mid) {
			temp[i++] = data[j++];
		}
		while (k <= end) {
			temp[i++] = data[k++];
		}

		for (i = start; i <= end; ++i) {
			data[i] = temp[i];
		}
	}

	public static void mergesort(int[] data) {
		//需要n个额外空间
		int[] temp = new int[data.length];
		mergeSort(data, temp, 0, data.length - 1);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 3, 1, 2, 4 };
		mergesort(a);

		for (int j = 0; j < 10e4; j++) {
			int[] sample = new int[10];
			for (int i = 0; i < 10; i++) {
				sample[i] = (int) Math.floor(Math.random() * 21);
			}

			int[] sorted = Arrays.copyOf(sample, sample.length);
			Arrays.sort(sorted);
			mergesort(sample);

			if (!Arrays.equals(sorted, sample)) {
				try {
					throw new Exception("排序失败");
				} catch (Exception e) {
					e.printStackTrace();
					return;
				}
			}
		}

		System.out.println("排序算法正确");
	}

}
