package p0006_Zigzag_Conversion;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("PAHNAPLSIIGYIR --> " + convert3("PAYPALISHIRING", 3));
		System.out.println("A --> " + convert3("A", 2));
	}
	
	public static String convert(String s, int numRows) {
		if(s == null || numRows < 2) return s;
		
		StringBuilder[] rows = new StringBuilder[numRows];
		
		for(int i = 0; i < rows.length; i++) {
			rows[i] = new StringBuilder();
		}
		
		int index = 0;
		boolean needPlus = false;
		
		for(int j = 0; j < s.length(); j++) {
			rows[index].append(s.charAt(j));
			
			if(index == 0) {
				needPlus = true;
			} else if(index == numRows - 1) {
				needPlus = false;
			}
			
			if(needPlus) {
				index++;
			} else {
				index--;
			}
		}
		
		StringBuilder result = new StringBuilder();
		
		for(StringBuilder row : rows) {
			result.append(row);
		}
		
		return result.toString();
	}
	
	public static String convert2(String s, int numRows) {
		if(numRows <= 1) return s;
		
		StringBuilder result = new StringBuilder();
		int size = 2 * numRows - 2, n = s.length();
		
		for(int i = 0; i < numRows; i++) {
			for(int j = i; j < n; j += size) {
				result.append(s.charAt(j));
				int pos = j + size - 2 * i;
				if(i != 0 && i != numRows - 1 && pos < n) result.append(s.charAt(pos));
			}
		}
		
		return result.toString();
	}
	
	public static String convert3(String s, int numRows) {
		if(numRows <= 1) return s;
		
		StringBuilder[] rows = new StringBuilder[numRows];
		for(int i = 0; i < numRows; i++) {
			rows[i] = new StringBuilder();
		}
		
		int index = 0;
		while(index < s.length()) {
			for(int i = 0; i < numRows && index < s.length(); i++) {
				rows[i].append(s.charAt(index++));
			}
			for(int i = numRows - 2; i > 0 && index < s.length(); i--) {
				rows[i].append(s.charAt(index++));
			}
		}
		
		StringBuilder result = new StringBuilder();
		for(StringBuilder row : rows) {
			result.append(row);
		}
		
		return result.toString();
	}

}
