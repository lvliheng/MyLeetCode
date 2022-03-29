package p0137_Single_Number_II;

public class Solution {

	
	public static int singleNumber(int[] nums) {
        int result = 0;
        
        for(int i = 0; i < 32; i++) {
        	int sum = 0;
        	
        	for(int j = 0; j < nums.length; j++) {
        		sum += (nums[j] >> i) & 1;
        	}
        	
        	result |= (sum % 3) << i;
        }
        
        return result;
    }
	
	public static int singleNumber2(int[] nums) {
		int one = 0, two = 0, three = 0;
		
		for(int i = 0; i < nums.length; i++) {
			two |= one & nums[i];
			one ^= nums[i];
			three = one & two;
			one &= ~three;
			two &= ~three;
		}
		
		return one;
	}
	
	public static int singleNumber3(int[] nums) {
		int a = 0, b = 0;
		
		for(int i = 0; i < nums.length; i++) {
			b = (b ^ nums[i]) & ~a;
			a = (a ^ nums[i]) & ~b;
		}
		
		return b;
	}
}
