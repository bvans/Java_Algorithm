package huaweiOJ;

import java.util.Scanner;

public class Gcd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b= sc.nextInt();
		System.out.println(a * b / gcd(a, b));
	}
	
	public static int gcd (int a, int b) {
		if(a % b == 0) {
			return b;
		} else {
			return gcd (b, a % b);
		}
		
	}
}
