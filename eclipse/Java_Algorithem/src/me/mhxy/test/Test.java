package me.mhxy.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
			System.out.println( ":" + new Test().getRow(18));
	}

	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>(rowIndex + 1);
		for (int i = 0; i <= rowIndex; i++) {
			//int result = getFac(rowIndex) / getFac(i) / getFac(rowIndex - i);
			list.add((int) getBin(rowIndex, i));
		}
		return list;
	}

	public long getBin(int n, int k) {
		long numerator = getFac(k);

		long denominator = 1;
		if ( k > n /2) {
			return(getBin(n, n - k));
		}
		for (int i = 0; i < k; i++) {
			denominator *= n--;
		}

		return denominator / numerator;
	}

	public long getFac(int n) {
		if (n == 0) {
			return 1;
		}
		long x = 1;
		for (int i = 1; i <= n; i++) {
			x *= i;
		}
		return x;
	}

	public int majorityElement(int[] nums) {
		int major = 1;
		int second = 1;

		int majorEl = nums[0];
		int secondEl = majorEl;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == majorEl) {
				major++;
			} else {

			}
		}
		return 0;
	}
}
