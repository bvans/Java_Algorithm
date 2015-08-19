package huaweiOJ;

import java.util.*;

public class GetTree {
	public static void main(String[] args) {
		// int[] pre = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
		// int[] in = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int size = sc.nextInt();
			int[] pre = new int[size];
			int[] in = new int[size];
			for (int i = 0; i < size; ++i) {
				pre[i] = sc.nextInt();
			}
			for (int i = 0; i < size; ++i) {
				in[i] = sc.nextInt();
			}

			ArrayDeque<Integer> stack = new ArrayDeque<Integer>(8);
			getTree(pre, in, stack);

			String res = "";
			if (stack.size() != pre.length || stack.size() == 0) {
				res = "NO";
			} else {
				res = " ";
				while (!stack.isEmpty()) {
					res += stack.pop() + " ";
				}
			}

			System.out.println(res.trim());
		}

	}

	public static void getTree(int[] pre, int[] in, ArrayDeque<Integer> stack) {
		if (pre.length != in.length || pre.length == 0) {
			return;
		}

		int root = pre[0];
		stack.push(root);

		int rootPos = -1;
		for (int i = 0; i < in.length; ++i) {
			if (in[i] == root) {
				rootPos = i;
				break;
			}
		}

		int[] leftIn = Arrays.copyOfRange(in, 0, rootPos);
		int[] rightIn = Arrays.copyOfRange(in, rootPos + 1, in.length);

		int[] leftPre = new int[leftIn.length];
		int[] rightPre = new int[rightIn.length];

		int count = 0;

		for (int j = 0; j < pre.length; j++) {
			for (int i = 0; i < leftIn.length; i++) {
				if (leftIn[i] == pre[j]) {
					leftPre[count++] = leftIn[i];
				}
			}
		}

		count = 0;
		for (int j = 0; j < pre.length; j++) {
			for (int i = 0; i < rightIn.length; i++) {

				if (rightIn[i] == pre[j]) {
					rightPre[count++] = rightIn[i];
				}
			}
		}

		// 判断是否合法

		if (leftPre.length != 0 && rightPre.length != 0) {
			int lastLeftPos = -1;
			int firstRightPos = -1;
			int lastLeft = leftPre[leftPre.length - 1];
			int firstRight = rightPre[0];

			for (int i = 0; i < pre.length; ++i) {
				if (pre[i] == lastLeft) {
					lastLeftPos = i;
				}
				if (pre[i] == firstRight) {
					firstRightPos = i;
				}
			}

			if (lastLeftPos == -1 || firstRightPos == -1) {
				return;
			} else if (lastLeftPos >= firstRightPos) {
				return;
			}
		}

		getTree(rightPre, rightIn, stack);
		getTree(leftPre, leftIn, stack);

	}
}
