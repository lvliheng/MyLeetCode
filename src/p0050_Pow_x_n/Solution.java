package p0050_Pow_x_n;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("1024.00000 --> " + myPow(2.00000, 10));
		System.out.println("9.26100 --> " + myPow(2.10000, 3));
		System.out.println("0.25000 --> " + myPow(2.00000, -2));
	}
	
	public static double myPow(double x, int n) {
		double result = 1.0;
		
		for(int i = n; i != 0; i /= 2) {
			if(i % 2 != 0) result *= x;
			x *= x;
		}
		
		return n > 0 ? result : 1 / result;
	}

}
