package p0120_Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		int[][] list = new int[][] {{2},{3,4},{6,5,7},{4,1,8,3}};
		
		System.out.println("11 --> " + minimumTotal2(generateInput(list)));
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
        for(int i = 1; i < triangle.size(); i++) {
        	for(int j = 0; j < triangle.get(i).size(); j++) {
        		if(j == 0) {
        			triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j));
        		} else if(j == triangle.get(i).size() - 1) {
        			triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
        		} else {
        			triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)));
        		}
        	}
        }
		
        List<Integer> last = triangle.get(triangle.size() - 1);
        int result = Integer.MAX_VALUE;
        for(int item : last) {
        	if(result > item) result = item;
        }
		return result;
    }
	
	public static int minimumTotal2(List<List<Integer>> triangle) {
		int[] dp = triangle.get(triangle.size() - 1).stream().mapToInt(i->i).toArray();
		
		for(int i = triangle.size() - 2; i >= 0; i--) {
			for(int j = 0; j <= i; j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
			}
		}
		
		return dp[0];
	}
	
	private static List<List<Integer>> generateInput(int[][] list){
		List<List<Integer>> input = new ArrayList<>();
		List<Integer> current = null;
		
		for(int[] item1 : list) {
			current = new ArrayList<>();
			
			for(int item2 : item1) {
				current.add(item2);
			}
			
			input.add(current);
		}
		
		return input;
	}

}
