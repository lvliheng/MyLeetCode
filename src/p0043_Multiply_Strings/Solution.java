package p0043_Multiply_Strings;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("multiply: 6 --> " + multiply("2", "3"));
		System.out.println("multiply: 56088 --> " + multiply("123", "456"));
		System.out.println("multiply: 0 --> " + multiply("0", "0"));
	}
	
	public static String multiply(String num1, String num2) {
		
		StringBuilder result = new StringBuilder();
		int m = num1.length(), n = num2.length();
		int[] curr = new int[m + n];
		
		for(int i = m - 1; i >= 0; i--) {
			
			for(int j = n - 1; j >= 0; j--) {
				
				int val = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int currIndex = i + j, nextIndex = i + j + 1;
				int sum = val + curr[nextIndex];
				
				curr[currIndex] += sum / 10;
				curr[nextIndex] = sum % 10;
			}
		}
		
		for(int item : curr) {
			if(!result.toString().isEmpty() || item != 0) {
				result.append(item);
			}
		}
		
		return result.toString().isEmpty() ? "0" : result.toString();
	}

}
