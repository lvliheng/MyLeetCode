package p0039_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("combinationSum: [[2,2,3],[7]] --> " + combinationSum(new int[] {2,3,6,7}, 7));
		System.out.println("combinationSum: [[2,2,2,2],[2,3,3],[3,5]] --> " + combinationSum(new int[] {2,3,5}, 8));
		System.out.println("combinationSum: [] --> " + combinationSum(new int[] {2}, 1));
		System.out.println("combinationSum: [[1]] --> " + combinationSum(new int[] {1}, 1));
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		List<List<Integer>> result = new ArrayList<>();
		
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
			curr.add(candidates[i]);
			combination(candidates, target - candidates[i], i, curr, result);
			curr.remove(curr.size() - 1);
		}
	}

}
