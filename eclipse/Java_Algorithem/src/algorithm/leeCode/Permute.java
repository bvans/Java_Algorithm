package algorithm.leeCode;

import java.util.LinkedList;
import java.util.List;

public class Permute {
	public static List<List<Integer>> permute(int[] nums) {
		if (nums.length == 0) {
			return null;
		}

		if (nums.length == 1) {
			List<List<Integer>> lists = new LinkedList<List<Integer>>();
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(nums[0]);
			lists.add(list);
			return lists;
		}
		int[] sub = new int[nums.length - 1];
		int newVal = nums[0];
		System.arraycopy(nums, 1, sub, 0, sub.length);

		LinkedList<List<Integer>> subLists = (LinkedList<List<Integer>>) permute(sub);

		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		for (int i = 0; i < subLists.size(); i++) {
			LinkedList<Integer> subList = (LinkedList<Integer>) subLists.get(i);
			for (int j = 0; j < subList.size() + 1; j++) {
				LinkedList<Integer> list = new LinkedList<Integer>();
				list = (LinkedList<Integer>) subList.clone();
				list.add(j, newVal);
				lists.add(list);
			}
		}
		return lists;
	}
}
