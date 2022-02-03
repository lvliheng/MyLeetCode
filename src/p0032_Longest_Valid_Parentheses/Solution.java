package p0032_Longest_Valid_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("2 --> " + longestValidParentheses3("(()"));
	}
	
	public static int longestValidParentheses(String s) {
        int result = 0, start = 0, n = s.length();
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
        	if(s.charAt(i) == '(') {
        		list.add(i);
        	} else if(s.charAt(i) == ')') {
        		if(list.isEmpty()) {
        			start = i + 1;
        		} else {
        			list.remove(list.size() - 1);
        			result = list.isEmpty() ? Math.max(result, i - start + 1) : Math.max(result, i - list.get(list.size() - 1));
        		}
        	}
        }
        
        return result;
    }
	
	public static int longestValidParentheses2(String s) {
		int result = 0, n = s.length();
		
		int[] dp = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			int j = i - 2 - dp[i - 1];
			if(s.charAt(i - 1) == '(' || j < 0 || s.charAt(j) == ')') {
				dp[i] = 0;
			} else {
				dp[i] = dp[i - 1] + 2 + dp[j];
				result = Math.max(result, dp[i]);
			}
		}
		
		return result;
	}
	
	public static int longestValidParentheses3(String s) {
		int result = 0, left = 0, right = 0, n = s.length();
		
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if(left == right) {
				result = Math.max(result, 2 * right);		
			} else if(right > left) {
				left = right = 0;
			}
		}
		
		left = right = 0;
		
		for(int i = n - 1; i >= 0; i--) {
			if(s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if(left == right) {
				result = Math.max(result, 2 * left);
			} else if(left > right) {
				left = right = 0;
			}
		}
		
		return result;
	}

}
