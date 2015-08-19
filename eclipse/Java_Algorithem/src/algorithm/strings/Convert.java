package algorithm.strings;

import java.util.Comparator;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int stuCount = sc.nextInt();
			int opCount = sc.nextInt();
			
			int[] students = new int[stuCount];
			for (int i = 0; i < stuCount; ++i){
				students[i] = sc.nextInt();
			}
			
		}
	}
	
	private class Studnet implements Comparator<Studnet> {

		@Override
		public int compare(Studnet o1, Studnet o2) {
			return 0;
		}

		
	}
}
