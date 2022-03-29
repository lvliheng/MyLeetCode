package p0137_Single_Number_II;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		assertEquals(3, Solution.singleNumber(new int[] {2,2,3,2}));
	}

	@Test
	public void test2() {
		assertEquals(3, Solution.singleNumber2(new int[] {2,2,3,2}));
	}
	
	@Test
	public void test3() {
		assertEquals(3, Solution.singleNumber3(new int[] {2,2,3,2}));
	}
}
