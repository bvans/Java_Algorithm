package me.mhxy.sort;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

	public void radixsort(int[] data) {
		int radix = 10;
		int digits = 10;

		int d, j, k, factor;
		Queue[] queues = new Queue[radix]; // radix is 10;
		for (d = 0; d < radix; d++)
			queues[d] = new LinkedList<Integer>();
		for (d = 1, factor = 1; d <= digits; factor *= radix, d++) {
			for (j = 0; j < data.length; j++)
				queues[(data[j] / factor) % radix].add(new Integer(data[j]));
			for (j = k = 0; j < radix; j++)
				while (!queues[j].isEmpty())
					data[k++] = ((Integer) queues[j].remove()).intValue();
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
		new Test().radixsort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		return;
	}

}
