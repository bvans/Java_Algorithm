package me.mhxy.tree;


public class TreeNode{
	public TreeNode left;
	public TreeNode right;
	public int val;
	
	public TreeNode() {
		
	}
	
	public TreeNode(int data) {
		this.val = data;
	}
	
	public TreeNode(int data, TreeNode left, TreeNode right) {
		this.val = data;
		this.left = left;
		this.right = right;
	}
	
	public int visit() {
		return val;
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(((TreeNode)obj).val);
	}

}
