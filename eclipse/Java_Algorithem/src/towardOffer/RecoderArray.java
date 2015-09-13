package towardOffer;

import java.util.Random;

interface Judge {
	boolean ToFront(int num);
}

public class RecoderArray {

	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(10);
		}
		recoder(arr, new Judge() {

			@Override
			public boolean ToFront(int num) {
				if ((num & 0x1) == 1) {
					return true;
				}
				return false;
			}
		});
		System.out.println();
	}

	public static void recoder(int[] arr, Judge judge) {
		if (arr.length < 2) {
			return;
		}

		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			while (start < end && judge.ToFront(arr[start])) {
				start++;
			}
			while (start < end && !judge.ToFront(arr[end])) {
				end--;
			}

			if (start < end) {
				int tmp = arr[start];
				arr[start] = arr[end];
				arr[end] = tmp;
			}
		}
	}
}
