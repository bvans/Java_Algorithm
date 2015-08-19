package huaweiOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Train {
	public static void main(String[] args) {
		int[] data = new int[] { 1, 2, 3 };
		// printAll(data);

		// getStr(data, lists);

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			LinkedList<LinkedList<Integer>> lists = new LinkedList<LinkedList<Integer>>();
			int size = sc.nextInt();
			int[] id = new int[size];
			for (int i = 0; i < size; ++i) {
				id[i] = sc.nextInt();
			}
			Arrays.sort(id);
			getStr(id, lists);

			for (LinkedList<Integer> item : lists) {
				String result = "";
				for (int i : item) {
					result += i + " ";
				}
				System.out.println(result.trim());
			}

			// System.out.println(lists.size());
		}

	}

	public static void printAll(int[] data) {

		for (int i = 0; i < data.length - 1; i++) {

			for (int j = i + 1; j < data.length; j++) {
				int[] tmp = Arrays.copyOf(data, data.length);
				int cur = tmp[i];
				tmp[i] = tmp[j];
				tmp[j] = cur;
				System.out.println(Arrays.toString(tmp));
			}

		}
	}

	public static void getStr(int[] data, LinkedList<LinkedList<Integer>> list) {
		if (data.length == 1) {
			LinkedList<Integer> listItem = new LinkedList<Integer>();
			listItem.add(data[0]);
			list.add(listItem);
			return;
		}

		int cur = data[0];
		int[] sub = Arrays.copyOfRange(data, 1, data.length);
		getStr(sub, list);

		int curSize = list.size();
		for (int i = 0; i < curSize; i++) {
			LinkedList<Integer> listItem = list.get(i);

			for (int j = 1; j <= listItem.size(); j++) {
				LinkedList<Integer> newItem = new LinkedList<Integer>(listItem);
				newItem.add(j, cur);
				list.add(newItem);
			}
			listItem.addFirst(cur);
		}
	}
}
