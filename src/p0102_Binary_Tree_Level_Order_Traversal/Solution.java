package p0102_Binary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.w3c.dom.Node;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[[3],[9,20],[15,7]] --> ");
		
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(9);
		TreeNode right = new TreeNode(20);
		root.left = left;
		root.right = right;
		
		TreeNode left1 = new TreeNode(15);
		TreeNode right1 = new TreeNode(7);
		right.left = left1;
		right.right = right1;
		
		
		List<List<Integer>> result = levelOrder2(root);
		
		for(List<Integer> list : result) {
			for(int item : list) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		return levelOrder(root, 0, new ArrayList<>());
    }
	
	private static List<List<Integer>> levelOrder(TreeNode node, int level, List<List<Integer>> result){
		if(node == null) return result;
		if(result.size() == level) result.add(new ArrayList<>());
		
		result.get(level).add(node.val);
		
		if(node.left != null) result = levelOrder(node.left, level + 1, result);
		if(node.right != null) result = levelOrder(node.right, level + 1, result);
		
		return result;
	}
	
	public static List<List<Integer>> levelOrder2(TreeNode root) {
		if(root == null) return new ArrayList<>();
		
		List<List<Integer>> result = new ArrayList<>();
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			List<Integer> current = new ArrayList<>();
			
			for(int i = queue.size(); i > 0; i--) {
				TreeNode node = queue.poll();
				current.add(node.val);
				
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
			}
			result.add(current);
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
