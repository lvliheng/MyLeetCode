package p0067_Add_Binary;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("100 --> " + addBinary("11", "1"));
		System.out.println("10101 --> " + addBinary("1010", "1011"));
		System.out.println("1000 --> " + addBinary("1", "111"));
		
		System.out.println("0 --> " + 0 / 2 + ", " + 0 % 2);
		System.out.println("1 --> " + 1 / 2 + ", " + 1 % 2);
		System.out.println("2 --> " + 2 / 2 + ", " + 2 % 2);
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

}
