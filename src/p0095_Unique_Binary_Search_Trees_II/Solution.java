package p0095_Unique_Binary_Search_Trees_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {

		System.out.println("[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]] --> ");
		
		List<TreeNode> results = generateTrees(3);
		
		for(int i = 0; i < results.size(); i++) {
			TreeNode item = results.get(i);
			
			System.out.print(item.val + " ");
			
			while(item != null) {
				if(item.left == null && item.right == null) break;
				
				if(item.left != null) {
					System.out.print(item.left.val + " ");
				} else {
					if(item.left != null || item.right != null) {
						System.out.print("null ");
					}
				}
				
				if(item.right != null) {
					System.out.print(item.right.val + " ");
				} else {
					if(item.left.left != null || item.left.right != null) {
						System.out.print("null ");
					}
				}
				
				if(item.left != null) {
					item = item.left;
				} else if(item.right != null) {
					item = item.right;
				}
			}
			
			System.out.println();
		}
	}

	public static List<TreeNode> generateTrees(int n) {
		if (n == 0) return null;

		return helper(1, n);
	}

	private static List<TreeNode> helper(int start, int end) {
		List<TreeNode> result = new ArrayList<>();
		
		if (start > end) {
			result.add(null);
			return result;
		}
		
		for(int i = start; i <= end; i++) {
			List<TreeNode> left = helper(start, i - 1), right = helper(i + 1, end);
			
			for(TreeNode leftItem : left) {
				for(TreeNode rightItem : right) {
					TreeNode node = new TreeNode(i);
					node.left = leftItem;
					node.right = rightItem;
					result.add(node);
				}
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
