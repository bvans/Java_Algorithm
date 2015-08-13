import java.util.*;

public class Test {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		final double PI = 3.1415927;
		while (cin.hasNextLine()) {
			double r = cin.nextDouble();
			System.out.printf("%.3f", 4.0 * PI * r * r * r/3);
			System.out.println();
		}
	}
}