package p0031_Next_Permutation;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		
		System.out.print("[1, 3, 2] --> ");
		nextPermutation(new int[] {1, 2, 3});
		System.out.print("[1, 2, 3] --> ");
		nextPermutation(new int[] {3, 2, 1});
		System.out.print("[1, 5, 1] --> ");
		nextPermutation(new int[] {1, 1, 5});
		System.out.print("[1] --> ");
		nextPermutation(new int[] {1});
		System.out.print("[5, 1, 1] --> ");
		nextPermutation(new int[] {1, 5, 1});
	}
	
	public static void nextPermutation(int[] nums) {
		int j;
		
		for(int i = nums.length - 2; i >= 0; i--) {
			
			if(nums[i + 1] > nums[i]) {
				
				for(j = nums.length - 1; j > i; j--) {
					if(nums[j] > nums[i]) {
						break;
					}
				}
				
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				
				Arrays.sort(nums, i + 1, nums.length);
				System.out.println(Arrays.toString(nums));
				
				return;
			}
		}
		
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
	}

}
