import java.util.*;

public class Test {
	public static void main(String args[]) {
		ArrayDeque deque = new ArrayDeque<Integer>(1);
		deque.add(1);
		deque.add(2);
		deque.removeFirst();
	}
	
	public static void op(StringBuffer a, StringBuffer b) {
		a.append("b");
		b = a;
	}
}