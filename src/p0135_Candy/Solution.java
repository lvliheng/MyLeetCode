package p0135_Candy;

public class Solution {

	
	public static int candy(int[] ratings) {
        int result = 0, n = ratings.length;
        
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
        	nums[i] = 1;
        }
        
        for(int i = 0; i < n - 1; i++) {
        	if(ratings[i + 1] > ratings[i]) {
        		nums[i + 1] = nums[i] + 1;
        	}
        }
        
        for(int i = n - 1; i > 0; i--) {
        	if(ratings[i - 1] > ratings[i]) {
        		nums[i - 1] = Math.max(nums[i - 1], nums[i] + 1);
        	}
        }
        
        for(int num : nums) {
        	result += num;
        }
		
		return result;
    }
}
