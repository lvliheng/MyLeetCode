package p0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[3,9,20,null,null,15,7] --> ");
		
		TreeNode result = buildTree(new int[] {9,3,15,20,7}, new int[] {9,15,7,20,3});
		
		printResult(result);
	}
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
	
	private static TreeNode buildTree(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight) {
		if(iLeft > iRight || pLeft > pRight) return null;
		
		int i = 0;
		for(i = iLeft; i < iRight; i++) {
			if(inorder[i] == postorder[pRight]) break;
		}
		
		TreeNode current = new TreeNode(postorder[pRight]);
		current.left = buildTree(inorder, iLeft, i - 1, postorder, pLeft, pLeft + i - iLeft - 1);
		current.right = buildTree(inorder, i + 1, iRight, postorder, pLeft + i - iLeft, pRight - 1);
		
		return current;
	}
	
	public static void printResult(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "  ");
            printResult(root.left);
            printResult(root.right);
        }
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
