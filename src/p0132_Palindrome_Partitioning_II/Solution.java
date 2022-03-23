package p0132_Palindrome_Partitioning_II;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("1 --> " + minCut2("aab"));
	}
	
	public static int minCut(String s) {
        if(s.isEmpty()) return 0;
        
        int n = s.length();
        boolean[][] p = new boolean[n][n];
        int[] dp = new int[n];
        
        for(int i = 0; i < n; i++) {
        	dp[i] = i;
        	for(int j = 0; j <= i; j++) {
        		if(s.charAt(i) == s.charAt(j) && (i - j < 2 || p[j + 1][i - 1])) {
        			p[j][i] = true;
        			dp[i] = (j == 0) ? 0 : Math.min(dp[i], dp[j - 1] + 1);
        		}
        	}
        }
		
		return dp[n - 1];
    }
	
	public static int minCut2(String s) {
		if(s.isEmpty()) return 0;
		
		int n = s.length();
		boolean[][] p = new boolean[n][n];
		int[] dp = new int[n];
		
		for(int i = n - 1; i >= 0; i--) {
			dp[i] = n - i - 1;
			for(int j = i; j < n; j++) {
				if(s.charAt(i) == s.charAt(j) && (j - i <= 1 || p[i + 1][j - 1])) {
					p[i][j] = true;
					dp[i] = (j == n - 1) ? 0 : Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}
		
		return dp[0];
	}

}
