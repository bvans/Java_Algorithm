package algorithm.others;

import java.util.Scanner;

public class MaxSub {

	/**
	 * 找出int数组中连续和最大的序列
	 * 
	 * @param int型序列
	 * @return 返回最大的序列和, 如果原始序列全为负, 则返回-1
	 */
	public static int getSum(int[] arr, int n) {
		int thisSum = 0;
		int maxSum = 0;
		
		for (int i = 0; i < n; i++) {
			thisSum += arr[i];
			if (thisSum > maxSum) {
				maxSum = thisSum;
			} else if (thisSum < 0) {
				thisSum = 0;
			}
		}
		return maxSum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n < 0 || n > 100000) {
			return;
		}
		
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(getSum(arr, n));
		return;
	}

}
