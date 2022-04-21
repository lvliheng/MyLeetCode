package p0153_Find_Minimum_in_Rotated_Sorted_Array;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		assertEquals(1, Solution.findMin(new int[] {3,4,5,1,2}));
	}
	
	@Test
	public void test2() {
		assertEquals(1, Solution.findMin2(new int[] {3,4,5,1,2}));
	}

}
