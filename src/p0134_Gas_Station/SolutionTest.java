package p0134_Gas_Station;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Assert.assertEquals(3, Solution.canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(3, Solution.canCompleteCircuit2(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
	}

}
