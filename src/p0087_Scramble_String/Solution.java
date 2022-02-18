package p0087_Scramble_String;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("true --> " + isScramble("great", "rgeat"));
		System.out.println("false --> " + isScramble("eebaacbcbcadaaedceaaacadccd", "eadcaacabaddaceacbceaabeccd"));
	}
	
	public static boolean isScramble(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		if(s1.equals(s2)) return true;
        
        int n = s1.length();
        
        boolean[][][] dp = new boolean[n + 1][n][n];
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        
        for(int j = 0; j < n; j++) {
        	for(int k = 0; k < n; k ++) {
        		if(c1[j] == c2[k]) {
        			dp[1][j][k] = true;
        		}
        	}
        }
        
        for(int i = 2; i <= n; i++) {
        	for(int j = 0; j <= n - i; j++) {
        		for(int k = 0; k <= n - i; k++) {
        			for(int b = 1; b < i && !dp[i][j][k]; b++) {
        				dp[i][j][k] = (dp[b][j][k] && dp[i - b][j + b][k + b]) || (dp[b][j][k + i - b] && dp[i - b][j + b][k]);
        			}
        		}
        	}
        }
		
		return dp[n][0][0];
    }

}
