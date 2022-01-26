package p0100_Same_Tree;

import java.util.Queue;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		
		TreeNode firstNode = new TreeNode(1);
		TreeNode secondNode = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		firstNode.left = node2;
		firstNode.right = node3;
		secondNode.left = node2;
		secondNode.right = node3;
		
		System.out.println("true --> " + isSameTree4(firstNode, secondNode));
	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		
		if((p != null && q == null) || (p == null && q != null) || (p.val != q.val)) return false;
		
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
	
	public static boolean isSameTree2(TreeNode p, TreeNode q) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(p);
		stack.push(q);
		
		while(!stack.isEmpty()) {
			p = stack.pop();
			q = stack.pop();
			
			if(p == null && q == null) continue;
			
			if((p != null && q == null) || (p == null && q != null) || (p.val != q.val)) return false;
			
			stack.push(p.right);
			stack.push(q.right);
			
			stack.push(p.left);
			stack.push(q.left);
		}
		
		return true;
	}
	
	public static boolean isSameTree3(TreeNode p, TreeNode q) {
		Stack<TreeNode> stack = new Stack<>();
		
		while(p != null || q != null || !stack.isEmpty()) {
			while(p != null || q != null) {
				if((p != null && q == null) || (p == null && q != null) || (p.val != q.val)) return false;
				stack.push(p);
				stack.push(q);
				p = p.left;
				q = q.left;
			}
			
			p = stack.pop();
			q = stack.pop();
			p = p.right;
			q = q.right;
		}
		
		return true;
	}
	
	public static boolean isSameTree4(TreeNode p, TreeNode q) {
		Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
		TreeNode head1 = null, head2 = null;
		
		while(p != null || q != null || !stack1.isEmpty() || ! stack2.isEmpty()) {
			while(p != null || q != null) {
				if((p != null && q == null) || (p == null && q != null) || (p.val != q.val)) return false;
				stack1.push(p);
				stack2.push(q);
				p = p.left;
				q = q.left;
			}
			
			p = stack1.peek();
			q = stack2.peek();
			
			if((p.right == null || p.right == head1) && (q.right == null || q.right == head2)) {
				if(!stack1.isEmpty()) stack1.pop();
				if(!stack2.isEmpty()) stack2.pop();
				head1 = p;
				head2 = q;
				p = null;
				q = null;
			} else {
				p = p.right;
				q = q.right;
			}
		}
		
		return true;
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
