package p0154_Find_Minimum_in_Rotated_Sorted_Array_II;
class Solution {
    
	
	public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while(left < right) {
        	int mid = left + (right - left) / 2;
        	if(nums[mid] > nums[right]) {
        		left = mid + 1;
        	} else if(nums[mid] < nums[right]) {
        		right = mid;
        	} else {
        		right--;
        	}
        }
        
        return nums[right];
    }
	
	public static int findMin2(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}
	
	private static int helper(int[] nums, int start, int end) {
		if(start == end) return nums[start];
		if(nums[start] < nums[end]) return nums[start];
		int mid = (start + end) / 2;
		return Math.min(helper(nums, start, mid), helper(nums, mid + 1, end));
	}
}