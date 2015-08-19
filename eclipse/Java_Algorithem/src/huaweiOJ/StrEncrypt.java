package huaweiOJ;

import java.util.Scanner;

public class StrEncrypt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str1 = sc.next().toCharArray();
		char[] str2 = sc.next().toCharArray();
		
		int toUp = 'A' - 'a';
		int toLow = 0 - toUp;
		
		for(int i = 0; i < str1.length; ++i) {
			char ch = str1[i];
			if(ch == '9') {
				ch = '0';
			} else if(ch >= '0' && ch <= '8') {
				ch++;
			} else if(ch == 'Z') {
				ch = 'a';
			} else if(ch == 'z') {
				ch = 'A';
			} else {
				ch = change(++ch);
			}
			System.out.print(ch);
		}
		
		System.out.println();
		
		for(int i = 0; i < str2.length; ++i) {
			char ch = str2[i];
			if(ch == '0') {
				ch = '9';
			} else if(ch >= '1' && ch <= '9') {
				ch--;
			} else if(ch == 'a') {
				ch = 'Z';
			} else if(ch == 'A') {
				ch = 'z';
			} else {
				ch = change(--ch);
			}
			System.out.print(ch);
		}
		
		System.out.println();
	}
	
	public static char change(char ch) {
		if(ch >= 'a' && ch <= 'z') {
			ch += 'A' - 'a';
		} else if(ch >= 'A' && ch <= 'Z') {
			ch += 'a' - 'A';
		}
		return ch;
	}
}
