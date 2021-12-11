package p0047_Permutations_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("permuteUnique: [[1,1,2],[1,2,1],[2,1,1]] --> " + permuteUnique(new int[] {1,1,2}));
		System.out.println("permuteUnique: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] --> " + permuteUnique(new int[] {1,2,3}));
		System.out.println("permuteUnique: [[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]] --> " + permuteUnique(new int[] {2,2,1,1}));
	}
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		
		for(int i = 0; i < nums.length; i++) {
			List<List<Integer>> current = new ArrayList<>();
			
			for(List<Integer> item : result) {
				for(int j = 0; j <= i; j++) {
					if(j > 0 && nums[i] == item.get(j - 1)) break;
					
					List<Integer> temp = new ArrayList<>(item);
					temp.add(j, nums[i]);
					current.add(temp);
				}
			}
			
			result = current;
		}
		
		return result;
	}

}
