package p0075_Sort_Colors;

public class Solution {

	public static void main(String[] args) {
		
		System.out.print("[0,0,1,1,2,2] --> ");
		sortColors(new int[] {2,0,2,1,1,0});
		System.out.println();
		System.out.print("[0,1,2] --> ");
		sortColors(new int[] {2,0,1});
		System.out.println();
	}
	
	public static void sortColors(int[] nums) {
		int red = 0, blue = nums.length - 1;
		
		for(int i = 0; i <= blue; i++) {
			if(nums[i] == 0) {
				int temp = nums[i];
				nums[i] = nums[red];
				nums[red] = temp;
				red++;
			} else if(nums[i] == 2) {
				int temp = nums[i];
				nums[i] = nums[blue];
				nums[blue] = temp;
				blue--;
				i--;
			}
		}
		
		for(int m = 0; m < nums.length; m++) {
        	System.out.print(nums[m] + " ");
        }
	}

}
