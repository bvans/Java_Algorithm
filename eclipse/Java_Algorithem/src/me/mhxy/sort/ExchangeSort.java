package me.mhxy.sort;

import java.util.Arrays;

public class ExchangeSort {
	/**
	 * n-1趟, 每趟选择最大的值放在右边
	 */
	public static void bubbleSort(int[] arr) {
		// i为已排好的个数
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	private static void quickSort(int arr[], int start, int end) {
		if (start >= end || arr.length <= end)
			return;
		int left = start;
		int right = end;
		int value = arr[start];

		while (left < right) {
			while (left < right && arr[right] > value)
				right--;
			if (left < right)
				arr[left++] = arr[right];

			while (left < right && arr[left] < value)
				left++;
			if (left < right)
				arr[right--] = arr[left];
		}

		arr[left] = value;
		quickSort(arr, start, left - 1);
		quickSort(arr, left + 1, end);
	}

	public static void quickSort(int[] data) {
		quickSort(data, 0, data.length - 1);
	}

	public static void main(String[] args) {
		for (int j = 0; j < 10e4; j++) {
			int[] sample = new int[10];
			for (int i = 0; i < 10; i++) {
				sample[i] = (int) Math.floor(Math.random() * 21);
			}

			int[] sorted = Arrays.copyOf(sample, sample.length);
			Arrays.sort(sorted);
			bubbleSort(sample);

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
