package p0009_Palindrome_Number;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("isPalindrome: " + isPalindrome(12121));
	}

	public static boolean isPalindrome(int x) {
		if(x == 0) {
			return true;
		}
		
		if(x < 0 || x % 10 == 0) {
			return false;
		}
		
		int result = 0;
		
		while(result < x) {
			result = result * 10 + x % 10;
			x /= 10;
		}
		
		return x == result || x == result / 10;
	}
}
