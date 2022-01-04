package p0078_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]] --> " + subsets2(new int[] {1,2,3}));
		System.out.println("[[],[0]] --> " + subsets2(new int[] {0}));
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		
		helper(nums, 0, new ArrayList<>(), result);
		
		return result;
    }
	
	private static void helper(int[] nums, int level, List<Integer> current, List<List<Integer>> result) {
		result.add(new ArrayList<>(current));
		
		for(int i = level; i < nums.length; i++) {
			current.add(nums[i]);
			helper(nums, i + 1, current, result);
			current.remove(current.size() - 1);
		}
	}
	
	public static List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		
		for(int i = 0; i < nums.length; i++) {
			int size = result.size();
			
			for(int j = 0; j < size; j++) {
				result.add(new ArrayList<>(result.get(j)));
				result.get(result.size() - 1).add(nums[i]);
			}
		}
		
		return result;
	}

}
