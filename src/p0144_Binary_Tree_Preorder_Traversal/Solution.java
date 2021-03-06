package p0144_Binary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	
	public static List<Integer> preorderTraversal2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		TreeNode node = root;
		
		while(node != null || !stack.isEmpty()) {
			if(node != null) {
				stack.push(node);
				result.add(node.val);
				node = node.left;
			} else {
				node = stack.pop();
				node = node.right;
			}
		}
		
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
