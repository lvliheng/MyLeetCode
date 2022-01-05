package p0013_Roman_to_Integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("1994 --> " + romanToInt("MCMXCIV"));
	}
	
	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int result = map.get(s.charAt(s.length() - 1));
		
		for(int i = 0; i < s.length() - 1; i++) {
			if(map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
				result += map.get(s.charAt(i));
			} else {
				result -= map.get(s.charAt(i));
			}
		}
		
		return result;
	}

}
