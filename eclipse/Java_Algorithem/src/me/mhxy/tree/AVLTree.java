package me.mhxy.tree;

public class AVLTree extends BSTTree {
	public AVLTree() {
		super();
	}

	public AVLTree(TreeNode root) {
		super(root);
	}

	public AVLTree(int el) {
		super(el);
	}

	/**
	 * 以root为轴进行顺时针旋转
	 * @return 新的root节点
	 */
	protected static TreeNode rightRotate(TreeNode root) {
		TreeNode newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		return newRoot;
	}
	
	/**
	 * 以root为轴进行逆时针旋转
	 * @return 新的root节点
	 */
	protected static TreeNode leftRotate(TreeNode root) {
		TreeNode newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		return newRoot;
	}
	
	
	
	@Override
	public void add(TreeNode node) {
		if(node == null) {
			return;
		}
		
		super.add(node);
		int leftHeight = getMaxDepth(root.left);
		int rightHeight = getMaxDepth(root.right);
		
		if(node.val < root.val) {
			if((leftHeight - rightHeight) == 2) {
				//不平衡
				if(node.val < root.left.val) {
					//LL情况,位于左子树的左子树上,右旋根节点即可
					rightRotate(root);
				} else {
					//LR情况,先左旋(根节点的左孩子),再右旋(根节点)
					leftRotate(root.left);
					rightRotate(root);
				}
			} 
		} else {
			if((rightHeight - leftHeight) == 2) {
				//不平衡
				if(node.val > root.right.val) {
					//RR情况
					leftRotate(root);
				} else {
					//RL情况
					rightRotate(root.right);
					leftRotate(root);
				}
			}
		}
	}
	
}
