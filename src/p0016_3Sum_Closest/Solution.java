package p0016_3Sum_Closest;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("2 --> " + threeSumClosest2(new int[] {-1, 2, 1, -4}, 1));
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		
		int sum = nums[0] + nums[1] + nums[2];
		if(sum == target) return sum;
		
		for(int i = 0; i < nums.length; i++) {
			int left = i + 1, right = nums.length - 1;
			
			while(left < right) {
				int curr = nums[i] + nums[left] + nums[right];
				if(curr == target) return curr;
				
				if(Math.abs(curr - target) < Math.abs(sum - target)) {
					sum = curr;
				}
				
				if(curr < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		
		return sum;
	}
	
	public static int threeSumClosest2(int[] nums, int target) {
		int closest = nums[0] + nums[1] + nums[2];
		int diff = Math.abs(closest - target);
		
		Arrays.sort(nums);
		
		for(int i =0; i < nums.length - 2; i ++) {
			if(nums[i] * 3 > target) return Math.min(closest,  nums[i] + nums[i + 1] + nums[i + 2]);
			
			int left = i + 1, right = nums.length - 1;
			
			while(left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				int newDiff = Math.abs(sum - target);
				
				if(diff > newDiff) {
					diff = newDiff;
					closest = sum;
				}
				
				if(sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		
		return closest;
		
	}

}
