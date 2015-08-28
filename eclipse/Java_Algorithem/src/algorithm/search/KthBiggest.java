package algorithm.search;

import java.util.Arrays;
import java.util.Random;

public class KthBiggest {

	public static void main(String[] args) {
		Random r = new Random();
		for (int time = 0; time < 10000; time++) {
			int[] data = new int[r.nextInt(4) + 1];
			for (int i = 0; i < data.length; i++) {
				data[i] = r.nextInt(100);
			}
			int k = r.nextInt(data.length) + 1;

			int res = getKth(data, k);
			Arrays.sort(data);
			if (res != data[data.length - k]) {
				System.err.println("Error");
			}
		}

	}

	public static int getKth(int[] data, int k) {
		int[] tmp = Arrays.copyOf(data, data.length);
		return getKthHelper(k, tmp, 0, tmp.length - 1);
	}

	public static int getKthHelper(int k, int[] data, int start, int end) {
		if(start > end) {
			return -1;
		}
		
		int left = start;
		int right = end;
		int val = data[left];

		
		
		while (left < right) {
			while (left < right && data[right] > val) {
				right--;
			}
			if (left < right) {
				data[left++] = data[right];
			}

			while (left < right && data[left] < val) {
				left++;
			}
			if (left < right) {
				data[right--] = data[left];
			}
		}

		data[left] = val;
		// val是第x大的数
		int xTh = data.length - left;
		// left是第k大
		if (xTh == k) {
			return data[left];
		} else if (k > xTh) {
			// 要找的数比val小
			return getKthHelper(k, data, start, left - 1);
		} else if (k < xTh) {
			return getKthHelper(k, data, left + 1, end);
		}

		return 0;
	}

}
