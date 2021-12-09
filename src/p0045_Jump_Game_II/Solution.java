package p0045_Jump_Game_II;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("jump: 2 --> " + jump(new int[] {2,3,1,1,4}));
		System.out.println("jump: 2 --> " + jump(new int[] {2,3,0,1,4}));
		System.out.println("jump: 0 --> " + jump(new int[] {0}));
	}
	
	public static int jump(int[] nums) {
		int result = 0;
		int curr = 0;
		int next = 0;
		
		for(int i = 0; i < nums.length - 1; i++) {
			curr = Math.max(curr, i + nums[i]);
			
			if(i == next) {
				next = curr;
				result++;
				
				if(next >= nums.length - 1) break;
			}
		}
		
		return result;
	}

}
