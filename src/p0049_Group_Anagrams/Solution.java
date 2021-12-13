package p0049_Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
			
		System.out.println("[[bat],[nat,tan],[ate,eat,tea]] --> " + groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
		System.out.println("[[]] --> " + groupAnagrams(new String[] {""}));
		System.out.println("[[a]] --> " + groupAnagrams(new String[] {"a"}));
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> current = new HashMap<>();
		
		for(String item : strs) {
			char[] letters = item.toCharArray();
			Arrays.sort(letters);
			String sortedStr = String.valueOf(letters);
			
			if(!current.containsKey(sortedStr)) {
				current.put(sortedStr, new ArrayList<>());
			}
			
			current.get(sortedStr).add(item);
		}
		
		return new ArrayList<>(current.values());
	}

}
