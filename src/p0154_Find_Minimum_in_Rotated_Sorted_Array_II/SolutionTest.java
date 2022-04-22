package p0154_Find_Minimum_in_Rotated_Sorted_Array_II;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		assertEquals(1, Solution.findMin(new int[] {1,3,5}));
	}
	
	@Test
	public void test2() {
		assertEquals(1, Solution.findMin2(new int[] {1,3,5}));
	}

}
