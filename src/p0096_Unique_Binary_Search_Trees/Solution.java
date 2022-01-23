package p0096_Unique_Binary_Search_Trees;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("5 --> " + numTrees2(3));
	}
	
	public static int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
        
		return dp[n];
    }
	
	public static int numTrees2(int n) {
		long result = 1;
		
		for(int i = n + 1; i <= n * 2; i++) {
			result = result * i / (i - n);
		}
        
		return (int) (result / (n + 1));
    }

}
