package me.mhxy.tree;

import java.util.HashMap;

public class RBTree {
	Node root;

	void insertCase1(Node n) {
		// 默认的节点颜色为红色
		n.color = Node.RED;
		if (n.parent() == null) {
			// 情形1: 新节点是树根, 没有父节点P
			// 破坏了性质2
			n.color = Node.BLACK;
		} else {
			insertCase2(n);
		}
	}

	void insertCase2(Node n) {
		// 情形2: 新节点的父亲P是黑色的
		// 没有影响
		// 性质4: 黑色节点的孩子是红色节点? 遵守了
		// 性质5: 只关注黑色节点, 没有影响
		if (n.parent().color == Node.BLACK) {
			return;
		} else {
			insertCase3(n);
		}
	}

	void insertCase3(Node n) {
		// 情形3: p为红色, u也为红色
		// 违反了性质4
		if (n.uncle() != null && n.uncle().color == Node.RED) {
			// 能够从case2跳转到case3, 显然p是红色的
			n.parent().color = Node.BLACK;
			n.uncle().color = Node.BLACK;

			n.grandparent().color = Node.RED;
			// 因为祖父节点可能也是红色的，违反性质4，递归情形1.
			if(n.grandparent().color == Node.RED) {
				insertCase1(n.grandparent());
			}
		} else {
			insertCase4(n);
		}
	}

	void insertCase4(Node n) {
		//情形3: p红u黑
		if (n == n.parent().right && n.parent() == n.grandparent().left) {
			// n是父节点的右孩子, n的父亲是其祖父的左孩子
			
			//左旋父节点
			leftRotate(n.parent(), n.parent().parent());
			//处理左孩子
			n = n.left;
		} else if (n == n.parent().left && n.parent() == n.grandparent().right) {
			// n是父节点的左孩子, n的父亲是其祖父的右孩子
			
			//右旋父节点
			rightRotate(n.parent(), n.parent().parent());
			n = n.right;
			HashMap<Integer, Integer> map;
		}
		//情形4被变成情形5了
		
		insertCase5(n);
	}
	
	void insertCase5(Node n) {
		//情形5: p红u红, 且n为左(右)孩子, p也为左(右)孩子
		//改变父亲和祖父的颜色
		n.parent().color = Node.BLACK;
		n.parent().parent().color = Node.RED;
		
		if(n == n.parent().left && n.parent() == n.parent().left) {
			//n是其父节点的左孩子, n的父节点同样是其祖父的左孩子
			//那么右旋其父节点
			rightRotate(n.grandparent(), n.grandparent().parent());
		} else {
			rightRotate(n.grandparent(), n.grandparent().parent());
		}
	}

	public void insert(Node node) {
		if (node == null) {
			return;
		}

		if (root == null) {
			root = node;
			insertCase1(node);
			return;
		}

		Node pre = null;
		Node cur = root;
		while (cur != null) {
			if (node.key < cur.key) {
				pre = cur;
				cur = cur.left;
			} else if (node.key > cur.key) {
				pre = cur;
				cur = cur.right;
			} else {
				// 已经存在相同的节点
				try {
					throw new Exception("key already exists!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		if (node.key < pre.key) {
			pre.left = node;
		} else {
			pre.right = node;
		}
	}

	public void leftRotate(Node a, Node aParent) {
		if (a.right == null)
			return;
		Node b = a.right;
		a.right = b.left;
		b.left = a;

		if (aParent.left == a) {
			aParent.left = b;
		} else {
			aParent.right = b;
		}
	}

	public void rightRotate(Node a, Node aParent) {
		if (a.left == null)
			return;

		Node b = a.left;
		a.left = b.right;
		b.right = a;

		if (aParent.left == a) {
			aParent.left = b;
		} else {
			aParent.right = b;
		}
	}

}

class Node {
	public static final int BLACK = 1;
	public static final int RED = 2;

	public int key;
	public int color;
	public Node left;
	public Node right;

	private Node parent;

	public Node(int key) {
		this.key = key;
	}

	public Node parent() {
		return parent;
	}

	public Node grandparent() {
		return parent == null ? null : parent.parent;
	}

	public Node uncle() {
		Node grandParent = grandparent();
		if (grandParent == null)
			return null;
		if (grandParent.left == this) {
			return grandParent.right;
		} else {
			return grandParent.left;
		}
	}

	public Node sibling() {
		if (parent == null)
			return null;

		if (parent.left == this) {
			return parent.right;
		} else {
			return parent.left;
		}
	}

}