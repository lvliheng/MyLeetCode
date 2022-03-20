package p0129_Sum_Root_to_Leaf_Numbers;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		
		System.out.println("25 --> " + sumNumbers2(root));
	}
	
	public static int sumNumbers(TreeNode root) {
		return sumNumbersDFS(root, 0);
	}
	
	private static int sumNumbersDFS(TreeNode root, int sum) {
		if(root == null) return 0;
		
		sum = sum * 10 + root.val;
		
		if(root.left == null && root.right == null) return sum;
		
		return sumNumbersDFS(root.left, sum) + sumNumbersDFS(root.right, sum);
	}
	
	public static int sumNumbers2(TreeNode root) {
		if(root == null) return 0;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		
		int result = 0;
		
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			
			if(temp.left == null && temp.right == null) {
				result += temp.val;
			}
			
			if(temp.right != null) {
				temp.right.val += temp.val * 10;
				stack.add(temp.right);
			}
			if(temp.left != null) {
				temp.left.val += temp.val * 10;
				stack.add(temp.left);
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
