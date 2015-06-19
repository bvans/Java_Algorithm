package myDsCodes;

import java.io.IOException;

public class GCD {
	/**
	 * 求最大公约数
	 */
	public static int get(int m, int n) {
		if(m % n == 0) {
			return n;
		} else {
			return get(n, n % m);
		}
	}
	
	
	public static int getChar(){
		int ch = -1 ;
		try {
			ch = System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ch;
	}
	
	public static void reverse() {
		
		int ch = getChar();
		if(ch != '\n') {
			reverse();
		}
		System.out.print(ch);
		
	}
	
	public static void main(String[] args) {
		reverse();
	}
}
