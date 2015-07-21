package me.mhxy.sort;

public class Shell {

	/**
	 * 希尔排序
	 * 
	 * @param arr
	 * @param n
	 */
	public static void shell(int[] arr, int start, int end) {
		int gap = arr.length / 2;
		if (gap == 1) {
			return;
		}

		while (gap != 1) {
			for (int i = 0; i < gap; i++) {
				for (int j = i; j < end; j += gap) {
					for (int k = j + gap; k > i && k < end; k -= gap) {
						if (arr[k] < arr[j]) {
							int temp = arr[k];
							arr[k] = arr[j];
							arr[j] = temp;
						}
					}
				}
			}
			gap = gap >> 1;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) Math.floor(Math.random() * 11);
			System.out.print(arr[i] + ",");
		}

		System.out.println("排序");
		shell(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

}
