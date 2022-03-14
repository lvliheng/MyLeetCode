package p0123_Best_Time_to_Buy_and_Sell_Stock_III;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("6 --> " + maxProfit(new int[] {3,3,5,0,0,3,1,4}));
	}
	
	public static int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        
        int[][] dp = new int[3][prices.length];
        for(int time = 1; time < 3; time++) {
        	int current = dp[time - 1][0] - prices[0];
        	
        	for(int i = 1; i < prices.length; i++) {
        		dp[time][i] = Math.max(dp[time][i - 1], prices[i] + current);
        		current = Math.max(current, dp[time - 1][i] - prices[i]);
        	}
        }
        
        int[] last = dp[dp.length - 1];
        int max = last[0];
        for(int num : last) {
        	if(max < num) {
        		max = num;
        	}
        }
		
		return max;
    }

}
