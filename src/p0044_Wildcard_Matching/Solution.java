package p0044_Wildcard_Matching;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("false --> " + isMatch2("aa", "a"));
		System.out.println("false --> " + isMatch2("mississippi", "m??*ss*?i*pi"));
	}
	
    public static boolean isMatch(String s, String p) {
        int i = 0, j = 0, iStar = -1, jStar = -1, m = s.length(), n = p.length();
        
        while(i < m) {
        	if(j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
        		i++;
        		j++;
        	} else if(j < n && p.charAt(j) == '*') {
        		iStar = i;
        		jStar = j++;
        	} else if(iStar >= 0) {
        		i = ++iStar;
        		j = jStar + 1;
        	} else {
        		return false;
        	}
        }
        
        while(j < n && p.charAt(j) == '*') j++;
    	
    	return j == n;
    }
    
    public static boolean isMatch2(String s, String p) {
    	int m = s.length(), n = p.length();
    	
    	boolean[][] dp = new boolean[m + 1][n + 1];
    	dp[0][0] = true;
    	
    	for(int i = 1; i <= n; i++) {
    		if(p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 1];
    	}
    	
    	for(int i = 1; i <= m; i++) {
    		for(int j = 1; j <= n; j++) {
    			if(p.charAt(j - 1) == '*') {
    				dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
    			} else {
    				dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') && dp[i - 1][j - 1];
    						
    			}
    		}
    	}
    	
    	return dp[m][n];
    }

    
}
