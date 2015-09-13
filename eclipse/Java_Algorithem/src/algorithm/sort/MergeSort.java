package algorithm.sort;

import java.util.Arrays;
import java.util.Calendar;

import javax.annotation.Generated;

public class MergeSort {

	private static void mergeSort(int[] data, int[] temp, int start, int end) {
		if (start < end) {
			//直到子数组的长度为1, 直接合并
			int mid = ((start + end) >> 1);
			mergeSort(data, temp, start, mid);
			mergeSort(data, temp, mid + 1, end);
			merge(data, temp, start, end);
		}
	}

	private static void merge(int[] data, int[] temp, int start, int end) {
		//data的start -- mid和mid+1 -- end两部分是局部有序的
		int mid = ((start + end) >> 1);

		int i = start; // temp的指针
		int left = start; //data左半部分的开始
		int right = mid + 1; //data右半部的开始
		while (left <= mid && right <= end) {
			if (data[left] < data[right]) {
				temp[i++] = data[left++];
			} else {
				temp[i++] = data[right++];
			}
		}
		while (left <= mid) {
			temp[i++] = data[left++];
		}
		while (right <= end) {
			temp[i++] = data[right++];
		}

		//将temp中start--end的有序部分拷回到data
		for (i = start; i <= end; ++i) {
			data[i] = temp[i];
		}
	}

	public static void mergesort(int[] data) {
		//需要n个额外空间
		int[] temp = new int[data.length];
		mergeSort(data, temp, 0, data.length - 1);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 3, 1, 2, 4 };
		mergesort(a);

		for (int j = 0; j < 10e4; j++) {
			int[] sample = new int[10];
			for (int i = 0; i < 10; i++) {
				sample[i] = (int) Math.floor(Math.random() * 21);
			}

			int[] sorted = Arrays.copyOf(sample, sample.length);
			Arrays.sort(sorted);
			mergesort(sample);

			if (!Arrays.equals(sorted, sample)) {
				try {
					throw new Exception("排序失败");
				} catch (Exception e) {
					e.printStackTrace();
					return;
				}
			}
		}

		System.out.println("排序算法正确");
	}

}
