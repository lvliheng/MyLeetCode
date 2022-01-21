package p0094_Binary_Tree_Inorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Solution {

	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = null;
		TreeNode node2 = new TreeNode(2);
		node.right = node2;
		TreeNode node3 = new TreeNode(3);
		node2.left = node3;
		
		System.out.println("[1,3,2] --> " + inorderTraversal2(node));
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null || !stack.isEmpty()) {
        	if(root != null) {
        		stack.push(root);
        		root = root.left;
        	} else {
        		TreeNode node = stack.pop();
        		result.add(node.val);
        		root = node.right;
        	}
        }
        
        return result;
    }
	
	public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        inorder(root, result);
        
        return result;
    }
	
	private static List<Integer> inorder(TreeNode root, List<Integer> result){
		if(root == null) return result;
		
		if(root.left != null) result = inorder(root.left, result);
		
		result.add(root.val);
		
		if(root.right != null) result = inorder(root.right, result);
		
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
