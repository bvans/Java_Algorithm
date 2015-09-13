package algorithm.sort;

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

	static class ClassicQuickSort {
		public static void sort(int[] data) {
			if (data.length <= 1) {
				return;
			}
			sort(data, 0, data.length - 1);
		}

		private static void sort(int[] data, int start, int end) {

			int index = partition(data, 0, data.length - 1);
			if (index > start) {
				quickSort(data, start, index - 1);
			}

			if (index < end) {
				quickSort(data, index + 1, end);
			}

		}

		private static int partition(int[] data, int start, int end) {
			if (start >= end || end >= data.length) {
				return -1;
			}

			int index = (int) (Math.random() * (end - start + 1) + start);
			int val = data[index];
			int tmp = data[index];
			data[index] = data[start];
			data[start] = tmp;

			while (start < end) {
				while (start < end && data[end] > val) {
					end--;
				}
				if (start < end) {
					data[start++] = data[end];
				}

				while (start < end && data[start] < val) {
					start++;
				}
				if (start < end) {
					data[end--] = data[start];
				}
			}
			data[start] = val;
			return start;
		}
	}

	private static void quickSort(int arr[], int start, int end) {
		if (start >= end || end >= arr.length)
			return;
		int left = start;
		int right = end;
		int value = arr[start];

		while (left < right) {
			while (left < right && arr[right] > value)
				right--;
			if (left < right)
				// 下一步从左边开始比较, 但是提前让left自增
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
			int[] sample = new int[6];
			for (int i = 0; i < sample.length; i++) {
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
