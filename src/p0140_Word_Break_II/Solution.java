package p0140_Word_Break_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

	
	public static List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashMap<>());
    }
	
	private static List<String> helper(String s, List<String>wordDict, HashMap<String, List<String>> memory) {
		if(memory.containsKey(s)) return memory.get(s);
		
		if(s.isEmpty()) {
			List<String> result = new ArrayList<>();
			result.add("");
			return result;
		}
		
		List<String> result = new ArrayList<>();
		for(String word : wordDict) {
			if(s.startsWith(word)) {
				List<String> currentList = helper(s.substring(word.length()), wordDict, memory);
				for(String currString : currentList) {
					result.add(word + (currString.isEmpty() ? "" : " ") + currString);
				}
			}
		}
		
		memory.put(s, result);
		
		return result;
	}
}
