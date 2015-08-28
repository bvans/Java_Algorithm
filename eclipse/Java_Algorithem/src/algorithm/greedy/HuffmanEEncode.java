package algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 使用小顶堆
 */
public class HuffmanEEncode {

	public static void main(String[] args) {
		Word<String>[] words = new Word[6];
		words[0] = new Word(45, "a");
		words[1] = new Word(13, "b");
		words[2] = new Word(12, "c");
		words[3] = new Word(16, "d");
		words[4] = new Word(9, "e");
		words[5] = new Word(5, "f");
		
		words = new HuffmanEEncode().encode(words);
		System.out.println(words);
	}

	int heapLast;
	public Word[] encode(Word[] heap) {
		//Word<String>[] heap = new Word[words.length];
		heapLast = heap.length - 1;
		Arrays.sort(heap);

		for (int i = 0; i < heap.length - 1; i++) {
			Word<String> word1 = (Word<String>) removeRoot(heap, 0, heapLast--);
			Word<String> word2 = (Word<String>) removeRoot(heap, 0, heapLast--);

			int weight = word1.weight + word2.weight;
			String str = word1.str + word2.str;
			Word word = new Word(weight, str);

			heapLast = heapLast + 3;
			insert(heap, word, 0, heapLast);
		}
		
		return heap;
	}

	public void moveDown(Comparable[] heap, int target, int last) {
		int child = 2 * target + 1;
		while (child <= last) {
			if (child < last && heap[child].compareTo(heap[child + 1]) > 0) {
				child++;
			}

			if (heap[target].compareTo(heap[child]) > 0) {
				Comparable tmp = heap[child];
				heap[child] = heap[target];
				heap[target] = tmp;

				target = child;
				child = 2 * target + 1;
			} else {
				break;
			}
		}
	}

	public void moveUp(Comparable[] heap, int target, int root) {
		while (target != root) {
			int parent = (int) (target / 2.0);
			if (heap[target].compareTo(heap[parent]) < 0) {
				target = parent;
			}
		}
	}

	public Comparable removeRoot(Comparable[] heap, int root, int last) {
		Comparable srcRoot = heap[root];
		heap[root] = heap[last];
		heap[last] = null;
		moveDown(heap, root, heapLast);

		return srcRoot;
	}

	/**
	 * @param heap
	 * @param root
	 * @param last
	 * @return 空间足够, 返回true, 否则返回false
	 */
	public boolean insert(Comparable[] heap, Comparable target, int root,
			int last) {
		try {

			heap[last + 1] = target;
			moveUp(heap, last + 1, root);
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	static class Word<DataType> implements Comparable {
		int weight;
		DataType str;

		Word(int weight, DataType str) {
			this.weight = weight;
			this.str = str;
		}

		@Override
		public int compareTo(Object o) {
			return this.weight - ((Word<DataType>) o).weight;
		}

		@Override
		public String toString() {
			return str.toString() + ":" + weight;
		}
	}

}
