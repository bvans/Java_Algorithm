package myDsCodes;

import java.beans.Expression;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Interpreter {
	static String input;
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader buffer = new BufferedReader(isr);
	static LinkedList<Id> idList = new LinkedList<Id>();

	static char ch;
	static int i = 0;

	static void issueErr(String s) {
		System.out.println(s);
		System.exit(-1);
	}

	static public void addOrModify(String id, double e) {
		Id tmp = new Id(new String(id), e);
		int pos;
		if ((pos = idList.indexOf(tmp)) != -1) {
			// 修改变量
			idList.get(pos).value = e;
		} else {
			idList.add(tmp);
		}
	}

	static double findValue(String id) {
		int pos;
		if ((pos = idList.indexOf(new Id(id))) != -1) {
			return idList.get(pos).value;
		} else {
			issueErr("无法识别的变量");
			return 0.0;
		}
	}

	static String getLine() {
		i = 0;
		System.out.flush();

		try {
			input = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("输入有误!");
		}
		return input;
	}

	static void readCh() {
		if (i < input.length()) {
			ch = input.charAt(i++);
		} else {
			issueErr("不完整的表达式");
		}
	}

	static void skipBlanks() {
		while (Character.isSpace(ch))
			readCh();
	}

	static String readId() {
		String id = "";
		skipBlanks();
		if (Character.isJavaIdentifierPart(ch)) {
			id += ch;
			readCh();
		} else {
			issueErr("请输入正确的标识符");
		}

		return id;
	}

	static double factor() {
		double var, minus = 1.0;
		readCh();
		skipBlanks();
		while (ch == '+' || ch == '-') {
			if (ch == '-') {
				minus *= -1.0;
			}
			readCh();
		}

		if (!Character.isDigit(ch) || ch == '.') {
			String number = "";
			while (Character.isDigit(ch)) {
				number += ch;
				readCh();
			}

			if (ch == '.') {
				number += ch;
				readCh();
			}

			while (Character.isDigit(ch)) {
				number += ch;
				readCh();
			}

			var = Double.valueOf(number).doubleValue();
		} else if (ch == '(') {
			var = expression();
			skipBlanks();
			if (ch == ')') {
				readCh();
			} else {
				issueErr("右括号丢了o(╯□╰)o");
			}
		} else {
			String id = readId();
			var = findValue(id);
		}
		skipBlanks();
		return minus * var;
	}

	static double term() {
		double f = factor();
		while (true) {
			switch (ch) {
			case '*':
				f *= factor();
				break;
			case '/':
				f /= factor();
				break;
			default:
				return f;

			}
		}
	}
	
	static double expression() {
		double t = term();
		while(true) {
			switch(ch) {
			case '+': 
				t += term();
				break;
				
			case '-':
				t -= term();
				break;
				
			default:
				return t;
			}
		}
	}
	
	static void getStatement() {
		System.out.println("输入语句:");
		getLine();
		readCh();
		
		String str = readId();
		if(str.toUpperCase().equals("STATUS")) {
			Iterator<Id> it = idList.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		} else if (str.toUpperCase().equals("PRINT")) {
			str = readId();
			System.out.println(str + "=" + findValue(str));
		} else if(str.toUpperCase().equals("END")){
			System.exit(0);
		} else {
			skipBlanks();
			if (ch == '=') {
				if (ch == '=') {
					double e = expression();
					if (ch != ';') {
						issueErr("语句输入错误");
					} else {
						addOrModify(str, e);
					}
				} else {
					issueErr("没有'='");
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("请输入语句表达式, print, status, end等指令中的一个.");
		while(true) {
			 getStatement();
		}
	}
}

class Id {
	private String id;
	double value;

	Id(String id, double value) {
		this.id = id;
		this.value = value;
	}

	Id(String id) {
		this(id, 0.0);
	}

	@Override
	public boolean equals(Object obj) {
		return id.equals(((Id) obj).id);
	}

	@Override
	public String toString() {
		return id + "=" + value + "; ";
	}
}