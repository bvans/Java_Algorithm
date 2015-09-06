package concurrent;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class UnsafeTest {

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		UnsafeTest test = new UnsafeTest();

		Node[] nodes = new Node[10];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = test.new Node(i);
		}

		Node target = (Node) test.getObjectVolatile(nodes, 3);
		System.out.println(target.data);

	}

	Object getObjectVolatile(Object[] array, int index) {

		Unsafe u = getUnsafe();
		Class ak = Object[].class;
		int ABASE = u.arrayBaseOffset(ak);
		int scale = u.arrayIndexScale(ak);
		int ASHIFT = 31 - Integer.numberOfLeadingZeros(scale);

		long offset = ((long) index << ASHIFT) + ABASE;
		Object target = (u.getObjectVolatile(array, offset));
		return target;
	}

	/**
	 * 获取Unsafe的一个实例
	 */
	public static Unsafe getUnsafe() {
		Unsafe unsafe = null;
		try {
			Field filed = Unsafe.class.getDeclaredField("theUnsafe");
			filed.setAccessible(true);
			unsafe = (Unsafe) filed.get(null);
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return unsafe;
	}
}
