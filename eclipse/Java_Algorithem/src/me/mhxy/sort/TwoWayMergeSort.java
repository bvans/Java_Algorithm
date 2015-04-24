package me.mhxy.sort;


//递归方式实现2路归并排序
public class TwoWayMergeSort {
	
	public static int[] sort(int[] arr){
		if (arr.length <= 1) {
			return arr;
		}
		
		int half = arr.length/2;
		int[] subArr1 = new int[half];
		int[] subArr2 = new int[arr.length - half];
		
		System.arraycopy(arr, 0, subArr1, 0, subArr1.length);
		System.arraycopy(arr, half, subArr2, 0, subArr2.length);
		
		subArr1 = sort(subArr1);
		subArr2 = sort(subArr2);
		
		return mergeSortSub(subArr1, subArr2);
	}

	private static int[] mergeSortSub(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				result[k++] = arr1[i++]; 
			} else {
				result[k++] = arr2[j++];
			}
		}
		
		while (i < arr1.length) {
			result[k++] = arr1[i++];
		}
		
		while(j < arr2.length) {
			result[k++] = arr2[j++];
		}
		
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test = new int[]{1, 235, 3241, 23, 32, 3 };
		test = sort(test);
		for (int x : test) {
			System.out.println(x);
		}

	}

}
