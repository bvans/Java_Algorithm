package towardOffer;

public class ConstructBinaryTree {

	public static void main(String[] args) throws Exception {
		int[] preorder = new int[] { 1, 2, 4, 5, 3, 6 };
		int[] inorder = new int[] { 4, 2, 5, 1, 3, 6 };

		Node root = constructTree(preorder, 0, 5, inorder, 0, 5);
		System.out.println();
	}

	/**
	 * 代码尚有问题, 不能检测出错误输入
	 * @param preorder
	 * @param preStart
	 * @param preEnd
	 * @param inorder
	 * @param inStart
	 * @param inEnd
	 * @return
	 * @throws Exception
	 */
	static Node constructTree(int[] preorder, int preStart, int preEnd,
			int[] inorder, int inStart, int inEnd) throws Exception {

		if ((preEnd - preStart) != (inEnd - inStart)) {
			throw new Exception("输入错误");
		}

		if (preStart > preEnd) {
			return null;
		}

		if ((preEnd - preStart == 0)) {
			return new Node(preorder[preStart]);
		}

		Node root = new Node(preorder[preStart]);
		int rootPos = -1; // 根节点在Inorder中的位置
		for (int i = inStart; i <= inEnd; i++) {
			if (root.data == inorder[i]) {
				rootPos = i;
				break;
			}
		}

		int leftInStart = inStart;
		int leftInEnd = rootPos - 1;
		int leftLen = leftInEnd - leftInStart + 1;

		int leftPreStart = preStart + 1;
		int leftPreEnd = preStart + leftLen;

		int rightInStart = rootPos + 1;
		int rightInEnd = inEnd;

		int rightPreStart = leftPreEnd + 1;
		int rightPreEnd = preEnd;

		root.left = constructTree(preorder, leftPreStart, leftPreEnd, inorder,
				leftInStart, leftInEnd);
		root.right = constructTree(preorder, rightPreStart, rightPreEnd,
				inorder, rightInStart, rightInEnd);

		return root;
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}
}
