package p0029_Divide_Two_Integers;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("3 --> " + divide(10, 3));
		System.out.println("-2 --> " + divide(7, -3));
		System.out.println("0 --> " + divide(0, 1));
		System.out.println("1 --> " + divide(1, 1));
	}
	
	public static int divide(int dividend, int divisor) {
		
		boolean sign = dividend > 0 == divisor > 0;
		
		long a = Math.abs((long) dividend);
		long divisorLong = Math.abs((long) divisor);
		long b = divisorLong;
		
		long result = 0;
		int current = 1;
		
		while(a >= divisorLong) {
			a -= b;
			result += current;
			current += current;
			b += b;
			
			if(a < b) {
				b = divisorLong;
				current = 1;
			}
		}
		
		if(sign) return (int) Math.min(result, Integer.MAX_VALUE);
		
		return (int) Math.max(-result, Integer.MIN_VALUE);
	}

}
