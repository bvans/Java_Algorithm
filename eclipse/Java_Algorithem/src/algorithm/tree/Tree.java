package algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	/**
	 * 层次遍历
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		LinkedList<List<Integer>> lists = new LinkedList<List<Integer>>();
		addLevel(lists, 0, root);
		return lists;
	}

	private static void addLevel(LinkedList<List<Integer>> lists, int level,
			TreeNode node) {
		if (node == null)
			return;

		if (lists.size() < level + 1) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			lists.add(level, list);
		}

		lists.get(level).add(node.val);
		addLevel(lists, level + 1, node.left);
		addLevel(lists, level + 1, node.right);

	}

	public static int getMaxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = getMaxDepth(root.left);
		int right = getMaxDepth(root.right);

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

	public static List<Integer> inorderIteratively(TreeNode root) {
		List<Integer> nodes = new LinkedList<Integer>();
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

			cur = stack.pop();
			if (cur.right == null) {
				nodes.add(cur.val);
				cur = null;
			} else {
				stack.push(cur);
				cur = cur.right;
			}

		}

		return nodes;
	}

	public static LinkedList<TreeNode> preorderIteratively(TreeNode root) {
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				nodes.add(cur);
				stack.push(cur);
				cur = cur.left;
			}

			cur = stack.pop();
			cur = cur.right;
		}

		return nodes;
	}

	public static void postorder(TreeNode root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			root.visit();
		}
	}

	public static List<Integer> postorderIteratively(TreeNode root) {
		List<Integer> nodes = new LinkedList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

		TreeNode cur = root;
		TreeNode visited = null;
		while (!stack.isEmpty()) {
			cur = stack.pop();
			if (cur.left == null && cur.right == null) {
				// 当前节点为叶子节点或者孩子节点都被访问过
				nodes.add(cur.val);
				stack.pop();
				visited = cur;
			} else if (visited != null) {
				if (visited == cur.left || visited == cur.right) {
					nodes.add(cur.val);
					stack.pop();
					visited = cur;
				}

			}

			else {
				if (cur.right != null) {
					stack.push(cur.right);
				}
				if (cur.left != null) {
					stack.push(cur.left);
				}
			}
		}
		return nodes;
	}

	public static void bfs(TreeNode root) {
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
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

		if (root != null) {
			queue.add(root);
			nodes.add(root.val + "");
			while (!queue.isEmpty()) {
				TreeNode node = queue.removeFirst();

				if (node.left != null) {
					queue.add(node.left);
					nodes.add(node.left.val + "");
				} else {
					nodes.add("#");
				}

				if (node.right != null) {
					queue.add(node.right);
					nodes.add(node.right.val + "");
				} else {
					nodes.add("#");
				}
			}

			while (nodes.getLast() == "#") {
				nodes.removeLast();
			}
		}

		return nodes;
	}

	public static TreeNode init(List<String> nodes) {

		if (nodes.isEmpty()) {
			return null;
		}

		// 首字符不合法
		TreeNode root = str2Node(nodes.get(0));
		if (root == null) {
			return null;
		}

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		int flag = 1;
		TreeNode node;
		while (!queue.isEmpty()) {
			node = queue.removeFirst();
			if (node != null) {

				if (flag >= nodes.size()) {
					break;
				}
			}
			TreeNode left = str2Node(nodes.get(flag));
			if (left != null) {
				queue.add(left);
			}
			node.left = left;
			flag++;

			if (flag >= nodes.size()) {
				break;
			}
			TreeNode right = str2Node(nodes.get(flag));
			if (right != null) {
				queue.add(right);
			}
			node.right = right;
			flag++;
		}
		return root;
	}

	private static TreeNode str2Node(String str) {
		TreeNode node;
		int val;

		try {
			val = Integer.valueOf(str);
			node = new TreeNode(val);
		} catch (NumberFormatException e) {
			node = null;
		}
		return node;
	}

	/**
	 * 最左边的元素
	 */
	public static TreeNode getMaxLeft(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode node = root.left;
		if (node == null) {
			return root;
		}

		while (node.left != null) {
			node = node.left;
		}

		return node;
	}

	public static TreeNode getMaxRight(TreeNode root) {
		if (root == null || root.right == null) {
			return root;
		}

		TreeNode node = root;
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	/**
	 * 针对于满二叉树
	 */
	public static void connect(TreeNode root) {
		if (root == null) {
			return;
		}

		TreeNode pre = root;
		TreeNode cur;
		while (pre.left != null) {
			cur = pre;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}

			pre = pre.left;
		}
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null && root.val == sum) {
			return true;
		}
		boolean leftHasSum = hasPathSum(root.left, sum - root.val);
		boolean rightHasSum = hasPathSum(root.right, sum - root.val);
		return leftHasSum || rightHasSum;

	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> curList = new LinkedList<Integer>();
		pathSumHelper(result, curList, root, sum);
		return result;
	}

	private static void pathSumHelper(List<List<Integer>> lists,
			List<Integer> curList, TreeNode root, int sum) {
		if (root == null) {
			return;
		}

		curList.add(root.val);
		if (root.left == null && root.right == null) {
			if (sum == root.val) {
				lists.add(new LinkedList<Integer>(curList));
			}
			curList.remove(curList.size() - 1);
			return;
		}

		pathSumHelper(lists, curList, root.left, sum - root.val);
		pathSumHelper(lists, curList, root.right, sum - root.val);
		curList.remove(curList.size() - 1);
	}

	public static int getSumNum(int curPathSum, TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return curPathSum * 10 + root.val;
		}

		int left = 0, right = 0;
		if (root.left != null) {
			left = getSumNum(curPathSum * 10 + root.val, root.left);
		}

		if (root.right != null) {
			right = getSumNum(curPathSum * 10 + root.val, root.right);
		}
		return left + right;
	}

	public static void getPaths(List<List<Integer>> lists,
			List<Integer> curList, TreeNode root) {
		if (root == null) {
			return;
		}

		curList.add(root.val);
		if (root.left == null && root.right == null) {
			// 叶子节点
			lists.add(new LinkedList<Integer>(curList));
			curList.remove(curList.size() - 1);
			return;
		}

		getPaths(lists, curList, root.left);
		getPaths(lists, curList, root.right);
		curList.remove(curList.size() - 1);

	}

	public static void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		flatten(root.left);
		flatten(root.right);

		TreeNode right = root.right;
		TreeNode left = root.left;
		root.left = null;
		root.right = left;

		TreeNode node = root;
		while (node.right != null) {
			node = node.right;
		}
		node.right = right;
	}

	public static void main(String[] args) {
		BSTTree tree = new BSTTree(15);

		String[] data = { "1", "2", "3", "6", "#", "7", "13", "#", "8" };
		// String[] data = { "5", "4", "8", "11", "13", "4", "7", "2", "5", "1"
		// };
		List<String> list = Arrays.asList(data);
		TreeNode root = init(list);
		// flatten(root);

		// LinkedList<TreeNode> nodes = postorderIteratively(root);
		// LinkedList<Integer> ints = new LinkedList<Integer>();
		// for (TreeNode node : nodes) {
		// ints.add(node.val);
		// }

		List<List<Integer>> result = levelOrder(root);
		System.out.println(result);
	}

}
