package me.mhxy.sort;

public class Test {
	public static void sort(int[] arr, int start, int end){
		if (start < end) {
			int low = start;
			int high = end;
			int pivotVal = arr[start];
			
			while(low < high) {
				while (low < high && arr[high] >= pivotVal) {
					high--;
				}
				if (low < high) {
					arr[low++] = arr[high];
				}
				
				while (low < high && arr[low] < pivotVal) {
					low++;
				}
				if (low < high) {
					arr[high++] = arr[low];
				}
			}
			
			arr[low] = pivotVal;
			sort(arr, start, low - 1);
			sort(arr, low + 1, end);
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) Math.floor(Math.random() * 11);
		}
		
		sort(arr, 0, arr.length - 1);
	}

}
