package towardOffer;

public class HasSubtree {
	public boolean hasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null)
			return false;

		while (root1 != null) {
			boolean result = false;
			if (root1.val == root2.val) {
				// 处理
				result = equal(root1, root2);
			}
			if (result)
				return true;
			result = hasSubtree(root1.left, root2);
			if (result)
				return true;
			return hasSubtree(root1.right, root2);
		}
		return false;
	}

	public boolean equal(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}

		if (root1.val != root2.val)
			return false;

		return equal(root1.left, root2.left) && equal(root1.right, root2.right);

	}
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}
}
