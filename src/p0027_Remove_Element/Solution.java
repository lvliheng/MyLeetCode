package p0027_Remove_Element;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("2 ==> " + removeElement(new int[] {3,2,2,3}, 3));
		System.out.println("5 ==> " + removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
		System.out.println("0 ==> " + removeElement(new int[] {1}, 1));
		
	}
	
	public static int removeElement(int[] nums, int val) {
		
		int left = 0, right = nums.length - 1;
		
		while(left <= right) {
			if(nums[right] == val) {
				right--;
			} else if(nums[left] != val) {
				left++;
			} else {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
			}
		}
		
		return left;
	}

}
