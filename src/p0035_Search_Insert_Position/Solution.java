package p0035_Search_Insert_Position;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("2 --> " + searchInsert2(new int[] {1,3,5,6}, 5));
		System.out.println("1 --> " + searchInsert2(new int[] {1,3,5,6}, 2));
		System.out.println("4 --> " + searchInsert2(new int[] {1,3,5,6}, 7));
	}
	
	public static int searchInsert(int[] nums, int target) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] >= target) {
				return i;
			}
		}
		
		return nums.length;
	}
	
	public static int searchInsert2(int[] nums, int target) {
		if(nums[nums.length - 1] < target) return nums.length;
		
		int left = 0, right = nums.length;
		
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] < target) left = mid + 1;
			else right = mid;
		}
		
		return right;
	}

}
