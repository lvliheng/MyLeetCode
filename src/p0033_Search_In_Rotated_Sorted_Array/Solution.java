package p0033_Search_In_Rotated_Sorted_Array;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("search: 4 --> " + search(new int[] {4,5,6,7,0,1,2}, 0));
		System.out.println("search: -1 --> " + search(new int[] {4,5,6,7,0,1,2}, 3));
		System.out.println("search: -1 --> " + search(new int[] {1}, 0));
	}
	
	public static int search(int[] nums, int target) {
		
		int left = 0, right = nums.length - 1;
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			
			if(nums[mid] == target) return mid;
			
			if(nums[mid] < nums[right]) {
				if(nums[mid] < target && nums[right] >= target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if(nums[mid] > target && nums[left] <= target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		
		return -1;
	}

}
