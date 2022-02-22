package p0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[3,9,20,null,null,15,7] --> ");
		
		TreeNode result = buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
		
		printResult(result);
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
	
	public static TreeNode buildTree(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
		if(pLeft > pRight || iLeft > iRight) return null;
		
		int i = 0;
		for(i = iLeft; i < iRight; i++) {
			if(preorder[pLeft] == inorder[i]) break;
		}
		
		TreeNode current = new TreeNode(preorder[pLeft]);
		current.left = buildTree(preorder, pLeft + 1, pLeft + i - iLeft, inorder, iLeft, i - 1);
		current.right = buildTree(preorder, pLeft + i - iLeft + 1, pRight, inorder, i + 1, iRight);
		
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
