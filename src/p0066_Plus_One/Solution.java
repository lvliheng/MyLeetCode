package p0066_Plus_One;

public class Solution {

	public static void main(String[] args) {
		
		System.out.print("[1,2,4] --> ");
		
		for(int item : plusOne(new int[] {1,2,3})) {
			System.out.print(item);
		}
		
		System.out.println();
		
		System.out.print("[4,3,2,2] --> ");
		
		for(int item : plusOne(new int[] {4,3,2,1})) {
			System.out.print(item);
		}
		
		System.out.println();
		
		System.out.print("[1,0] --> ");
		
		for(int item : plusOne(new int[] {9})) {
			System.out.print(item);
		}
		
		System.out.println();
		
		System.out.print("[9,8,7,6,5,4,3,2,1,1] --> ");
		
		for(int item : plusOne(new int[] {9,8,7,6,5,4,3,2,1,0})) {
			System.out.print(item);
		}
	}
	
	public static int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
        	if(digits[i] < 9) {
        		digits[i]++;
        		return digits;
        	}
        	digits[i] = 0;
        }
		
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

}
