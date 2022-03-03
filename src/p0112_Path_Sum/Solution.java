package p0112_Path_Sum;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(8);
		root.left = left;
		root.right = right;
		
		TreeNode left11 = new TreeNode(11);
		left.left = left11;
		left.right = null;
		
		TreeNode left21 = new TreeNode(7);
		TreeNode right21 = new TreeNode(2);
		left11.left = left21;
		left11.right = right21;
		
		TreeNode left12 = new TreeNode(13);
		TreeNode right12 = new TreeNode(4);
		right.left = left12;
		right.right = right12;
		
		TreeNode right22 = new TreeNode(1);
		right12.left = null;
		right12.right = right22;
		
		System.out.println("true --> " + hasPathSum2(root, 22));
	}
	
	public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        
        if(root.left == null && root.right == null && root.val == targetSum) return true;
        
		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
	
	public static boolean hasPathSum2(TreeNode root, int targetSum) {
		if(root == null) return false;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		
		while(!stack.empty()) {
			TreeNode node = stack.pop();
			if(node.left == null && node.right == null) {
				if(node.val == targetSum) {
					return true;
				}
			}
			
			if(node.left != null) {
				node.left.val += node.val;
				stack.add(node.left);
			}
			
			if(node.right != null) {
				node.right.val += node.val;
				stack.add(node.right);
			}
		}
		
		return false;
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
