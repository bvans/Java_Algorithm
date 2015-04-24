package me.mhxy.search;

public class BinarySearch {
	
	/**二分查找
	 * @param int型的非递减有序数组
	 * @param 数组的才长度
	 * @param 需要查找的int值
	 * @return 返回key值在数组中的位置, 未找到则返回-1
	 */
	public static int search(int[] arr, int n, int key) {
		int left = 0;
		int right = n - 1;

		while (left <= right) {
			int mid = (left + right) >> 1;

			if (key < arr[mid]) {
				right = mid - 1;
			} else if (key > arr[mid]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}	
		return left;
	}

	public static void main(String[] args) {
		int[] test = new int[] { 1, 34, 344, 355, 3000, 8888 };
		int result = search(test, 0, 355);
		System.out.println(result);
	}
}
