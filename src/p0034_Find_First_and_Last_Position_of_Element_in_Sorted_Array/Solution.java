package p0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("searchRange: [3, 4] --> " + Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 8)));
		System.out.println("searchRange: [-1, -1] --> " + Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 6)));
		System.out.println("searchRange: [-1, -1] --> " + Arrays.toString(searchRange(new int[] {}, 0)));
		System.out.println("searchRange: [0, 0] --> " + Arrays.toString(searchRange(new int[] {1}, 1)));
		System.out.println("searchRange: [0, 2] --> " + Arrays.toString(searchRange(new int[] {3,3,3}, 3)));
		System.out.println("searchRange: [0, 0] --> " + Arrays.toString(searchRange(new int[] {1,3}, 1)));
	}
	
	public static int[] searchRange(int[] nums, int target) {
		
		int start = getTargetIndex(nums, target);
		
		if(start == nums.length || nums[start] != target) {
			return new int[] {-1, -1};
		}
		
		return new int[] {start, getTargetIndex(nums, target + 1) - 1};
	}
	
	private static int getTargetIndex(int[] nums, int target) {
		int left = 0, right = nums.length;
		
		while(left < right) {
			int mid = left + (right - left) / 2;
			
			if(nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		return right;
	}

}
