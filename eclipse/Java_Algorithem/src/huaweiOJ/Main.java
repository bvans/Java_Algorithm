package huaweiOJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;

		for (int i = 7; i <= num; i++) {
			if (i % 7 == 0) {
				count++;
			} else {
				int tmp = i;
				while (tmp > 0) {
					if (tmp % 10 == 7) {
						count++;
						break;
					}
					tmp = tmp / 10;
				}
			}
		}
		System.out.println(count);
	}
}



class Main2 {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Err> errs = new ArrayList<Err>(8);

		// Scanner sc = new Scanner(new File("test.txt"));
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String fileName = sc.next();
			int lineNO = sc.nextInt();

			Err err = new Err(fileName, lineNO);

			int i = 0;
			for (; i < errs.size(); i++) {
				Err e = errs.get(i);
				if (err.fileName.equals(e.fileName) && err.errLine == e.errLine) {
					e.count++;
					break;
				}
			}

			if (i == errs.size()) {
				// 结果集中没有
				if (errs.size() < 8) {
					errs.add(err);
				} else {
					errs.remove(0);
					errs.add(err);
				}
			}
		}
		sc.close();
		for (Err e : errs) {
			System.out.printf("%s %d %d", e.name, e.errLine, e.count);
			System.out.println();
		}
	}

	static class Err {
		String fileName;
		String name;
		int errLine;
		int count = 1;

		public Err(String fileName, int errLine) {
			this.errLine = errLine;
			this.fileName = fileName;
			this.name = new File(fileName).getName();
			if (name.length() > 16) {
				name = name.substring(name.length() - 16);
			}
		}

	}
}

class Main11 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// Scanner sc = new Scanner(new File("test.txt"));
		while (true) {
			String line = sc.nextLine();
			if (line.length() != 3) {
				break;
			}
			String data[] = line.split("\\s");
			int stuCount = Integer.valueOf(data[0]);
			int opCount = Integer.valueOf(data[1]);

			int[] students = new int[stuCount + 1];
			students[0] = -1;
			for (int i = 1; i < students.length; ++i) {
				students[i] = sc.nextInt();
			}

			for (int i = 0; i < opCount; ++i) {
				char op = sc.next().toUpperCase().charAt(0);
				if (op == 'Q') {
					int start = sc.nextInt();
					int end = sc.nextInt();
					int maxScore = -1;
					for (int j = start; j <= end && j < students.length; ++j) {
						if (students[j] > maxScore) {
							maxScore = students[j];
						}
					}
					System.out.printf("%d\n", maxScore);
					System.out.println();
				} else if (op == 'U') {
					int stuId = sc.nextInt();
					int score = sc.nextInt();
					students[stuId] = score;
				}
			}
		}
		sc.close();
	}
}
