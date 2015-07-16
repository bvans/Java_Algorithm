package me.mhxy.tree;

import java.util.LinkedList;
import java.util.List;

public class BSTIterator {

	private int index;
	private final List<TreeNode> nodes;

	public BSTIterator(TreeNode root) {
		nodes = inorderIteratively(root);
	}

	private List<TreeNode> inorderIteratively(TreeNode node) {
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			nodes.add(node);
			node = node.right;
		}
		return nodes;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return (index < nodes.size());
	}

	/** @return the next smallest number */
	public int next() {
		String t ;
		System.out.println(Inner.a);
		return nodes.get(index++).val;
	}
	
	class Inner {
		public static final int a = 0;
	}
}
