package algorithm.leeCode.tree;

import java.util.LinkedList;
import java.util.List;

public class KthSmallestNode {
	public int tmp = 0;

	public int kthSmallest(TreeNode root, int k) {
		LinkedList<Integer> nodes = new LinkedList<Integer>();
		getNodes(root, nodes);
		return nodes.get(k - 1);
	}

	public void getNodes(TreeNode root, List<Integer> nodes) {
		if (root != null) {
			getNodes(root.left, nodes);
			nodes.add(root.val);
			getNodes(root.right, nodes);
		}
	}
}
