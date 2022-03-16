package p0125_Valid_Palindrome;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("true --> " + isPalindrome2("A man, a plan, a canal: Panama"));
		System.out.println("false --> " + isPalindrome2("race a car"));
	}
	
	public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while(left < right) {
        	if(!isAlphaNum(s.charAt(left))) {
        		left++;
        	} else if(!isAlphaNum(s.charAt(right))) {
        		right--;
        	} else if((s.charAt(left) + 32 - 'a') % 32 != (s.charAt(right) + 32 - 'a') % 32){
        		return false;
        	} else {
        		left++;
        		right--;
        	}
        }
		
		return true;
    }
	
	private static boolean isAlphaNum(char ch) {
		if(ch >= 'a' && ch <= 'z') return true;
		if(ch >= 'A' && ch <= 'Z') return true;
		if(ch >= '0' && ch <= '9') return true;
		
		return false;
	}
	
	public static boolean isPalindrome2(String s) {
		int left = 0, right = s.length() - 1;
		
		while(left < right) {
			if(!Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			} else if(!Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			} else if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
				return false;
			} else {
				left++;
				right--;
			}
		}
		
		return true;
	}

}
