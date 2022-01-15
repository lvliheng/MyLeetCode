package p0090_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[[],[1],[1,2],[1,2,2],[2],[2,2]] --> " + subsetsWithDup2(new int[] {1,2,2}));
	}
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		if(nums.length == 0) return new ArrayList<>();
		
		Arrays.sort(nums);
		
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        int pre = nums[0], lastSize = 1;
        
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] != pre) {
        		pre = nums[i];
        		lastSize = result.size();
        	}
        	
        	int size = result.size();
        	
        	for(int j = size - lastSize; j < size; j++) {
        		result.add(new ArrayList<>(result.get(j)));
        		result.get(result.size() - 1).add(nums[i]);
        	}
        }
        
        return result;
    }
	
	public static List<List<Integer>> subsetsWithDup2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		
		Arrays.sort(nums);
		
		result = getSubsets(nums, 0, new ArrayList<>(), result);
		
		return result;
	}
	
	private static List<List<Integer>> getSubsets(int[] nums, int pos, List<Integer> curr, List<List<Integer>> result) {
		result.add(new ArrayList<>(curr));
		
		for(int i = pos; i < nums.length; i++) {
			curr.add(nums[i]);
			result = getSubsets(nums, i + 1, curr, result);
			curr.remove(curr.size() - 1);
			
			while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
		}
		
		return result;
	}

}
