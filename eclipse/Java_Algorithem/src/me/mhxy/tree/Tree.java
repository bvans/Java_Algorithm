package me.mhxy.tree;

import java.util.LinkedList;
import java.util.List;

public class Tree {
	public TreeNode root = null;

	public Tree() {
		this(null);
	}

	public Tree(int key) {
		this(new TreeNode(key));
	}

	public Tree(TreeNode root) {
		this.root = root;
	}

	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = getHeight(root.left);
		int right = getHeight(root.right);

		return left > right ? left + 1 : right + 1;

	}

	public static void preorder(TreeNode root) {
		if (root != null) {
			root.visit();
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			root.visit();
			inorder(root.right);
		}
	}

	public static void postorder(TreeNode root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			root.visit();
		}
	}

	public static void bfs(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		if (root != null) {
			queue.addLast(root);
			while (!queue.isEmpty()) {
				TreeNode node = queue.removeFirst();
				node.visit();
				if (node.left != null) {
					queue.addLast(node.left);
				}
				if (node.right != null) {
					queue.addLast(node.right);
				}
			}
		}
	}
	

	
	public static List<String> getNodes(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<String> nodes = new LinkedList<String>();
		
		if(root != null) {
			queue.add(root);
			nodes.add(root.val + "");
			while(!queue.isEmpty()) {
				TreeNode node = queue.removeFirst();
				
				
				if(node.left != null) {
					queue.add(node.left);
					nodes.add(node.left.val + "");
				} else if(node.right != null) {
					nodes.add("#");
				}
				
				if(node.right != null) {
					queue.add(node.right);
					nodes.add(node.right.val + "");
				} else if(node.left != null){
					nodes.add("#");
				}
			}
		}
		return nodes;
	}
	

	public static void main(String[] args) {
		BSTTree tree = new BSTTree(15);
		int[] data = { 4, 20, 1, 16, 25, 99 };

		for (int i = 0; i < data.length; i++) {
			tree.add(new TreeNode(data[i]));
		}

		System.out.println(getHeight(tree.root));
		System.out.println(getNodes(tree.root));
	}

}
