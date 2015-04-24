package me.mhxy.test;

public class Sort {
	public static void sort(int arr[], int start, int end) {
		if (start < end) {
			int left = start;
			int right = end;
			int pivotVal = arr[start];
			
			while (left < right) {
				while (left < right && arr[right] > pivotVal)
					right--;
				if (left < right)
					arr[left++] = arr[right];
				
				while (left < right && arr[left] <= pivotVal)
					left++;
				if (left < right) {
					arr[right--] = arr[left];
				}
				
			}
			
			arr[left] = pivotVal;
			sort(arr, start, left - 1);
			sort(arr, left + 1, end);
			
		}
	}
	
}
