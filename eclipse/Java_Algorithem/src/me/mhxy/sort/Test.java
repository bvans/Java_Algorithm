package me.mhxy.sort;

public class Test {
	public void heapSort(int[] data) {
		int last = data.length - 1;
		//保证所有的非叶子节点都大于其子孙
		int nonLeave = data.length / 2 - 1;
		for (; nonLeave >= 0; nonLeave--) {
			moveDown(data, nonLeave, last);
		}

		//最后一个位置肯定不用排了, 因为前n-1个都放置正确了
		for (int i = last; i > 0; i--) {
			int tmp = data[0];
			data[0] = data[i];
			data[i] = tmp;

			moveDown(data, 0, i - 1);
		}
	}

	//保证first节点的值大于其所有的子孙值
	private void moveDown(int[] data, int first, int last) {
		int child = first * 2 + 1;
		while (child <= last) {
			if (child < last && data[child] < data[child + 1]) {
				child++;
			}

			if (data[first] < data[child]) {
				int tmp = data[first];
				data[first] = data[child];
				data[child] = tmp;

				first = child;
				child = 2 * first + 1;
			} else {
				break;
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
		new Test().heapSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		return;
	}

}
