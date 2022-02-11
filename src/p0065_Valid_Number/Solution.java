package p0065_Valid_Number;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("true --> " + isNumber("0"));
		System.out.println("true --> " + isNumber("1E9"));
	}
	
	public static boolean isNumber(String s) {
        boolean num = false, numAfterE = false, dot = false, exp = false;
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
        	if(s.charAt(i) == '+' || s.charAt(i) == '-') {
        		if(i > 0 && s.charAt(i - 1) != 'e') return false;
        	} else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        		num = true;
        		numAfterE = true;
        	} else if(s.charAt(i) == '.') {
        		if(dot || exp) return false;
        		dot = true;
        	} else if(s.charAt(i) == 'e' || s.charAt(i) == 'E') {
        		if(exp || !num) return false;
        		exp = true;
        		numAfterE = false;
        	} else {
        		return false;
        	}
        }
        
        return num && numAfterE;
    }

}
