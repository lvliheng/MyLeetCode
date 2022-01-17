package p0005_Longest_Palindromic_Substring;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("bab / aba --> " + longestPalindrome2("babad"));
	}
	
	public static String longestPalindrome(String s) {
		if(s.length() < 2) return s;
		
		int n = s.length(), start = 0, maxLen = 0;
		
		for(int i = 0; i < n;) {
			if(n - 1 < maxLen / 2) break;
			
			int left = i, right = i;
			
			while( right < n - 1 && s.charAt(right) == s.charAt(right + 1)) right++;
			
			i = right + 1;
			
			while(right < n - 1 && left > 0 && s.charAt(left - 1) == s.charAt(right + 1)) {
				left--;
				right++;
			}
			
			if(maxLen < right - left + 1) {
				start = left;
				maxLen = right - left + 1;
			}
		}
		
		return s.substring(start, start + maxLen);
	}
	
	public static String longestPalindrome2(String s) {
		String result = "";
		
		boolean[][] dp = new boolean[s.length()][s.length()];
		
		for(int i = s.length() - 1; i >= 0; i--) {
			for(int j = i; j < s.length(); j++) {
				dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]));
				if(dp[i][j] && j - i + 1 > result.length()) {
					result = s.substring(i, j + 1);
				}
			}
		}
		
		return result;
	}
	
}
