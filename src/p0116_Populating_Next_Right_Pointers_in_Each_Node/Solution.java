package p0116_Populating_Next_Right_Pointers_in_Each_Node;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[1,#,2,3,#,4,5,6,7,#] --> ");
		
		Node root = new Node(1);
		
		Node left = new Node(2);
		Node right = new Node(3);
		root.left = left;
		root.right = right;
		
		Node left1 = new Node(4);
		Node right1 = new Node(5);
		left.left = left1;
		left.right = right1;
		
		Node left2 = new Node(6);
		Node right2 = new Node(7);
		right.left = left2;
		right.right = right2;
		
		printResult(connect3(root));
	}
	
	public static Node connect(Node root) {
        if(root == null) return null;
        
        if(root.left != null) root.left.next = root.right;
        if(root.right != null) root.right.next = root.next != null ? root.next.left : null;
        
        connect(root.left);
        connect(root.right);
        
		return root;
    }
	
	public static Node connect2(Node root) {
		if(root == null) return null;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				Node temp = queue.poll();
				if(i < size - 1) {
					temp.next = queue.peek();
				}
				
				if(temp.left != null) queue.add(temp.left);
				if(temp.right != null) queue.add(temp.right);
			}
		}
		
		return root;
	}
	
	public static Node connect3(Node root) {
		if(root == null) return null;
		
		Node start = root, current = null;
		
		while(start.left != null) {
			current = start;
			
			while(current != null) {
				current.left.next = current.right;
				
				if(current.next != null) current.right.next = current.next.left;
				
				current = current.next;
			}
			
			start = start.left;
		}
		
		return root;
	}
	
	private static void printResult(Node root) {
		if(root != null) {
			System.out.print(root.val + " ");
			
			Node temp = root.next;
			while(temp != null) {
				System.out.print(temp.val + " ");
				temp = temp.next;
			}
			
			if(root.left != null) {
				printResult(root.left);
			}
		}
	}
	
	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

}
