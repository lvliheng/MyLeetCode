package p0151_Reverse_Words_in_a_String;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		assertEquals("blue is sky the", Solution.reverseWords("the sky is blue"));
	}
	
	@Test
	public void test2() {
		assertEquals("blue is sky the", Solution.reverseWords2("the sky is blue"));
	}

}
