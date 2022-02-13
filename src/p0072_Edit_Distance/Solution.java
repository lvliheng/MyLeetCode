package p0072_Edit_Distance;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("3 --> " + minDistance2("horse", "ros"));
	}
	
	public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] memo = new int[m][n];
        
		return helper(word1, 0, word2, 0, memo);
    }
	
	private static int helper(String word1, int i, String word2, int j, int[][] memo) {
		if(i == word1.length()) return word2.length() - j;
		if(j == word2.length()) return word1.length() - i;
		if(memo[i][j] > 0) return memo[i][j];
		
		int result = 0;
		
		if(word1.charAt(i) == word2.charAt(j)) {
			return helper(word1, i + 1, word2, j+ 1, memo);
		} else {
			int insertCnt = helper(word1, i, word2, j + 1, memo);
			int deleteCnt = helper(word1, i + 1, word2, j, memo);
			int replaceCnt = helper(word1, i + 1, word2, j + 1, memo);
			result = Math.min(insertCnt, Math.min(deleteCnt, replaceCnt)) + 1;
		}
		
		return memo[i][j] = result;
	}
	
	public static int minDistance2(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		int[][] dp = new int[m + 1][n + 1];
		
		for(int i = 0; i <= m; i++) dp[i][0] = i;
		for(int i = 0; i <= n; i++) dp[0][i] = i;
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
			}
		}
		
		return dp[m][n];
	}

}
