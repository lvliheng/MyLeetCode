package p0149_Max_Points_on_a_Line;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		int[][] points = new int[][] {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
		assertEquals(4, Solution.maxPoints(points));
	}

}
