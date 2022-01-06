package p0080_Remove_Duplicates_from_Sorted_Array_II;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("5 --> " + removeDuplicates2(new int[] {1,1,1,2,2,3}));
		System.out.println("7 --> " + removeDuplicates2(new int[] {0,0,1,1,1,1,2,3,3}));
		System.out.println("2 --> " + removeDuplicates2(new int[] {1,1}));
		System.out.println("2 --> " + removeDuplicates2(new int[] {1,1,1,1}));
	}
	
	public static int removeDuplicates(int[] nums) {
		int i = 0;
		
		for(int num : nums) {
			if(i < 2 || num > nums[i - 2]) {
				nums[i++] = num;
			}
		}
		
		return i;
    }
	
	public static int removeDuplicates2(int[] nums) {
		int pre = 0, index = 1, count = 1, n = nums.length;
		
		while(index < n) {
			if(nums[pre] == nums[index] && count == 0) {
				index++;
			} else {
				if(nums[pre] == nums[index]) {
					count--;
				} else {
					count = 1;
				}
				
				nums[++pre] = nums[index++];
			}
		}
		
		return nums.length == 0 ? 0 : pre + 1;
    }

}
