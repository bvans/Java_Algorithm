package algorithm.leeCode.tree;

public class ValidateBST {
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}

		boolean leftIsValid = isValidBST(root.left);
		boolean rightIsValid = isValidBST(root.right);

		if (leftIsValid && rightIsValid) {
			if (root.left == null && root.right == null) {
				return true;
			} else if (root.left != null && root.right != null) {
				TreeNode leftMax = getMaxRight(root.left);
				TreeNode rightMin = getMaxLeft(root.right);
				if (root.val > leftMax.val && root.val < rightMin.val) {
					return true;
				}
			} else if (root.right != null) {
				TreeNode rightMin = getMaxLeft(root.right);
				if (root.val < rightMin.val) {
					return true;
				}
			} else if (root.left != null) {
				TreeNode leftMax = getMaxRight(root.left);
				if (root.val > leftMax.val) {
					return true;
				}
			}
		}

		return false;
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

	/**
	 * 最左边的元素
	 */
	public static TreeNode getMaxRight(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode node = root.right;
		if (node == null) {
			return root;
		}

		while (node.right != null) {
			node = node.right;
		}

		return node;
	}
}
