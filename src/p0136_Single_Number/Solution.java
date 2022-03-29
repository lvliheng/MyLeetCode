package p0136_Single_Number;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	
	public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) {
        	if(!set.add(num)) set.remove(num);
        }
		
		return set.iterator().next();
    }
	
	public static int singleNumber2(int[] nums) {
		int result = 0;
		
		for(int num : nums) {
			result ^= num;
		}
		
		return result;
	}
}
