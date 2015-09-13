package towardOffer;

import java.util.LinkedList;

public class Print1ToMaxOfNDigits {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		int[] data = new int[] { 1, 2, 3, 4 };
		//new Print1().print1ToMaxOfNDigits(5);
		
		System.out.println(0 + '0');
	}
	
	static class Print2 {
		public void print1ToMaxOfNDigits(int n) {
			if(n < 0) 
				return;
			
			char[] number = new char[n + 1];
			
			for(int i = 0; i < 10; i++) {
				number[0] = (char) (i + '0');
			}
		}
	}

	static class Print1 {
		public void print1ToMaxOfNDigits(int n) {
			char[] num = new char[n + 1];
			for (int i = 0; i < num.length; i++) {
				num[i] = '0';
			}

			while (increment(num)) {
				print(num);
			}
		}

		private void print(char[] num) {
			int i = 0;
			for (; i < num.length; i++) {
				if (num[i] != '0')
					break;
			}
			for (; i < num.length; i++) {
				System.out.print(num[i]);
			}
			System.out.println();
		}

		private boolean increment(char[] num) {
			int right = num.length - 1;
			if (num[right] != '9') {
				num[right]++;
				return true;
			}

			num[right] = '0';
			for (int i = right - 1; i >= 0; i--) {
				if (num[i] != '9') {
					num[i]++;
					break;
				}
			}
			if (num[0] == '1') {
				return false;
			}

			return true;
		}
	}

}
