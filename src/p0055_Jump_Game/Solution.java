package p0055_Jump_Game;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("true --> " + canJump2(new int[] {2,3,1,1,4}));
		System.out.println("false --> " + canJump2(new int[] {3,2,1,0,4}));
		System.out.println("true --> " + canJump2(new int[] {0}));
		System.out.println("false --> " + canJump2(new int[] {0,1}));
		System.out.println("true --> " + canJump2(new int[] {2,0,0}));
	}

	public static boolean canJump(int[] nums) {
		if(nums.length == 1) return true;
		
		for(int i = nums.length - 2; i >= 0; i--) {
			if(nums[i] == 0) {
				int j = i - 1;
				for(j = i - 1; j >= 0; j--) {
					if(nums[j] > i - j) {
						break;
					}
				}
				if(j == -1) return false;
			}
		}
		
		return true;
    }
	
	public static boolean canJump2(int[] nums) {
		int n = nums.length, reach = 0;
		
		for(int i = 0; i < n; i++) {
			if(i > reach || reach > n - 1) break;
			reach = Math.max(reach, i + nums[i]);
		}
		
		return reach >= n - 1;
	}

}
