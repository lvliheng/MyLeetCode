package p0015_3_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[[-1,-1,2],[-1,0,1]] --> " + threeSum(new int[] {-1,0,1,2,-1,-4}));
		System.out.println("[] --> " + threeSum(new int[] {}));
		System.out.println("[] --> " + threeSum(new int[] {0}));
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		
		Arrays.sort(nums);
		
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i = 0; i < nums.length - 2; i++) {
			
			if(i > 0 && nums[i] == nums[i - 1]) continue;
			
			int left = i + 1;
			int right = nums.length - 1;
			int sum = -nums[i];
			
			while(left < right) {
				if(nums[left] + nums[right] == sum) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					
					while(left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					left++;
					while(left < right && nums[right] == nums[right - 1]) {
						right--;
					}
					right--;
				} else if(nums[left] + nums[right] < sum) {
					left++;
				} else {
					right--;
				}
			}
		}
		
		return result;
	}

}
