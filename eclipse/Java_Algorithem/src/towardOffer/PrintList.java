package towardOffer;

public class PrintList {

	public static void main(String[] args) {
		Node root = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		root.next = second;
		second.next = third;

		printRecursively(root);

	}

	/**
	 * 递归打印
	 */
	static void printRecursively(Node root) {
		if (root == null) {
			return;
		}
		if (root.next == null) {
			System.out.println(root.data);
		} else {
			printRecursively(root.next);
			System.out.println(root.data);
		}

	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

}
