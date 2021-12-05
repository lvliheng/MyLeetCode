package p0038_Count_and_Say;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("countAndSay: 1 --> " + countAndSay(1));
		System.out.println("countAndSay: 1211 --> " + countAndSay(4));
		System.out.println("countAndSay: 11 --> " + countAndSay(2));
		System.out.println("countAndSay: 312211 --> " + countAndSay(6));
	}
	
	public static String countAndSay(int n) {
		
		String result = "1";
		
		for(int i = 1; i < n; i++) {
			StringBuilder curr = new StringBuilder();
			
			for(int j = 0; j < result.length(); j++) {
				int count = 1;
				
				while(j + 1 < result.length() && result.charAt(j) == result.charAt(j + 1)) {
					j++;
					count++;
				}
				
				curr = curr.append(count);
				curr = curr.append(result.charAt(j));
			}
			
			result = curr.toString();
		}
		
		return result;
	}

}
