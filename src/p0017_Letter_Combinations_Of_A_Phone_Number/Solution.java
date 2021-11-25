package p0017_Letter_Combinations_Of_A_Phone_Number;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		System.out.println("[ad, bd, cd, ae, be, ce, af, bf, cf]");
		System.out.println(" || ");
		System.out.println(letterCombinations("23"));
		System.out.println();
		
		System.out.println("letterCombinations: [] --> " + letterCombinations(""));
		System.out.println();
		
		System.out.println("letterCombinations: [\"a\",\"b\",\"c\"] --> " + letterCombinations("2"));
		System.out.println();
		
		System.out.println("[adg, bdg, cdg, aeg, beg, ceg, afg, bfg, cfg, adh, bdh, cdh, aeh, beh, ceh, afh, bfh, cfh, adi, bdi, cdi, aei, bei, cei, afi, bfi, cfi]");
		System.out.println(" || ");
		System.out.println(letterCombinations("234"));
	}
	
	public static List<String> letterCombinations(String digits) {
		
		if(digits.isEmpty()) {
			return new ArrayList<>();
		}
		
		List<String> result = new ArrayList<>();
		result.add("");
		
		String[] pattern = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		for(int i = 0; i < digits.length(); i++) {
			List<String> temp = new ArrayList<>();
			String str = pattern[digits.charAt(i) - '0'];
			
			for(int j = 0; j < str.length(); j++) {
				
				for(String item : result) {
					temp.add(item + str.charAt(j));
				}
				
			}
			
			result = temp;
		}
		
		return result;
	}

}
