package algorithm.leeCode.tree;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) {
            if(p == q) {
                return true;
            } else {
                return false;
            }
        }
        if(p.val != q.val) {
            return false;
        }
        
        if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
            return true;
        } else {
            return false;
        }
    }
}
