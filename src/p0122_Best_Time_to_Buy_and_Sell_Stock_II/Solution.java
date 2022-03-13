package p0122_Best_Time_to_Buy_and_Sell_Stock_II;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("7 --> " + maxProfit(new int[] {7,1,5,3,6,4}));
		System.out.println("4 --> " + maxProfit(new int[] {1,2,3,4,5}));
		System.out.println("20 --> " + maxProfit(new int[] {5,2,3,2,6,6,2,9,1,0,7,4,5,0}));
	}
	
	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		
		for(int i = 0; i < prices.length - 1; i++) {
			if(prices[i + 1] > prices[i]) {
				maxProfit += prices[i + 1] - prices[i];
			}
		}
		
		return maxProfit;
	}

}
