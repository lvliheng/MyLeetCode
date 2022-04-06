package p0145_Binary_Tree_Postorder_Traversal;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import p0145_Binary_Tree_Postorder_Traversal.Solution.TreeNode;


public class SolutionTest {

	@Test
	public void test() {
		assertEquals(getResult(), Solution.postorderTraversal(getRoot()));
	}
	
	@Test
	public void test2() {
		assertEquals(getResult(), Solution.postorderTraversal2(getRoot()));
	}
	
	private TreeNode getRoot() {
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		root.left = null;
		root.right = right;
		
		TreeNode left1 = new TreeNode(3);
		right.left = left1;
		
		return root;
	}
	
	private List<Integer> getResult() {
		List<Integer> result = new ArrayList<>();
		result.add(3);
		result.add(2);
		result.add(1);
		
		return result;
	}

}
