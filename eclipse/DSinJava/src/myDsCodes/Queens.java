package myDsCodes;

public class Queens {
	static final boolean available = true;

	// norm用于右对角线row-col+norm得到一个正值.
	static final int squares = 8, norm = squares - 1;

	// i表示第i行的皇后放在positionInRow[i]列
	static int[] positionInRow = new int[squares];

	static boolean[] column = new boolean[squares];

	static boolean[] leftDiagonal = new boolean[(squares << 1) - 1];
	static boolean[] rightDiagonal = new boolean[(squares << 1) - 1];
	
	static int howMany = 0;

	Queens() {
		for (int i = 0; i < squares; i++) {
			positionInRow[i] = -1;
			column[i] = available;
		}

		for (int i = 0; i < squares * 2 - 1; i++) {
			leftDiagonal[i] = rightDiagonal[i] = available;
		}
	}
	
	public void printBroad() {
		for(int i = 0; i < squares; i++) {
			for(int j = 0; j < squares; j++) {
				if(positionInRow[i] == j) {
					System.out.print("♀ ");					
				} else {
					System.out.print("■ ");;
				}
			}
			System.out.println();
		}
		System.out.println("--------第" + ++howMany + "----------");
	}

	public void putQueue(int row) {
		for (int col = 0; col < squares; col++) {
			if (column[col] == available
					&& leftDiagonal[row + col] == available
					&& rightDiagonal[row - col + norm] == available) {

				positionInRow[row] = col;
				column[col] = !available;
				leftDiagonal[row + col] = !available;
				rightDiagonal[row - col + norm] = !available;
				
				if(row < squares - 1) {
					//有空间放置,则继续下一行
					putQueue(row + 1);
				} else {
					//已找到一种方法
					printBroad();
				}
				
				//row+1无位置已返回,则row继续尝试下一列
				column[col] = available;
				leftDiagonal[row + col] = available;
				rightDiagonal[row - col + norm] = available;

			}
		}
	}
	
	public static void main(String[] args) {
		Queens queen = new Queens();
		queen.putQueue(0);
	}
}
