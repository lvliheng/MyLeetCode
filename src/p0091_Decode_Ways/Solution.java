package p0091_Decode_Ways;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("3 --> " + numDecodings2("226"));
	}
	
	public static int numDecodings(String s) {
        if(s.isEmpty() || s.startsWith("0")) return 0;
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        
        for(int i = 1; i <= s.length(); i++) {
        	if(s.charAt(i - 1) != '0') dp[i] += dp[i - 1];
        	if(i >= 2 && (s.substring(i - 2, i).compareTo("10") >= 0 && s.substring(i - 2, i).compareTo("26") <= 0)) {
        		dp[i] += dp[i - 2];
        	}
        }
		
		return dp[s.length()];
    }
	
	public static int numDecodings2(String s) {
		if(s.isEmpty() || s.startsWith("0")) return 0;
		
		int a = 1, b = 1, n = s.length();
		
		for(int i = 1; i < n; i++) {
			if(s.charAt(i) == '0') a = 0;
			if(s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
				a = a + b;
				b = a - b;
			} else {
				b = a;
			}
		}
		
		return a;
	}

}
