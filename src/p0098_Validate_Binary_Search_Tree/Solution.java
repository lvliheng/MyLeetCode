package p0098_Validate_Binary_Search_Tree;

public class Solution {

	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		node.left = node2;
		TreeNode node3 = new TreeNode(3);
		node.right = node3;
		
		System.out.println("true --> " + isValidBST(node));
	}
	
	public static boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
		return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
	
	private static boolean valid(TreeNode root, long low, long high) {
		if(root == null) return true;
		
		if(root.val <= low || root.val >= high) return false;
		
		return valid(root.left, low, root.val) && valid(root.right, root.val, high);
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
