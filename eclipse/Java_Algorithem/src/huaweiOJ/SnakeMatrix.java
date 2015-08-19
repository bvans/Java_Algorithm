package huaweiOJ;

import java.util.Scanner;

public class SnakeMatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] data = new int[n + 1][n + 1];
		data[0][1] = 1;
		
		for(int i = 1; i <= n; i++) {
			String result = " ";
			data[i][1] = data[i - 1][1] + i - 1; 
			result += data[i][1] + " ";
			for(int j = 2; j <= n - i + 1; j++) {
				data[i][j] = data[i][j - 1] + (i + j - 1);
				result += data[i][j] + " ";
			}
			System.out.println(result.trim());
		}
		
	}
}
