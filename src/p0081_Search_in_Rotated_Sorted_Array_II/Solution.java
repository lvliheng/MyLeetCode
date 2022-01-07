package p0081_Search_in_Rotated_Sorted_Array_II;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("true --> " + search(new int[] {2,5,6,0,0,1,2}, 0));
		System.out.println("false --> " + search(new int[] {2,5,6,0,0,1,2}, 3));
		System.out.println("true --> " + search(new int[] {1}, 1));
	}
	
	public static boolean search(int[] nums, int target) {
        int n = nums.length, left = 0, right = n - 1;
        
        while(left <= right) {
        	int mid = (left + right) / 2;
        	if(nums[mid] == target) return true;
        	
        	if(nums[mid] < nums[right]) {
        		if(nums[mid] < target && nums[right] >= target) {
        			left = mid + 1;
        		} else {
        			right = mid - 1;
        		}
        	} else if (nums[mid] > nums[right]){
        		if(nums[left] <= target && nums[mid] > target) {
        			right = mid - 1;
        		} else {
        			left = mid + 1;
        		}
        	} else {
        		right--;
        	}
        }
        
		return false;
    }

}
