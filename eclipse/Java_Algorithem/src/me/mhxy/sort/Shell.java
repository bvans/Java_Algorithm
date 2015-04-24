package me.mhxy.sort;

public class Shell {

	/**
	 * 希尔排序
	 * 
	 * @param arr
	 * @param n
	 */
	public static void shell(int[] arr, int start, int end) {
		int step = (end - start + 1) >> 1;
		if (step == 1) {
			return;
		}

		while (step != 1) {
			for (int i = 0; i < step; i++) {
				for (int j = i; j < end; j += step) {
					for (int k = j + step; k > i && k < end; k -= step) {
						if (arr[k] < arr[j]) {
							int temp = arr[k];
							arr[k] = arr[j];
							arr[j] = temp;
						}
					}
				}
			}
			step = step >> 1;
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

		shell(arr, 0, arr.length - 1);
	}

}
