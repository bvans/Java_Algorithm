package me.mhxy.sort;

public class BubleSort {
	public static void sort(int[] arr, int n) {
		//i为已排好的个数
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]){
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] {34,23,23,34,2632,26,79,5,354,432,23,3,43};
		sort(a, a.length);
 		return;
	}

}
