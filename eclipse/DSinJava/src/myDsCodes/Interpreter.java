package myDsCodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		if((pos = idList.indexOf(tmp)) != -1) {
			//修改变量
			idList.get(pos).value = e;
		} else {
			idList.add(tmp);
		}
	}
	
	static double findValue(String id) {
		int pos;
		if((pos = idList.indexOf(new Id(id))) != -1) {
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
		if(i < input.length()) {
			ch = input.charAt(i++);
		} else {
			issueErr("不完整的表达式");
		}
	}
	
	static void skipBlanks() {
		while(Character.isSpace(ch))
			readCh();
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
		return id.equals(((Id)obj).id);
	}
	
	@Override
	public String toString() {
		return id + "=" + value + "; ";
	}
}