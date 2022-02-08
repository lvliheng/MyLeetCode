package p0011_Container_With_Most_Water;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("49 --> " + maxArea2(new int[] {1,8,6,2,5,4,8,3,7}));
	}
	
	public static int maxArea(int[] height) {
		int result = 0, i = 0, j = height.length - 1;
		
		while(i < j) {
			result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
			
			if(height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		
		return result;
	}
	
	public static int maxArea2(int[] height) {
		int result = 0, i = 0, j = height.length - 1;
		
		while(i < j) {
			int h = Math.min(height[i], height[j]);
			result = Math.max(result, h * (j - i));
			
			while(i < j && h == height[i]) i++;
			while(i < j && h == height[j]) j--;
		}
		
		return result;
	}

}
