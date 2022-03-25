package p0133_Clone_Graph;

import org.junit.Assert;
import org.junit.Test;

import p0133_Clone_Graph.Solution.Node;

public class SolutionTest {

	@Test
	public void test() {
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
		
		Assert.assertNotEquals(node1, Solution.cloneGraph(node1));
	}

}
