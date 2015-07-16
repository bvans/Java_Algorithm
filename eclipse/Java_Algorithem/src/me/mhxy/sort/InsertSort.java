package me.mhxy.sort;

public class InsertSort {
	
	//直接插入排序
	public static void sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (a[j] > a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++) {
			a[i] = (int) Math.floor(Math.random() * 21);
		}
		sort(a);
		
		return;
	}
}
