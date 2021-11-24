package p0007_Reverse_Integer;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("reverseInt: " + reverseInt(1534236469));
	}

	public static int reverseInt(int x) {
		
		long result = 0;
		
		while(x != 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}
		
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		}
		
		return (int) result;
	}

}
