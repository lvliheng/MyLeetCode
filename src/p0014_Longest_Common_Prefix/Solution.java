package p0014_Longest_Common_Prefix;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("longestCommonPrefix: " + 
							longestCommonPrefix(new String[] {}));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		
		if(strs.length == 0) {
			return "";
		}
		
		String firstStr = strs[0];
		int commonIndex = 0;
		
		while(true) {
			for(String str : strs) {
				if(commonIndex == str.length() || firstStr.charAt(commonIndex) != str.charAt(commonIndex)) {
					return str.substring(0, commonIndex);
				}
			}
			
			commonIndex++;
		}
	}

}
