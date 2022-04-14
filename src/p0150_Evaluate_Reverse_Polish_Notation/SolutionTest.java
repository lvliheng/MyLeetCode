package p0150_Evaluate_Reverse_Polish_Notation;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		String[] tokens = new String[] {"2","1","+","3","*"};
		
		assertEquals(9, Solution.evalRPN(tokens));
	}

}
