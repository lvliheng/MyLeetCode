package p0070_Climbing_Stairs;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("2 --> " + climbStairs3(2));
		System.out.println("3 --> " + climbStairs3(3));
	}
	
	public static int climbStairs(int n) {
		if(n <= 1) return 1;
		
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        
        for(int i = 2; i < n; i++) {
        	result[i] = result[i - 1] + result[i - 2];
        }
        
        return result[n - 1];
    }
	
	public static int climbStairs2(int n) {
		int a = 1, b = 1;
		
		while(n-- > 0) {
			b += a;
			a = b - a;
		}
		
		return a;
    }
	
	public static int climbStairs3(int n) {
		int[] memory = new int[n + 1];
		
		return helper(n, memory);
	}
	
	public static int helper(int n, int[] memory) {
		if(n <= 1) return 1;
		
		if(memory[n] > 0) return memory[n];
		
		return memory[n] = helper(n - 1, memory) + helper(n - 2, memory); 
	}

		
}
