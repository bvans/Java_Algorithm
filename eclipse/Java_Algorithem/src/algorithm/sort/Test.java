package algorithm.sort;

import java.util.Arrays;

public class Test {
	
	public static void insertSort(int[] data) {
		for(int i = 1; i < data.length; i++) {
			int j = i - 1;
			int tmp = data[i];
			for(; j >= 0 && data[j] > tmp; j--) {
				data[j + 1] = data[j];
			}
			data[j + 1] = tmp;
		}
	}

	public static void shellSort(int[] data) {
		int gap = 1;
		while (gap < data.length / 3) {
			gap = gap * 3 + 1;
		}

		for (; gap >= 1; gap /= 3) {
			for (int group = 0; group < gap; group++) {
				for (int i = group + gap; i < data.length; i += gap) {
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

		for (int j = 0; j < 10e4; j++) {
			int[] sample = new int[10];
			for (int i = 0; i < 10; i++) {
				sample[i] = (int) Math.floor(Math.random() * 21);
			}

			int[] sorted = Arrays.copyOf(sample, sample.length);
			Arrays.sort(sorted);
			insertSort(sample);

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
