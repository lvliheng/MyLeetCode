package p0093_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[255.255.11.135,255.255.111.35] --> " + restoreIpAddresses2("25525511135"));
	}
	
	public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        
        result = helper(s, 0, "", result);
		
		return result;
    }
	
	private static List<String> helper(String s, int n, String curr, List<String> result) {
		if(n == 4) {
			if(s.isEmpty()) result.add(curr);
			return result;
		}
		
		for(int i = 1; i < 4; i++) {
			if(s.length() < i) break;
			
			int value = Integer.parseInt(s.substring(0, i));
			if(value > 255 || i != String.valueOf(value).length()) continue;
			
			result = helper(s.substring(i), n + 1, curr + s.substring(0, i) + (n == 3 ? "" : "."), result);
		}
		
		return result;
	}
	
	public static List<String> restoreIpAddresses2(String s) {
		List<String> result = new ArrayList<>();
		
		for(int i = 0; i < s.length() - 2; i++) {
			for(int j = i + 1; j < s.length() - 1; j++) {
				for(int k = j + 1; k < s.length(); k++) {
					String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, s.length());
					if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
						result.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
				}
			}
		}
		
		return result;
	}
	
	private static boolean isValid(String s) {
		if(s.length() > 3 || s.length() == 0 || (s.startsWith("0") && s.length() > 1) || Integer.parseInt(s) > 255) return false;
		return true;
	}

}
