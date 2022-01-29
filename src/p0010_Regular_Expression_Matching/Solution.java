package p0010_Regular_Expression_Matching;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("false --> " + isMatch3("aa", "a"));
		System.out.println("true --> " + isMatch3("ab", ".*.."));
	}
	
	public static boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        
        if(p.length() == 1) {
        	return (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        }
        
        if(p.charAt(1) != '*') {
        	if(s.isEmpty()) return false;
        	return (s.charAt(0) == p.charAt(0) || p.charAt(0) =='.') && isMatch(s.substring(1), p.substring(1));
        }
        
        while(!s.isEmpty() && ( s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
        	if(isMatch(s, p.substring(2))) return true;
        	s = s.substring(1);
        }
		
		return isMatch(s, p.substring(2));
    }
	
	public static boolean isMatch2(String s, String p) {
		if(p.isEmpty()) return s.isEmpty();
		
		if(p.length() > 1 && p.charAt(1) == '*') {
			return isMatch(s, p.substring(2)) || (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p));
		} else {
			return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
		}
	}
	
	public static boolean isMatch3(String s, String p) {
		int m = s.length(), n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		
		for(int i = 1; i <= m; i++) {
			dp[i][0] = false;
		}
		
		for(int j = 1; j <= n; j++) {
			dp[0][j] = j > 1 && p.charAt(j - 1) == '*' && dp[0][j - 2];
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 2] || ((p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.');
				}
			}
		}
		
		return dp[m][n];
	}

}
