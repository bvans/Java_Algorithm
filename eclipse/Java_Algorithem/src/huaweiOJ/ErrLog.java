package huaweiOJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ErrLog {
	public static void main(String[] args) throws FileNotFoundException {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("test.txt"));
		while (sc.hasNext()) {
			String fileName = getName(sc.next());
			int lineNum = sc.nextInt();
			String key = fileName + " " + lineNum;

			if (map.get(key) == null) {
				map.put(key, 1);
			} else {
				map.put(key, map.get(key) + 1);
			}
		}
		sc.close();
		
		int count = 0;
		for(String key : map.keySet()) {
			if(count == 8) {
				break;
			}
			
			String record[] = key.split(" ");
			String fileName = record[0];
			if(fileName.length() > 16) {
				fileName = fileName.substring(fileName.length() - 16);
			}
			int lineNum = Integer.valueOf(record[1]);
			int value = map.get(key);
			System.out.printf("%s %s %d", fileName, lineNum, value);
			System.out.println();
		}
	}

	public static String getName(String name) {
		return new File(name).getName();
	}

}
