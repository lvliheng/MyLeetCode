package p0103_Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[[3],[20,9],[15,7]] --> ");
		
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(9);
		TreeNode right = new TreeNode(20);
		root.left = left;
		root.right = right;
		
		TreeNode left1 = new TreeNode(15);
		TreeNode right1 = new TreeNode(7);
		right.left = left1;
		right.right = right1;
		
		
		List<List<Integer>> result = zigzagLevelOrder2(root);
		
		for(List<Integer> list : result) {
			for(int item : list) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return zigzagLevelOrder(root, 0, new ArrayList<>());
    }
	
	private static List<List<Integer>> zigzagLevelOrder(TreeNode root, int level, List<List<Integer>> result){
		if(root == null) return result;
		if(result.size() == level) result.add(new ArrayList<>());
		
		if(level % 2 == 0) {
			result.get(level).add(root.val);
		} else {
			result.get(level).add(0, root.val);
		}
		
		if(root.left != null) result = zigzagLevelOrder(root.left, level + 1, result);
		if(root.right != null) result = zigzagLevelOrder(root.right, level + 1, result);
		
		return result;
	}
	
	public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		if(root == null) return new ArrayList<>();
		
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean isLeftToRight = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> current = new ArrayList<>();
			
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				
				if(isLeftToRight) {
					current.add(node.val);
				} else {
					current.add(0, node.val);
				}
				
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
			
			result.add(current);
			isLeftToRight = !isLeftToRight;
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
