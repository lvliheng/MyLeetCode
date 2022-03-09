package p0118_Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]] --> ");
		
		printResult(generate(5));
	}
	
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = null;
        
        for(int i = 1; i <= numRows; i++) {
        	current = new ArrayList<>();
        	current.add(1);
        	
        	if(result.size() == 0) {
        		result.add(current);
        	} else {
        		for(int j = 1; j < result.get(result.size() - 1).size(); j++) {
        			current.add(result.get(result.size() - 1).get(j - 1) + result.get(result.size() - 1).get(j));
        		}
        		
        		current.add(1);
        		
        		result.add(current);
        	}
        }
        
        return result;
    }
	
	private static void printResult(List<List<Integer>> result) {
		for(int i = 0; i < result.size(); i++) {
			for(int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			
			System.out.println();
		}
	}

}
