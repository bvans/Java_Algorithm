package huaweiOJ;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;


public class StringSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] data = sc.nextLine().toCharArray();
		
		LinkedList<Ch> letters = new LinkedList<StringSort.Ch>();
		LinkedHashMap<Integer, Character> non = new LinkedHashMap<Integer, Character>();
		for(int i = 0; i < data.length; i++) {
			char ch = data[i];
			if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
				letters.add(new Ch(ch));
			} else {
				non.put(i, ch);
			}
		}
		
		Collections.sort(letters);
		int extra = non.size();
		for(int k : non.keySet()) {
			letters.add(k, new Ch(non.get(k)));
		}
		for(Ch ch : letters) {
			System.out.print(ch.toString());
		}
		System.out.println();
		
	}

	static class Ch implements Comparable<Ch> {
		char ch;

		public Ch(char ch) {
			this.ch = ch;
		}

		@Override
		public int compareTo(Ch o) {
			return String.valueOf(ch).compareToIgnoreCase(String.valueOf(o.ch));
		}
		
		@Override
		public String toString() {
			return String.valueOf(ch);
		}

	}
}
