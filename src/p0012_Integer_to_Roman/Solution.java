package p0012_Integer_to_Roman;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("III --> " + intToRoman3(3));
	}
	
	public static String intToRoman(int num) {
		String result = "";
		char[] roman = new char[] {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
		int[] value = new int[] {1000, 500, 100, 50, 10, 5, 1};
		
		for(int n = 0; n < 7; n += 2) {
			int x = num / value[n];
			
			if(x < 4) {
				for(int i = 1; i <= x; i++) result += roman[n];
			} else if(x == 4) {
				result = result + roman[n] + roman[n - 1];
			} else if(x > 4 && x < 9) {
				result += roman[n - 1];
				for(int i = 6; i <= x; i++) result += roman[n];
			} else if(x == 9) {
				result = result + roman[n] + roman[n - 2];
			}
			 num %= value[n];
		}
		
		return result;
	}
	
	public static String intToRoman2(int num) {
		String result = "";
		int[] value = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] str = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		
		for(int i = 0; i < value.length; i++) {
			while(num >= value[i]) {
				num -= value[i];
				result += str[i];
			}
		}
		
		return result;
	}
	
	public static String intToRoman3(int num) {
		String[] v1 = new String[] {"", "M", "MM", "MMM"};
		String[] v2 = new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] v3 = new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] v4 = new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		
		return v1[num / 1000] + v2[(num % 1000) / 100] + v3[(num % 100) / 10] + v4[num % 10];
	}

}
