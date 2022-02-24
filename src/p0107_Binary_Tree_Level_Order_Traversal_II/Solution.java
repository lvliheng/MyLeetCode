package p0107_Binary_Tree_Level_Order_Traversal_II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[[15,7],[9,20],[3]] -->");
		
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(9);
		TreeNode right = new TreeNode(20);
		root.left = left;
		root.right = right;
		
		TreeNode left1 = new TreeNode(15);
		TreeNode right1 = new TreeNode(7);
		right.left = left1;
		right.right = right1;
		
		List<List<Integer>> result = levelOrderBottom2(root);
		
		for(List<Integer> list : result) {
			for(int item : list) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		return levelOrderBottom(root, 0, new ArrayList<>());
    }
	
	private static List<List<Integer>> levelOrderBottom(TreeNode root, int level, List<List<Integer>> result){
		if(root == null) return result;
		
		if(level == result.size()) result.add(0, new ArrayList<>());
		result.get(result.size() - level - 1).add(root.val);
		
		if(root.left != null) result = levelOrderBottom(root.left, level + 1, result);
		if(root.right != null) result = levelOrderBottom(root.right, level + 1, result);
		
		return result;
	}
	
	public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
			
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			List<Integer> current = new ArrayList<>();
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.remove();
				if(node != null) {
					current.add(node.val);
					queue.add(node.left);
					queue.add(node.right);
				}
			}
				
			if(!current.isEmpty()) {
				result.add(0, current);
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
