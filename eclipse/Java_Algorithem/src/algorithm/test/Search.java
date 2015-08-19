package algorithm.test;

public class Search {
	public static int search(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		
		
		//注意这个地方
		while(left <= right) {
			int mid = (left + right) >> 1;
			
			if (key < arr[mid]) {
				right = mid - 1;
			} else if (key > arr[mid]) {
				left = mid + 1;
			} 
		}
			
		return left;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) Math.floor(Math.random() * 11);
			System.out.print(arr[i]);
		}
		Sort.sort(arr, 0, arr.length - 1);
		
		System.out.println();
		for (int x : arr) {
			System.out.print(x);
		}
		
		System.out.println();
		int result = search(arr, 5);
		System.out.println(result);
	}

}
