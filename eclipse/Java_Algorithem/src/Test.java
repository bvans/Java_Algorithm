import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

public class Test {
	public static void main(String[] args) {
		multiply("3456789", "129");

		System.out.println();
	}

	static String multiply(String num1, String num2) {
		char[] factor1 = num1.toCharArray();
		char[] factor2 = num2.toCharArray();
		char[][] finalRes = new char[num1.length() + num2.length() + 1][num1
				.length() + num2.length() + 1];

		for (int i = factor2.length - 1; i >= 0; i--) {

			int flag = 0;
			int count = finalRes[i].length - 1;
			for (int j = factor1.length - 1; j >= 0; j--) {
				int fac1 = 1 + (factor1[j] - '1');
				int fac2 = 1 + (factor2[factor2.length - 1] - '1');
				int result = fac1 * fac2 + flag;
				finalRes[i][count--] = (char) ((result % 10 - 1) + '1');
				flag = result / 10;
			}
			finalRes[i][count--] = (char) ('1' + (flag - 1));
			// 处理没有进位的0;
		}
		return new String();

	}
}
