package p0121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("5 --> " + maxProfit2(new int[] {7,1,5,3,6,4}));
	}
	
	public static int maxProfit(int[] prices) {
		int minValue = Integer.MAX_VALUE;
		int maxProfit = 0;
        
		for(int price : prices) {
			if(price < minValue) {
				minValue = price;
			} else {
				maxProfit = Math.max(maxProfit, price - minValue);
			}
        }
		
		return maxProfit;
    }
	
	public static int maxProfit2(int[] prices) {
		int minValue = Integer.MAX_VALUE;
		int maxProfit = 0;
        
		for(int price : prices) {
			minValue = Math.min(minValue, price);
			maxProfit = Math.max(maxProfit, price - minValue);
        }
		
		return maxProfit;
    }

}
