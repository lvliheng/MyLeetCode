package p0067_Add_Binary;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("100 --> " + addBinary2("11", "1"));
		System.out.println("10101 --> " + addBinary2("1010", "1011"));
		System.out.println("1000 --> " + addBinary2("1", "111"));
	}
	
	public static String addBinary(String a, String b) {
		int carry = 0;
		
		StringBuilder result = new StringBuilder();
		StringBuilder stringBuilderA = new StringBuilder();
		StringBuilder stringBuilderB = new StringBuilder();
		
		if(a.length() > b.length()) {
			for(int i = 0; i < a.length() - b.length(); i++) {
				stringBuilderB.append("0");
			}
			stringBuilderB.append(b);	
			stringBuilderA = new StringBuilder(a);
		} else {
			for(int i = 0; i < b.length() - a.length(); i++) {
				stringBuilderA.append("0");
			}
			stringBuilderA.append(a);
			stringBuilderB = new StringBuilder(b);
		}
		
		for(int i = stringBuilderA.length() - 1; i >= 0; i--) {
			int sum = Integer.valueOf(stringBuilderA.charAt(i) - '0') + 
					Integer.valueOf(stringBuilderB.charAt(i) - '0') + carry;
			result = new StringBuilder(String.valueOf(sum % 2)).append(result);
			carry = sum / 2;
		}
		
		if(carry == 1) {
			result = new StringBuilder("1").append(result);
		}
		
		return result.toString();
    }
	
	public static String addBinary2(String a, String b) {
		StringBuilder result = new StringBuilder();
		int m = a.length() - 1, n = b.length() - 1, carry = 0;
		
		while(m >= 0 || n >= 0) {
			int p = m >= 0 ? Integer.valueOf(a.charAt(m--) - '0') : 0;
			int q = n >= 0 ? Integer.valueOf(b.charAt(n--) - '0') : 0;
			result = new StringBuilder(String.valueOf((p + q + carry) % 2)).append(result);
			carry = (p + q + carry) / 2;
		}
		
		return carry == 1 ? new StringBuilder("1").append(result).toString() : result.toString();
	}

}
