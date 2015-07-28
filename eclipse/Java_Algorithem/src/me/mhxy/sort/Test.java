package me.mhxy.sort;

public class Test {
	public void shellSort(int[] data) {
		int gap = 1;
		while(gap < data.length / 3) {
			gap = gap * 3 + 1;
		}
		
		for(; gap >= 1; gap = gap / 3) {
			for(int group = 0; group < gap; group++) {
				for(int i = group + gap; i < data.length; i += gap) {
					int tmp = data[i];
					int j = i - gap;
					for(; j >= group && data[j] > tmp; j -= gap) {
						data[j + gap] = data[j];
					}
					data[j + gap] = tmp; 
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		int len = (int) Math.floor(Math.random() * 15);
		int[] a = new int[len];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) Math.floor(Math.random() * 21);
			System.out.print(a[i] + ",");
		}
		System.out.println("排序");
		new Test().shellSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		return;
	}

}
