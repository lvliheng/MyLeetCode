package p0065_Valid_Number;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("true --> " + isNumber("0"));
		System.out.println("true --> " + isNumber("1E9"));
	}
	
	public static boolean isNumber(String s) {
        boolean hasNum = false, hasNumAfterE = false, hasDot = false, hasE = false;
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
        	if(s.charAt(i) == '+' || s.charAt(i) == '-') {
        		if(i > 0 && s.charAt(i - 1) != 'e') return false;
        	} else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        		hasNum = true;
        		hasNumAfterE = true;
        	} else if(s.charAt(i) == '.') {
        		if(hasDot || hasE) return false;
        		hasDot = true;
        	} else if(s.charAt(i) == 'e' || s.charAt(i) == 'E') {
        		if(hasE || !hasNum) return false;
        		hasE = true;
        		hasNumAfterE = false;
        	} else {
        		return false;
        	}
        }
        
        return hasNum && hasNumAfterE;
    }

}
