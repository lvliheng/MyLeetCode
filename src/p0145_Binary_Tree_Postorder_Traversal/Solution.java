package p0145_Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

	
	public static List<Integer> postorderTraversal(TreeNode root) {
        return helper(root, new ArrayList<>());
    }
	
	private static List<Integer> helper(TreeNode root, List<Integer> result) {
		if (root == null) {
			return result;
		}
		
		result.add(0, root.val);
		
		helper(root.right, result);
		helper(root.left, result);
		
		return result;
	}
	
	public static List<Integer> postorderTraversal2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		LinkedList<Integer> result = new LinkedList<>();
		TreeNode node = root;
		
		while(node != null || !stack.isEmpty()) {
			if (node != null) {
				stack.push(node);
				result.addFirst(node.val);
				node = node.right;
			} else {
				node = stack.pop();
				node = node.left;
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
