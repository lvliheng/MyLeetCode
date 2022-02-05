package p0008_String_to_Integer_atoi;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("42 --> " + myAtoi("42"));
	}
	
	public static int myAtoi(String s) {
		int result = 0;
		int sign = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				if(sign != 0) return (sign >= 0 ? 1 : -1) * result;
				
				continue;
			} else if(s.charAt(i) == '-') {
				if(sign != 0) return (sign >= 0 ? 1 : -1) * result;
				
				sign = -1;
			} else if(s.charAt(i) == '+') {
				if(sign != 0) return (sign >= 0 ? 1 : -1) * result;
				
				sign = 1;
			} else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if(sign == 0) sign = 1;
				
				if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
					return (sign >= 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				
				result = result * 10 + s.charAt(i) - '0';
			} else {
				if(result == 0) {
					return 0;
				} else {
					return (sign >= 0 ? 1 : -1) * result;
				}
			}
		}
		
		return (sign >= 0 ? 1 : -1) * result;
    }
	
	public static int myAtoi2(String s) {
		if(s.isEmpty()) return 0;
		
		int sign = 1, base = 0, i = 0, n = s.length();
		
		while(i < n && s.charAt(i) == ' ') i++;
		
		if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			sign = (s.charAt(i++) == '+') ? 1 : -1;
		}
		
		while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			if(base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			
			base = 10 * base + (s.charAt(i++) - '0');
		}
		
		return base * sign;
	}

}
