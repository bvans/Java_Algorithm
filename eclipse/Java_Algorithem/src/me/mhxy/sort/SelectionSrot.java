package me.mhxy.sort;

public class SelectionSrot {
	/**
	 * i左边是排好序的
	 * 每次从i右边的集合中选择最小的值与i+1交换
	 * i++
	 */
	public static void selectionSort(int[] data) {
		for(int i = 0; i < data.length - 1; i++) {
			int least = i;
			for(int j = i + 1; j < data.length; j++) {
				if(data[j] <= data[least]) {
					least = j;
				}
			}
			int tmp = data[least];
			data[least] = data[i];
			data[i] = tmp;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++) {
			a[i] = (int) Math.floor(Math.random() * 21);
			System.out.print(a[i] + ",");
		}
		System.out.println("排序");
		selectionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		return;
	}
}
