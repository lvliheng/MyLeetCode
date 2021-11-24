package p0001_Two_Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[0,1] ==> " + Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
		System.out.println("[1,2] ==> " + Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
		System.out.println("[0,1] ==> " + Arrays.toString(twoSum(new int[]{3, 3}, 6)));
	}
	
	private static int[] twoSum(int[] nums, int target) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				return new int[] {map.get(nums[i]), i};
			}
			
			map.put(target - nums[i], i);
		}
		
		return null;
	}

}
