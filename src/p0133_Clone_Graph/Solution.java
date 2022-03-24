package p0133_Clone_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[[2,4],[1,3],[2,4],[1,3]] -->");
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		
		node1.neighbors.add(node2);
		node1.neighbors.add(node4);
		
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		
		node3.neighbors.add(node2);
		node3.neighbors.add(node4);
		
		node4.neighbors.add(node1);
		node4.neighbors.add(node3);
		
		printResult(cloneGraph(node1));
	}
	
	public static Node cloneGraph(Node node) {
        return clone(node, new HashMap<>());
    }
	
	private static Node clone(Node node, Map<Node, Node> memory) {
		if(node == null) return null;
		
		if(memory.containsKey(node)) return memory.get(node);
		
		Node clone = new Node(node.val);
		memory.put(node, clone);
		for(Node neighbor : node.neighbors) {
			clone.neighbors.add(clone(neighbor, memory));
		}
		
		return clone;
	}
	
	private static void printResult(Node node) {
		if(node != null) {
			Node next = null;
			for(Node neighbor : node.neighbors) {
				System.out.print(neighbor.val + " ");
				
				if(neighbor.val - node.val == 1) {
					next = neighbor;
				}
			}
			
			System.out.println();
			
			printResult(next);
		}
		
		
	}
	
	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

}
