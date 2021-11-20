package easy;



public class RemoveDuplicates {

	public static void main(String[] args) {
		
		//-1,0,0,0,0,3,3 //-1,0,0,0,0,3,3  //0,0,1,2,3,4,4,4
		System.out.println("removeDuplicates: " + removeDuplicates(new int[] {1, 2, 3, 4}));
	}
	
	public static int removeDuplicates(int[] nums) {
		
		int k = 0;
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[k] != nums[i]) {
				if(k + 1 != i) {
					nums[k + 1] = nums[i];
				}
				
				k++;
			}
		}
		
		return nums.length == 0 ? 0 : k + 1;
	}

}
