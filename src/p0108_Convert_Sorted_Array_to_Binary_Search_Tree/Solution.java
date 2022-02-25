package p0108_Convert_Sorted_Array_to_Binary_Search_Tree;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[0,-3,9,-10,null,5] / [0,-10,5,null,-3,null,9] --> ");
		
		printResult(sortedArrayToBST(new int[] {-10,-3,0,5,9}));
	}
	
	public static TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
    }
	
	private static TreeNode helper(int[] nums, int left, int right) {
		if(left > right) return null;
		
		int mid = left + (right - left) / 2;
		
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, left, mid - 1);
		node.right = helper(nums, mid + 1, right);
		
		return node;
	}
	
	private static void printResult(TreeNode node) {
		if(node != null) {
			System.out.print(node.val + " ");
			printResult(node.left);
			printResult(node.right);
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
