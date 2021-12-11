package p0046_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("permute: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] --> " + permute(new int[] {1,2,3}));
		System.out.println("permute: [[0,1],[1,0]] --> " + permute(new int[] {0,1}));
		System.out.println("permute: [[1]] --> " + permute(new int[] {1}));
	}
	
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		
		for(int i = 0; i < nums.length; i++) {
			List<List<Integer>> current = new ArrayList<>();
			
			for(int j = 0; j <= i; j++) {
				for(List<Integer> item : result) {
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
