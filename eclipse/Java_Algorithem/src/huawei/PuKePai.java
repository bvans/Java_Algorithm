package huawei;

import java.util.Scanner;

public class PuKePai {

}

class Main {
	public static final int TYPE_GE = 1;
	public static final int TYPE_DUI = 2;
	public static final int TYPE_SAN = 3;
	public static final int TYPE_ZHADAN = 4;
	public static final int TYPE_SHUN = 5;
	public static final int TYPE_WANGZHA = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] pais = line.split("-");
		Pai first = new Pai(pais[0].trim());
		Pai second = new Pai(pais[1].trim());

		String result = "";

		if (first.getType() == second.getType()) {
			int type = first.getType();
			if (first.getStart() > second.getStart()) {
				result = first.src;
			} else {
				result = second.src;
			}
			System.out.println(result);
			return;
		}

		if (first.getType() == TYPE_WANGZHA || second.getType() == TYPE_WANGZHA) {
			System.out.println("joker JOKER");
		} else if (first.getType() == TYPE_ZHADAN) {
			System.out.println(first.src);
		} else if (second.getType() == TYPE_ZHADAN) {
			System.out.println(second.src);
		} else {
			System.out.println("ERROR");
		}

	}

	static class Pai {
		public String src;
		public String[] pais;

		public Pai(String pai) {
			this.src = pai;
			pais = pai.split("\\s");
		}

		/**
		 * 王炸返回100, A返回21, 2返回22, 小王返回31 ,大王返回32
		 */
		public int getStart() {
			int type = this.getType();
			char ch = pais[0].charAt(0);

			if (ch == 'A') {
				return 21;
			} else if (ch == '1') {
				return 10;
			} else if (ch == '2') {
				return 22;
			} else if (ch == 'j') {
				// 小王
				return 31;
			} else if (ch == 'J') {
				if (pais[0].length() != 1) {
					// 大王
					return 32;
				} else {
					return 11;
				}
			} else if (ch == 'Q') {
				return 12;
			} else if (ch == 'K') {
				return 13;
			} else {
				return Integer.valueOf(ch + "");
			}

		}

		public int getType() {
			if (pais.length != 2) {
				return pais.length;
			} else {
				if (pais[0].equals("joker") && pais[1].equals("JOKER")) {
					return TYPE_WANGZHA;
				} else {
					return TYPE_GE;
				}
			}

		}
	}

}