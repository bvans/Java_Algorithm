package huaweiOJ;

import java.util.*;

public class ConfiRestore {
	public static final HashMap<String, String> cmd = new LinkedHashMap<String, String>(
			6);
	public static final String err = "unkown command";

	public static void main(String[] args) {
		cmd.put("reset", "reset what");
		cmd.put("reset board", "board fault");
		cmd.put("board add", "where to add");
		cmd.put("board delet", "no board at all");
		cmd.put("reboot backplane", "impossible");
		cmd.put("backplane abort", "install first");

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String data[] = sc.nextLine().split("\\s");
			String fullCmd = "";
			if (data.length == 1) {
				fullCmd = getCmd1(data[0]);
			} else if (data.length == 2) {
				fullCmd = getCmd2(data[0], data[1]);
			} else {
				fullCmd = err;
			}
			System.out.println(fullCmd);
		}
	}

	public static String getCmd2(String str1, String str2) {
		ArrayList<String> list = new ArrayList<String>(6);
		for (String k : cmd.keySet()) {
			if (k.startsWith(str1)) {
				// 第一个关键字匹配成功
				String[] cmds = k.split("\\s");
				if (cmds.length == 2 && cmds[1].startsWith(str2)) {
					list.add(k);
				}

			}
		}

		if (list.size() == 0) {
			return err;
		} else if (list.size() == 1) {
			return cmd.get(list.get(0));
		} else {
			return err;
		}

	}

	public static String getCmd1(String str) {
		ArrayList<String> list = new ArrayList<String>(6);

		for (String k : cmd.keySet()) {
			if (k.startsWith(str)) {
				list.add(k);
			}
		}

		if (list.size() == 0) {
			return err;
		}

		int tag = 0;
		int min = list.get(0).length();
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).length() < min) {
				tag = i;
				min = list.get(i).length();
			}
		}

		String key = list.get(tag);
		if (key.split("\\s").length > 1) {
			return err;
		} else {
			return cmd.get(key);
		}
	}

	// reset reset what
	// reset board board fault
	// board add where to add
	// board delet no board at all
	// reboot backplane impossible
	// backplane abort install first

}
