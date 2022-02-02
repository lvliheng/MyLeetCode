package p0030_Substring_with_Concatenation_of_All_Words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
			
		System.out.println("[0,9] --> " + findSubstring("barfoothefoobarman", new String[] {"foo","bar"}));
	}
	
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		
        if(s.isEmpty() || words.length == 0) return result;
        
        int n = words.length, len = words[0].length();
        
		HashMap<String, Integer> wordCnt = new HashMap<>();
		
		for(String word : words) {
			if(!wordCnt.containsKey(word)) {
				wordCnt.put(word, 0);
			}
			wordCnt.put(word, wordCnt.get(word) + 1);
		}
		
		for(int i = 0; i <= s.length() - n * len; i++) {
			HashMap<String, Integer> strCnt = new HashMap<>();
			
			int j = 0;
			for(j = 0; j < n; j++) {
				String temp = s.substring(i + j * len, i + j * len + len);
				
				if(!wordCnt.containsKey(temp)) break;
				
				if(!strCnt.containsKey(temp)) {
					strCnt.put(temp, 0);
				}
				strCnt.put(temp, strCnt.get(temp) + 1);
				
				if(strCnt.get(temp) > wordCnt.get(temp)) break;
			}
			
			if(j == n) result.add(i);
		}
        
        return result;
    }

}
