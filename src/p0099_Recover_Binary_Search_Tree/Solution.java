package p0099_Recover_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		node.left = node2;
		node.right = null;
		TreeNode node3 = new TreeNode(2);
		node2.left = null;
		node2.right = node3;
		
		System.out.println("[3,1,null,null,2] --> ");
		
		recoverTree2(node);
	}
	
	public static void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        List<Integer> vals = inorder(root, list, new ArrayList<>());
        
        Collections.sort(vals);
        
        for( int i = 0; i < list.size(); i++) {
        	list.get(i).val = vals.get(i);
        }
        
        printResult(root);
    }
	
	private static List<Integer> inorder(TreeNode root, List<TreeNode> list, List<Integer> vals){
		if(root == null) return vals;
		
		vals = inorder(root.left, list, vals);
		
		list.add(root);
		vals.add(root.val);
		
		vals = inorder(root.right, list, vals);
		
		return vals;
	}
	
	public static void recoverTree2(TreeNode root) {
		TreeNode first = null, second = null, curr = root, pre = null;
		
		while(curr != null) {
			if(curr.left != null) {
				TreeNode temp = curr.left;
				
				while(temp.right != null && temp.right != curr) temp = temp.right;
				
				if(temp.right == null) {
					temp.right = curr;
					curr = curr.left;
					continue;
				} else {
					temp.right = null;
				}
			}
			
			if(pre != null && curr.val < pre.val) {
				if(first == null) first = pre;
				second = curr;
			}
			
			pre = curr;
			curr = curr.right;
		}
		
		if(first != null && second != null) {
			int temp = first.val;
			first.val = second.val;
			second.val = temp;
		}
		
		printResult(root);
	}
	
	private static void printResult(TreeNode root){
		System.out.print(root.val + " ");
		
		while(root != null) {
			if(root.left == null && root.right == null) break;
			
			if(root.left != null) {
				System.out.print(root.left.val + " ");
			} else {
				if(root.left != null || root.right != null) {
					System.out.print("null ");
				}
			}
			
			if(root.right != null) {
				System.out.print(root.right.val + " ");
			} else {
				if(root.left.left != null || root.left.right != null) {
					System.out.print("null ");
				}
			}
			
			if(root.left != null) {
				root = root.left;
			} else if(root.right != null) {
				root = root.right;
			}
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
