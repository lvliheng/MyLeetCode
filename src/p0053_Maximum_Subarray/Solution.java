package p0053_Maximum_Subarray;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("6 --> " + maxSubArray2(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println("1 --> " + maxSubArray2(new int[] {1}));
		System.out.println("23 --> " + maxSubArray2(new int[] {5,4,-1,7,8}));
	}
	
	public static int maxSubArray(int[] nums) {
        int curr = 0, result = Integer.MIN_VALUE;
        
        for(int item : nums) {
        	curr = Math.max(curr + item, item);
        	result = Math.max(result, curr);
        }
		
		return result;
    }
	
	public static int maxSubArray2(int[] nums) {
        if(nums.length == 0) return 0;
		
		return helper(nums, 0, nums.length - 1);
    }
	
	private static int helper(int[] nums, int left, int right) {
		if(left >= right) return nums[left];
		
		int mid = left + (right - left) / 2;
		int lMax = helper(nums, left, mid - 1);
		int rMax = helper(nums, mid + 1, right);
		
		int mMax = nums[mid], t = mMax;
		for(int i = mid - 1; i >= left; i--) {
			t += nums[i];
			mMax = Math.max(mMax, t);
		}
		
		t = mMax;
		for(int j = mid + 1; j <= right; j++) {
			t += nums[j];
			mMax = Math.max(mMax, t);
		}
		
		return Math.max(mMax, Math.max(lMax, rMax));
	}

}
