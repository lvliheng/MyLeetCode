package p0058_Length_of_Last_Word;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("5 --> " + lengthOfLastWord("Hello World"));
		System.out.println("4 --> " + lengthOfLastWord("   fly me   to   the moon  "));
		System.out.println("6 --> " + lengthOfLastWord("luffy is still joyboy"));
		System.out.println("1 --> " + lengthOfLastWord("a"));
	}
	
	public static int lengthOfLastWord(String s) {
        int result = 0;
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) != ' '){
				result++;
			} else if(result > 0) {
				return result;
			} else {
				continue;
			}
		}
		
		return result;
    }

}
