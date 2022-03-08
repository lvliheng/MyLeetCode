package p0117_Populating_Next_Right_Pointers_in_Each_Node_II;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[1,#,2,3,#,4,5,7,#] --> ");
		
		Node root = new Node(1);
		
		Node left = new Node(2);
		Node right = new Node(3);
		root.left = left;
		root.right = right;
		
		Node left1 = new Node(4);
		Node right1 = new Node(5);
		left.left = left1;
		left.right = right1;
		
		Node right2 = new Node(7);
		right.left = null;
		right.right = right2;
		
		printResult(connect3(root));
	}
	
	public static Node connect(Node root) {
        if(root == null) return null;
        
        Node node = root.next;
        while(node != null) {
        	if(node.left != null) {
        		node = node.left;
        		break;
        	}
        	if(node.right != null) {
        		node = node.right;
        		break;
        	}
        	
        	node = node.next;
        }
        
        if(root.right != null) root.right.next = node;
        if(root.left != null) root.left.next = root.right != null ? root.right : node;
        
        connect(root.right);
        connect(root.left);
        
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
				if(i < size - 1) temp.next = queue.peek();
				if(temp.left != null) queue.add(temp.left);
				if(temp.right != null) queue.add(temp.right);
			}
		}

		return root;
	}
	
	public static Node connect3(Node root) {
		Node dummy = new Node(0, null, null, null), current = dummy, head = root;
		
		while(root != null) {
			if(root.left != null) {
				current.next = root.left;
				current = current.next;
			}
			if(root.right != null) {
				current.next = root.right;
				current = current.next;
			}
			root = root.next;
			if(root == null) {
				current = dummy;
				root = dummy.next;
				dummy.next = null;
			}
		}
		
		return head;
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
			} else {
				printResult(root.right);
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
