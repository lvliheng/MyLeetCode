package p0140_Word_Break_II;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		List<String> output = new ArrayList<>();
		output.add("cat sand dog");
		output.add("cats and dog");
		
		String s = "catsanddog";
		
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		assertEquals(output, Solution.wordBreak(s, wordDict));
	}

}
