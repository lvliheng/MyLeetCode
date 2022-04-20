package p0152_Maximum_Product_Subarray;
class Solution {
    
	
	public static int maxProduct(int[] nums) {
        int res = nums[0], mx = res, mn = res;
        
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] > 0) {
        		mx = Math.max(mx * nums[i], nums[i]);
        		mn = Math.min(mn * nums[i], nums[i]);
        	} else {
        		int t = mx;
        		mx = Math.max(mn * nums[i], nums[i]);
        		mn = Math.min(t * nums[i], nums[i]);
        	}
        	
        	res = Math.max(res, mx);
        }
        
        return res;
    }
}