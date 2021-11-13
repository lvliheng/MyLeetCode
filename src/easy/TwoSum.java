package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		
		System.out.println("twoSum: " + Arrays.toString(twoSum(new int[]{1, 2, 3}, 3)));
	}

	/**
	 * 1. Two Sum
	 * 
	 * Given an array of integers nums and an integer target, r
	 * eturn indices of the two numbers such that they add up to target.
	 *
	 *	You may assume that each input would have exactly one solution, 
	 *	and you may not use the same element twice.
	 *	
	 *	You can return the answer in any order.
	 */
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
