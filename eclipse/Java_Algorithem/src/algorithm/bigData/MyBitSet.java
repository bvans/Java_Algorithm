package algorithm.bigData;

public class MyBitSet {
	int[] bits;
	final int SHIFT = 5;
	final int MASK = 0x1F;
	

	public MyBitSet(int capacity) {
		bits = new int[capacity >> SHIFT];
	}

	public void set(int loc) {
		int index = loc >> SHIFT;
		int offeset = loc & MASK;
		bits[index] = bits[index] | (1 << offeset);
	}

	public void clear(int loc) {
		int index = loc >> SHIFT;
		int offeset = loc & MASK;
		bits[index] = bits[index] & (~(1 <<offeset));
	}
	
	public boolean get(int loc) {
		int index = loc >> SHIFT;
		int offset = loc & MASK;
		int tmp = bits[index] | (1 << offset);
		return tmp == bits[index];
	}

}
