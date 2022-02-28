package p110_Balanced_Binary_Tree;

public class Solution {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(9);
		TreeNode right = new TreeNode(20);
		root.left = left;
		root.right = right;
		
		TreeNode left1 = new TreeNode(15);
		TreeNode right1 = new TreeNode(7);
		right.left = left1;
		right.right = right1;
		
		System.out.print("true --> " + isBalanced2(root));
	}
	
	public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        if(Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) return false;
		
		return isBalanced(root.left) && isBalanced(root.right);
    }
	
	private static int getDepth(TreeNode root) {
		if(root == null) return 0;
		
		return 1 + Math.max(getDepth(root.left), getDepth(root.right));
	}
	
	public static boolean isBalanced2(TreeNode root) {
		if(getDepth2(root) == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	private static int getDepth2(TreeNode root) {
		if(root == null) return 0;
		
		int left = getDepth2(root.left);
		if(left == -1) return -1;
		
		int right = getDepth2(root.right);
		if(right == -1) return -1;
		
		int diff = Math.abs(left - right);
		if(diff > 1) {
			return -1;
		} else {
			return 1 + Math.max(left, right);
		}
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
