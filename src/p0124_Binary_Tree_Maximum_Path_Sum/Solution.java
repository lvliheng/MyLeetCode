package p0124_Binary_Tree_Maximum_Path_Sum;

public class Solution {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		
		root.left = left;
		root.right = right;
		
		System.out.println("6 --> " + maxPathSum(root));
	}
	
	private static int result;
	
	public static int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        
        helper(root);
        
		return result;
    }
	
	private static int helper(TreeNode root) {
		if(root == null) return 0;
		
		int left = Math.max(helper(root.left), 0);
		int right = Math.max(helper(root.right), 0);
		
		result = Math.max(result, left + right + root.val);
		
		return Math.max(left, right) + root.val;
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
