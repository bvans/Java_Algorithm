import java.util.AbstractMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String args[]) {
		for(int i = 0; i < 1000000; i++) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void testGreedy() {
		Pattern p = Pattern.compile(".*?foo");
		String strText = "xfooxxxxxxfoo";
		Matcher m = p.matcher(strText);
		while (m.find()) {
			//System.out.println("matched form " + m.start() + " to " + m.end());
			System.out.println(m.group());
		}
	}
	
	public static void op(StringBuffer a, StringBuffer b) {
		a.append("b");
		b = a;
	}
}