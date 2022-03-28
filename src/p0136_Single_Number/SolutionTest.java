package p0136_Single_Number;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		assertEquals(1, Solution.singleNumber(new int[] {2,2,1}));
	}
	
	@Test
	public void test2() {
		assertEquals(4, Solution.singleNumber2(new int[] {4,1,2,1,2}));
	}

}
