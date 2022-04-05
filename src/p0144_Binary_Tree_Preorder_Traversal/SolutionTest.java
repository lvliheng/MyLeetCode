package p0144_Binary_Tree_Preorder_Traversal;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import p0144_Binary_Tree_Preorder_Traversal.Solution.TreeNode;

public class SolutionTest {

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		root.left = null;
		root.right = right;
		
		TreeNode left1 = new TreeNode(3);
		right.left = left1;
		
		List<Integer> result = new ArrayList<>();
		result.add(1);
		result.add(2);
		result.add(3);
		
		assertEquals(result, Solution.preorderTraversal(root));
	}

}
