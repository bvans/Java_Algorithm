import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Test {
	public static int staticInt = 123;
	public static void increase(Integer a) {
		a = new Integer(133);
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		
		BufferedReader br = new BufferedReader(isr);
	}
	
	static class InnerTest{
		static {
			System.out.println(Test.staticInt);
		}
	}
}
