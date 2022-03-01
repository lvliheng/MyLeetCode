package p0111_Minimum_Depth_of_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

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
		
		System.out.println("2 --> " + minDepth2(root));
	}
	
	public static int minDepth(TreeNode root) {
        if(root == null) return 0;
		
        if(root.left == null) return 1 + minDepth(root.right);
        if(root.right == null) return 1 + minDepth(root.left);
        
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
	
	public static int minDepth2(TreeNode root) {
		if(root == null) return 0;
		
		int result = 0;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			result++;
			
			for(int i = queue.size(); i > 0; i--) {
				TreeNode node = queue.poll();
				
				if(node.left == null && node.right == null) return result;
				
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
		}
		
		return -1;
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
