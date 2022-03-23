package p0131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[[\"a\",\"a\",\"b\"],[\"aa\",\"b\"]] --> ");
		
		List<List<String>> result = partition2("aab");
		
		for(List<String> list : result) {
			for(String item : list) {
				System.out.print(item + " ");
			}
			
			System.out.println();
		}
	}
	
	public static List<List<String>> partition(String s) {
		return helper(s, 0, new ArrayList<>(), new ArrayList<>());
    }
	
	private static List<List<String>> helper(String s, int start, List<String> current, List<List<String>> result){
		if(start == s.length()) {
			result.add(new ArrayList<>(current));
			return result;
		}
		
		for(int i = start; i < s.length(); i++) {
			if(!isPalindrome(s, start, i)) continue;
			current.add(s.substring(start, i + 1));
			result = helper(s, i + 1, current, result);
			current.remove(current.size() - 1);
		}
		
		return result;
	}
	
	private static boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
	
	public static List<List<String>> partition2(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
					dp[j][i] = true;
				}
			}
		}
		
		return helper2(s, 0, dp, new ArrayList<>(), new ArrayList<>());
	}
	
	private static List<List<String>> helper2(String s, int start, boolean[][] dp, List<String>current, List<List<String>> result) {
		if (start == s.length()) {
			result.add(new ArrayList<>(current));
			return result;
		}
		
		for(int i = start; i < s.length(); i++) {
			if(!dp[start][i]) continue;
			current.add(s.substring(start, i + 1));
			result = helper2(s, i + 1, dp, current, result);
			current.remove(current.size() - 1);
		}
		
		return result;
	}
}
