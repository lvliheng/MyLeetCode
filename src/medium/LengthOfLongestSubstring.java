package medium;

import java.util.HashSet;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		
		System.out.println("0: " + lengthOfLongestSubstring(""));
		System.out.println("3: " + lengthOfLongestSubstring("abcabcbb"));
		System.out.println("1: " + lengthOfLongestSubstring("bbbbb"));
		System.out.println("3: " + lengthOfLongestSubstring("pwwkew"));

	}
	
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		int left = 0, right = 0;
		
		HashSet<Character> result = new HashSet<>();
		
		while(right < s.length()) {
			if(!result.contains(s.charAt(right))) {
				result.add(s.charAt(right++));
				max = Math.max(max, result.size());
			} else {
				result.remove(s.charAt(left++));
			}
		}
		
		return max;
	}

}
