package algorithm.sort;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Vector;
import java.util.concurrent.FutureTask;

public class SelectionSrot {
	/**
	 * i左边是排好序的 每次从i右边的集合中选择最小的值与i+1交换 i++
	 */
	public static void selectionSort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			int least = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] <= data[least]) {
					least = j;
				}
			}
			int tmp = data[least];
			data[least] = data[i];
			data[i] = tmp;
		}
	}

	// 步骤
	// 1. 首先根据该数组元素构建一个完全二叉树
	// 2. 然后构造初始堆，则从最后一个非叶节点开始调整(下沉)
	// 3. (初始堆的根元素必然是最大的)
	// 3. 因此, 将根和叶子交换(最大值到最终位置). 只考虑剩下的n-1个节点, 对新根重新下沉;
	public static void heapSort(int[] data) {
		// 构造初始堆, 保证所有的非叶子节点都大于其子孙
		for (int i = data.length / 2 - 1; i >= 0; i--) {
			moveDown(data, i, data.length - 1);
		}

		// (迭代), 依次将最大值放到叶子上
		// 最后一个位置肯定不用排了, 因为前n-1个都放置正确了
		for (int i = data.length - 1; i >= 1; i--) {
			int tmp = data[0];
			data[0] = data[i];
			data[i] = tmp;

			moveDown(data, 0, i - 1);
		}
	}

	/**
	 * 将某个节点下沉到合适的位置 保证first节点的值大于其所有的子孙值
	 */
	private static void moveDown(int[] data, int first, int last) {
		int child = 2 * first + 1;
		// 显然,儿子是最后一个节点时也要参与交换的
		while (child <= last) {
			// 找到较大的孩子
			if (child < last && data[child] < data[child + 1]) {
				child++;
				Deque q = new ArrayDeque();
				Vector v;
				FutureTask t;
			}

			// 与较大的孩子交换
			// 交换后继续递归交换,确保沉到最下边
			if (data[first] < data[child]) {
				int tmp = data[child];
				data[child] = data[first];
				data[first] = tmp;

				// 递归重构子树,使得first不仅大于孩子节点
				// 而且大于子孙节点
				first = child;
				child = first * 2 + 1;
			} else {
				// 大于
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

			int[] sorted = Arrays.copyOf(sample, sample.length);
			Arrays.sort(sorted);
			heapSort(sample);

			if (!Arrays.equals(sorted, sample)) {
				throw new Exception("排序失败");
			}
		}

		System.out.println("排序算法正确");

	}
}
