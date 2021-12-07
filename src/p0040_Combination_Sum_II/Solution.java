package p0040_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("combinationSum2: [[1,1,6],[1,2,5],[1,7],[2,6]] --> " + combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
		System.out.println("combinationSum2: [[1,2,2],[5]] --> " + combinationSum2(new int[] {2,5,2,1,2}, 5));
	}
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		combination(candidates, target, 0, new ArrayList<>(), result);
		
		return result;
	}
	
	private static void combination(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> result) {
		if(target < 0) return;
		if(target == 0) {
			result.add(new ArrayList<>(curr));
			return;
		}
		for(int i = start; i < candidates.length; i++) {
			if(i > start && candidates[i] == candidates[i - 1]) continue;
			curr.add(candidates[i]);
			combination(candidates, target - candidates[i], i + 1, curr, result);
			curr.remove(curr.size() - 1);
		}
	}

}
