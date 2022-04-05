package p0144_Binary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	
	public static List<Integer> preorderTraversal(TreeNode root) {
        return helper(root, new ArrayList<>());
    }
	
	private static List<Integer> helper(TreeNode root, List<Integer> result) {
		if(root == null) return result;
		
		result.add(root.val);
		
		helper(root.left, result);
		helper(root.right, result);
		
		return result;
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
