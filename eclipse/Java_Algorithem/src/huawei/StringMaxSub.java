package huawei;

import java.util.*;

public class StringMaxSub {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str1 = sc.next().toCharArray();
		char[] str2 = sc.next().toCharArray();
		
		ArrayList<Character> list1 = new ArrayList<Character>(str1.length);
		ArrayList<Character> list2 = new ArrayList<Character>(str2.length);
		for(int i = 0; i < str1.length; ++i) {
			list1.add(str1[i]);
		}
		for(int i = 0; i < str2.length; ++i) {
			list2.add(str2[i]);
		}
		
		System.out.println(list1.get(0) == list2.get(0));
		list1.retainAll(list2);
		System.out.println();
	}
}
