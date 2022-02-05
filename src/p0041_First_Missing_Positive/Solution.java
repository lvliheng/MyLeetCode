package p0041_First_Missing_Positive;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("3 --> " + firstMissingPositive(new int[] {1,2,0}));
	}
	
	public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for(int i = 0; i < n; i++) {
        	while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
        		int a = i;
        		int b = nums[i] - 1;
        		int temp = nums[a];
        		nums[a] = nums[b];
        		nums[b] = temp;
        	}
        }
		
		for(int i = 0; i < n; i++) {
			if(nums[i] != i + 1) return i + 1;
		}
		
		return n + 1;
    }

}
