package me.mhxy.math;

public class Fabonacci {
	public static int get(int n) {
		if (n < 2) {
			return n;
		}

		int i = 2, current = 1, last = 0, tmp = 0;
		for(; i <=n; i++) {
			tmp = current;
			current += last;
			last = tmp;
		}
		return current;
	} 
	
	public static void main(String[] args) {
		System.out.println(get(5));
	}
}
