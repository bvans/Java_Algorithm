package me.mhxy.sort;

public class MergeSort {
	public static int[] temp;

	public static int[] sort(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}

		int half = arr.length / 2;
		int[] subArr1 = new int[half];
		int[] subArr2 = new int[arr.length - half];

		System.arraycopy(arr, 0, subArr1, 0, subArr1.length);
		System.arraycopy(arr, half, subArr2, 0, subArr2.length);

		subArr1 = sort(subArr1);
		subArr2 = sort(subArr2);

		return mergeSortSub(subArr1, subArr2);
	}

	private static int[] mergeSortSub(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				result[k++] = arr1[i++];
			} else {
				result[k++] = arr2[j++];
			}
		}

		while (i < arr1.length) {
			result[k++] = arr1[i++];
		}

		while (j < arr2.length) {
			result[k++] = arr2[j++];
		}

		return result;
	}

	private static void mergeSort(int[] data, int start, int end) {
		if (start < end) {
			int mid = ((start + end) >> 1);
			mergeSort(data, start, mid);
			mergeSort(data, mid + 1, end);
			merge(data, start, end);
		}
	}

	private static void merge(int[] data, int start, int end) {
		int mid = ((start + end) >> 1);

		int i = 0;
		int j = start; // 左半部分的指针
		int k = mid + 1; // 右半部的指针
		while (j <= mid && k <= end) {
			if (data[j] < data[k]) {
				temp[i++] = temp[j++];
			} else {
				temp[i++] = temp[k++];
			}
		}
		while (j <= mid) {
			temp[i++] = data[j++];
		}
		while (k <= end) {
			temp[i++] = data[k++];
		}

		for (i = 0, j = start; j <= end; data[j++] = data[i++])
			;
	}

	public static void mergesort(int[] data) {
		temp = new int[data.length];
		mergeSort(data, 0, data.length - 1);
	}

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++) {
			a[i] = (int) Math.floor(Math.random() * 21);
			System.out.print(a[i] + ",");
		}
		System.out.println("排序");
		mergesort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		return;
	}

}
