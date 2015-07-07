package me.mhxy.sort;

import java.util.Arrays;

public class QuickSort {
	public static void sort(int arr[], int start, int end) {
		if (start >= end)
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
		sort(arr, start, left - 1);
		sort(arr, left + 1, end);
	}

	public static void main(String[] args) {
		int[] arr = new int[10];

		for (int i = 0; i < 10; i++) {
			arr[i] = (int) Math.floor((Math.random() * 111));
		}
		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
