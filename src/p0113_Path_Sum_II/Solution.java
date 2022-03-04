package p0113_Path_Sum_II;

import java.util.ArrayList;
import java.util.List;

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
		
		TreeNode left22 = new TreeNode(5);
		TreeNode right22 = new TreeNode(1);
		right12.left = left22;
		right12.right = right22;
		
		System.out.println("[[5,4,11,2],[5,8,4,5]] --> " + pathSum2(root, 22));
	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		return helper(root, targetSum, new ArrayList<>(), new ArrayList<>());
    }
	
	private static List<List<Integer>> helper(TreeNode node, int sum, List<Integer> current, List<List<Integer>> result){
		if(node == null) return result;
		
		current.add(node.val);
		
		if(node.left == null && node.right == null && sum == node.val) {
			result.add(new ArrayList<>(current));
		}
		
		result = helper(node.left, sum - node.val, current, result);
		result = helper(node.right, sum - node.val, current, result);
		
		current.remove(current.size() - 1);
		
		return result;
	}
	
	public static List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
		List<List<Integer>> result = new ArrayList<>();
		List<TreeNode> list = new ArrayList<>();
		
		TreeNode current = root, pre = null;
		int value = 0;
		
		while(current != null || !list.isEmpty()) {
			while(current != null) {
				list.add(current);
				value += current.val;
				current = current.left;
			}
			
			current = list.get(list.size() - 1);
			
			if(current.left == null && current.right == null && value == targetSum) {
				List<Integer> temp = new ArrayList<>();
				
				for(TreeNode item : list) temp.add(item.val);
				
				result.add(temp);
			}
			
			if(current.right != null && current.right != pre) {
				current = current.right;
			} else {
				pre = current;
				value -= current.val;
				list.remove(list.size() - 1);
				current = null;
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
