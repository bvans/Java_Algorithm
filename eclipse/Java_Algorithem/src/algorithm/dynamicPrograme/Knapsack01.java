package algorithm.dynamicPrograme;

import java.util.LinkedList;
import java.util.List;

public class Knapsack01 {

	public static void main(String[] args) {
		System.out.println(getSolution(new int[] { 1, 3, 4, 5, }, 9));
	}
	

	/**
	 * 只考虑重量, 没有价值
	 */
	public static List<Integer> getSolution(int[] weight, int capacity) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		int dp[][] = new int[weight.length + 1][capacity + 1];

		int i, j;
		for (i = 1; i < weight.length + 1; i++) {
			for (j = 1; j < capacity + 1; j++) {
				if (weight[i - 1] <= j) {
					//递推公式
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j
							- weight[i - 1]]
							+ weight[i - 1]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		if (dp[weight.length][capacity] < capacity) {
			return result;
		}

		i = weight.length;
		j = capacity;
		while (j >= 0 && i >= 1) {
			if (dp[i][j] > dp[i - 1][j]) {
				result.add(weight[i - 1]);
				j -= weight[i - 1];
			}
			i--;
		}

		return result;
	}
}
