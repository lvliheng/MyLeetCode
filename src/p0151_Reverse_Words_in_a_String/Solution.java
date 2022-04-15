package p0151_Reverse_Words_in_a_String;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    
	
	public static String reverseWords(String s) {
        String[] sList = s.split(" +");
        Collections.reverse(Arrays.asList(sList));
        
        return String.join(" ", sList).trim();
    }
	
	public static String reverseWords2(String s) {
		String[] sList = s.trim().split("\\s+");
		
		String result = "";
		for(int i = sList.length - 1; i > 0; i--) {
			result += sList[i] + " ";
		}
		
		return result + sList[0];
		
	}
}