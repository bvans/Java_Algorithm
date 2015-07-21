package me.mhxy.sort;

public class InsertionSort {

	/**
	 * i的左边是已排好序的 每次从i右边选择一个插入左边, i++
	 */
	public static void insertionSort(int[] data) {
		// 可以减少比较次数
		int tmp;
		int i, j;
		for (i = 1; i < data.length; i++) {
			tmp = data[i];
			for (j = i; j > 0 && tmp < data[j - 1]; j--) {
				// 比data[j]大的都向右移
				data[j] = data[j - 1];
			}
			data[j] = tmp;
		}
	}

	public static void shellSort(int[] data) {
		int h = 1;
		//h取1, 4, 13, 40, 121
		//但是小于等于data.length/3
		while (h < data.length / 3) {
			h = h * 3 + 1;
		}
		
		for(; h >=1; h /= 3) {
			//共有k个分组
			for(int k = 0; k < h; k++) {
				//对每个分组进行排序
				for(int i = k + h; i < data.length; i += h) {
					for (int j = i ; j >= h && data[j] < data[j - h]; j -= h) {
						int tmp = data[j];
						data[j] = data[j - h];
						data[j - h] = tmp;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++) {
			a[i] = (int) Math.floor(Math.random() * 21);
			System.out.print(a[i] + ",");
		}
		System.out.println("排序");
		shellSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}

		return;
	}
}
