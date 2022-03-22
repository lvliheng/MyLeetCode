package p0131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[[\"a\",\"a\",\"b\"],[\"aa\",\"b\"]] --> ");
		
		List<List<String>> result = partition("aab");
		
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
}
