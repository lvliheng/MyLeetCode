package p0028_Implement_strStr;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("2 --> " + strStr("hello", "ll"));
		System.out.println("-1 --> " + strStr("aaaaa", "bba"));
		System.out.println("0 --> " + strStr("", ""));
		System.out.println("0 --> " + strStr("a", "a"));
	}
	
	public static int strStr(String haystack, String needle) {
		if(needle.isEmpty()) return 0;
		if(haystack.length() < needle.length()) return -1;
		
		for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			if(haystack.charAt(i) == needle.charAt(0)) {
				int j = 0;
				
				for(j = 0; j < needle.length(); j++) {
					if(haystack.charAt(i + j) != needle.charAt(j)) {
						break;
					}
				}
				
				if(j == needle.length()) {
					return i;
				}
			}
		}
		
		return -1;
	}

}
