package p0114_Flatten_Binary_Tree_to_Linked_List;

public class Solution {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(5);
		root.left = left;
		root.right = right;
		
		TreeNode left11 = new TreeNode(3);
		TreeNode right11 = new TreeNode(4);
		left.left = left11;
		left.right = right11;
		
		TreeNode right12 = new TreeNode(6);
		right.left = null;
		right.right = right12;
		
		System.out.println("[1,null,2,null,3,null,4,null,5,null,6] --> ");
		
		flatten2(root);
		
		printResult(root);
	}
	
	public static void flatten(TreeNode root) {
        if(root == null) return;
        
        if(root.left != null) flatten(root.left);
        if(root.right != null) flatten(root.right);
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        
        while(root.right != null) root = root.right;
        
        root.right = temp;
    }
	
	public static void flatten2(TreeNode root) {
		TreeNode current = root;
		
		while(current != null) {
			if(current.left != null) {
				TreeNode node = current.left;
				
				while(node.right != null) node = node.right;
				
				node.right = current.right;
				current.right = current.left;
				current.left = null;
			}
			
			current = current.right;
		}
	}
	
	private static void printResult(TreeNode root) {
		if(root != null) {
			System.out.print(root.val + " ");
			
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
