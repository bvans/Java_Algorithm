package me.mhxy.sort;

public class ExchangeSort {
	/**
	 * n-1趟,
	 * 每趟选择最大的值放在右边
	 */
	public static void bubbleSort(int[] arr) {
		//i为已排好的个数
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]){
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	public static void quickSort(int arr[], int start, int end) {
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
		quickSort(arr, start, left - 1);
		quickSort(arr, left + 1, end);
	}

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++) {
			a[i] = (int) Math.floor(Math.random() * 21);
			System.out.print(a[i] + ",");
		}
		System.out.println("排序");
		bubbleSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		return;
	}

}
