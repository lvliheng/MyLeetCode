package p0022_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[()]");
		System.out.println(" || ");
		System.out.println(generateParenthesis(1));
		
		System.out.println();
		System.out.println("[()(), (())]");
		System.out.println(" || ");
		System.out.println(generateParenthesis(2));
		
		System.out.println();
		System.out.println("[((())), (()()), (())(), ()(()), ()()()]");
		System.out.println(" || ");
		System.out.println(generateParenthesis(3));
	}
	
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generate(result, "", n, n);
		
		return result;
	}
	
	public static void generate(List<String> result, String currStr, int leftRemainCount, int rightRemainCount) {
		if(leftRemainCount == 0 && rightRemainCount == 0) {
			result.add(currStr);
		}
		if(leftRemainCount > 0) {
			generate(result, currStr + "(", leftRemainCount - 1, rightRemainCount);
		}
		if(rightRemainCount > 0 && leftRemainCount < rightRemainCount) {
			generate(result, currStr + ")", leftRemainCount, rightRemainCount - 1);
		}
	}

}
