package p0139_Word_Break;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		
		assertEquals(true, Solution.wordBreak("leetcode", wordDict));
	}

}
