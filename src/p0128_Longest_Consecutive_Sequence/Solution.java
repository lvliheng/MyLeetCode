package p0128_Longest_Consecutive_Sequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	
	public static void main(String[] args) {
		
		System.out.println("4 --> " + longestConsecutive3(new int[] {100,4,200,1,3,2}));
		System.out.println("9 --> " + longestConsecutive3(new int[] {0,3,7,2,5,8,4,6,0,1}));
	}
	
	public static int longestConsecutive(int[] nums) {
		if(nums.length == 0) return 0;
		
        Arrays.sort(nums);
        
        int current = 1;
        int result = 1;
        
        for (int i = 1; i < nums.length; i++) {
        	if(nums[i] == nums[i - 1]) {
        		continue;
        	} else if(nums[i] - nums[i - 1] ==  1) {
				current++;
			} else {
				result = Math.max(result, current);
				current = 1;
			}
		}
        
		return Math.max(result, current);
    }
	
	public static int longestConsecutive2(int[] nums) {
		int result = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int num : nums) {
			if(map.containsKey(num)) continue;
			
			int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
			int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
			int sum = left + right + 1;
			
			map.put(num, sum);
			result = Math.max(result, sum);
			
			map.put(num - left, sum);
			map.put(num + right, sum);
		}
		
		return result;
	}
	
	public static int longestConsecutive3(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int num : nums) {
			set.add(num);
		}
		
		int result = 0;
		
		for (int num : nums) {
			if(set.contains(num)) {
				int current = num;
				int count = 1;
				
				while(set.contains(current - 1)) {
					set.remove(current - 1);
					current--;
					count++;
				}
				
				current = num;
				
				while(set.contains(current + 1)) {
					set.remove(current + 1);
					current++;
					count++;
				}
				
				result = Math.max(result, count);
			}
		}
		
		return result;
	}
}
