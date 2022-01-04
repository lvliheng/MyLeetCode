package p0077_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]:  --> " + combine(4, 2));
		System.out.println("[[1]]:  --> " + combine(1, 1));
	}
	
	public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        helper(n, k, 1, current, result);
        
        return result;
    }
	
	private static void helper(int n, int k, int level, List<Integer> current, List<List<Integer>> result) {
		if(current.size() == k) {
			result.add(new ArrayList<>(current));
			return;
		}
		
		for(int i = level; i <= n; i++) {
			current.add(i);
			helper(n, k, i + 1, current, result);
			current.remove(current.size() - 1);
		}
	}

}
