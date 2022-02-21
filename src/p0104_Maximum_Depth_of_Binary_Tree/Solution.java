package p0104_Maximum_Depth_of_Binary_Tree;

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
		
		System.out.println("3 --> " + maxDepth2(root));
	}
	
	public static int maxDepth(TreeNode root) {
		return maxDepth(root, 0, 0);
    }
	
	public static int maxDepth(TreeNode root, int level, int result) {
        if(root == null) return result;
        if(level == result) result++;
        
        if(root.left != null) result = Math.max(result, maxDepth(root.left, level + 1, result));
        if(root.right != null) result = Math.max(result, maxDepth(root.right, level + 1, result));
		
		return result;
    }
	
	public static int maxDepth2(TreeNode root) {
		return root == null ? 0 : (1 + Math.max(maxDepth2(root.left), maxDepth2(root.right)));
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
