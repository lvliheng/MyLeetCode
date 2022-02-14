package p0076_Minimum_Window_Substring;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("BANC --> " + minWindow2("ADOBECODEBANC", "ABC"));
	}
	
	public static String minWindow(String s, String t) {
		int[] memory = new int[128];
		
		for(char letter : t.toCharArray()) {
			memory[letter]++;
		}
		
		int count = t.length();
		int minLength = Integer.MAX_VALUE;
		int minStart = 0;
		int start = 0;
		int i = 0;
		
		while(i < s.length()) {
			char letter = s.charAt(i);
			if(memory[letter] > 0) {
				count--;
			}
			
			memory[letter]--;
			i++;
			
			while(count == 0) {
				if(i - start < minLength) {
					minStart = start;
					minLength = i - start;
				}
				
				memory[s.charAt(start)]++;
				
				if(memory[s.charAt(start)] > 0){
					count++;
				}
				
				start++;
			}
		}
		
		return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
	
	public static String minWindow2(String s, String t) {
		int[] letterCnt = new int[128];
		int left = 0, cnt = 0, minLeft = -1, minLen = Integer.MAX_VALUE;
		
		for(char c : t.toCharArray()) letterCnt[c]++;
		for(int i = 0; i < s.length(); i++) {
			if(--letterCnt[s.charAt(i)] >= 0) cnt++;
			
			while(cnt == t.length()) {
				if(minLen > i - left + 1) {
					minLen = i - left + 1;
					 minLeft = left;
				}
				
				if(++letterCnt[s.charAt(left)] > 0) cnt--;
				
				left++;
			}
		}
		
		return minLeft == -1 ? "" : s.substring(minLeft, minLeft + minLen);
	}

}
