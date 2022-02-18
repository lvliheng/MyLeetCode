package p0101_Symmetric_Tree;

public class Solution {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		root.left = left;
		root.right = right;
		
		TreeNode left1 = new TreeNode(3);
		TreeNode right1 = new TreeNode(4);
		left.left = left1;
		left.right = right1;
		
		TreeNode left2 = new TreeNode(4);
		TreeNode right2 = new TreeNode(3);
		right.left = left2;
		right.right = right2;
		
		System.out.println("true --> " + isSymmetric(root));
	}
	
	public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
		
		return isSymmetric(root.left, root.right);
    }
	
	public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
		
        if(left != null && right == null || left == null && right != null || left.val != right.val) return false;
		
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;       
			this.left = left;
			this.right = right;
		}
	}

}
