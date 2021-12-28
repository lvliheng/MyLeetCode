package p0069_Sqrt_x;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("2 --> " + mySqrt2(4));
		System.out.println("2 --> " + mySqrt2(8));
		System.out.println("2 --> " + mySqrt2(5));
	}
	
	public static int mySqrt(int x) {
        if(x <= 1) return x;
        
		int left = 0, right = x;
		
		while(left < right) {
			int mid = left + (right - left) / 2;
			
			if(x / mid >= mid) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		return right - 1;
    }
	
	public static int mySqrt2(int x) {
		long result = x;
		
		while(result * result > x) {
			result = (result + x / result) / 2;
		}
		
		return (int) result;
	}

}
