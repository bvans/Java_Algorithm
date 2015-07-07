package me.mhxy.tree;

import java.util.LinkedList;
import java.util.List;

public class BSTTree extends Tree{
	public TreeNode root = null;

	public BSTTree() {
		this(null);
	}

	public BSTTree(int key) {
		this(new TreeNode(key));
	}

	public BSTTree(TreeNode root) {
		this.root = root;
	}

	/**
	 * 归并删除法会改变树的高度,并且新树有可能非常不平衡
	 */
	private void deleteByMerging(int el) {
		TreeNode tmp, node, p = root, prev = null;
		// 找到要删除的节点的位置以及其父节点
		while (p != null && p.val != el) {
			prev = p;
			if (p.val > el) {
				p = p.right;
			} else {
				p = p.left;
			}
		}

		node = p;
		if (p != null && p.val == el) {
			if (node.right == null) {
				node = node.left;
			} else if (node.left == null) {
				node = node.right;
			} else {
				tmp = node.left;
				// tmp指向Node左子树最右边的节点(值最大的节点)
				while (tmp.right != null) {
					tmp = tmp.right;
				}
				// 将Node右子树挂到tmp的右子树上
				tmp.right = node.right;
				node = node.left;
			}

			if (p == root) {
				root = node;
			} else if (prev.left == p) {
				prev.left = node;
			} else {
				prev.right = node;
			}
		} else if (root != null) {
			System.out.println(el + "不在树上");
		} else {
			System.out.println("空树");
		}

	}

	private void delByCopying(int el) {
		TreeNode node, p = root, prev = null;

		// 找到要删除的节点及其父母
		while (p != null && p.val != el) {
			prev = p;
			if (p.val > el) {
				p = p.left;
			} else {
				p = p.right;
			}
		}

		node = p;
		if (p != null && p.val == el) {
			if (node.right == null) {
				node = node.left;
			} else if (node.left == null) {
				node = node.right;
			} else {
				TreeNode tmp = node.left;
				TreeNode previous = node;

				// 找到node的前驱节点(data值的前驱)
				while (tmp.right != null) {
					previous = tmp;
					tmp = tmp.right;
				}

				node.val = tmp.val;

				if (previous == node) {
					previous.left = tmp.left;
				} else {
					previous.right = tmp.left;
				}
			}

			if (p == root) {
				root = node;
			} else if (prev.left == p) {
				prev.left = node;
			} else {
				prev.right = node;
			}
		} else if (root != null) {
			System.out.println("没找到" + el);
		} else {
			System.out.println("空树");
		}
	}

	public void add(TreeNode node) {
		if (root == null) {
			root = node;
			return;
		}

		TreeNode parent = null;
		TreeNode child = root;
		while (child != null) {
			if (node.val < child.val) {
				parent = child;
				child = child.left;
			} else {
				parent = child;
				child = child.right;
			}
		}
		child = node;
		if (node.val > parent.val) {
			parent.right = child;
		} else {
			parent.left = child;
		}

	}


	public TreeNode search(int key) {
		TreeNode p = root;
		while (p != null) {
			if (p.val == key) {
				return p;
			} else if (key > p.val) {
				p = p.right;
			} else {
				p = p.left;
			}
		}
		return null;
	}

	


	public static void main(String[] args) {
		BSTTree tree = new BSTTree(15);
		int[] data = { 4, 20, 1, 16, 25, 99 };

		for (int i = 0; i < data.length; i++) {
			tree.add(new TreeNode(data[i]));
		}

		System.out.println(getHeight(tree.root));
		System.out.println(Tree.getNodes(tree.root));
		
	}

}
