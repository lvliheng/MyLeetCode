package p0138_Copy_List_with_Random_Pointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	
	public static Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Map<Node, Node> memory = new HashMap<>();
        Node newHead = new Node(head.val);
        Node current = head;
        Node newCurrent = newHead;
        memory.put(current, newCurrent);
        
        while(current.next != null) {
        	newCurrent.next = new Node(current.next.val);
        	memory.put(current.next, newCurrent.next);
        	newCurrent = newCurrent.next;
        	current = current.next;
        }
        
        current = head;
        newCurrent = newHead;
        
        while(current != null) {
        	if(current.random != null) {
        		newCurrent.random = memory.get(current.random);
        	}
        	
        	newCurrent = newCurrent.next;
        	current = current.next;
        }
        
        return newHead;
    }
	
	public static Node copyRandomList2(Node head) {
		return helper(head, new HashMap<>());
	}
	
	private static Node helper(Node head, HashMap<Node, Node> memory) {
		if(head == null) return null;
		
		if(memory.containsKey(head)) return memory.get(head);
		
		Node result = new Node(head.val);
		memory.put(head, result);
		result.next = helper(head.next, memory);
		result.random = helper(head.random, memory);
		
		return result;
	}
	
	public static Node copyRandomList3(Node head) {
		if(head == null) return null;
		
		Node current = head;
		while(current != null) {
			Node temp = new Node(current.val);
			temp.next = current.next;
			current.next = temp;
			current = temp.next;
		}
		
		current = head;
		while(current != null) {
			if(current.random != null) current.next.random = current.random.next;
			current = current.next.next;
		}
		
		current = head;
		Node result = head.next;
		while(current != null) {
			Node temp = current.next;
			current.next = temp.next;
			if(temp.next != null) temp.next = temp.next.next;
			current = current.next;
		}
		
		return result;
	}

	static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}
