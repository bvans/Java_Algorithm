package me.mhxy.sort;

import java.util.Arrays;

public class TopK {
	public static int[] getTop(int k, int[] data) {
		k = k > data.length ? data.length : k;

		int[] res = Arrays.copyOf(data, k);
		for (int i = k / 2 - 1; i >= 0; --i) {
			moveDown(res, i, k - 1);
		}

		for (int i = k; i < data.length; ++i) {
			int tmp = data[i];
			if(tmp>= res[0]) {
				res[0] = tmp;
				moveDown(res, 0, k - 1);
			}
		}
		
		return res;
	}

	// 构造小顶堆
	public static void moveDown(int[] data, int start, int end) {
		int child = 2 * start + 1;
		while (child <= end) {
			if (child < end && data[child] > data[child + 1]) {
				child++;
			}

			if (data[start] > data[child]) {
				data[start] += data[child];
				data[child] = data[start] - data[child];
				data[start] -= data[child];

				start = child;
				child = 2 * start + 1;
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) throws Exception {

		for (int j = 0; j < 10e4; j++) {
			int[] sample = new int[10];
			for (int i = 0; i < 10; i++) {
				sample[i] = (int) Math.floor(Math.random() * 21);
			}
			
			int k = (int)(Math.random() * 10 + 1);
			
			int[] res = getTop(k, sample);
			Arrays.sort(res);
			
			Arrays.sort(sample);
			int[] sorted = Arrays.copyOfRange(sample, sample.length - k,sample.length);
			

			if (!Arrays.equals(sorted, res)) {
				throw new Exception("排序失败");
			}
		}

		System.out.println("排序算法正确");

		return;
	}
}
