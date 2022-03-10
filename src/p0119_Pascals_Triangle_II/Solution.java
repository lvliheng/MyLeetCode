package p0119_Pascals_Triangle_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[1,3,3,1] --> ");
		
		for(int item : getRow2(3)) {
			System.out.print(item + " ");
		}
	}
	
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> last = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
    	current.add(1);
        
        for(int i = 0; i < rowIndex; i++) {
        	current = new ArrayList<>();
        	current.add(1);
        	
        	if(last.size() > 1) {
        		for(int j = 1; j < last.size(); j++) {
        			current.add(last.get(j - 1) + last.get(j));
        		}
        	}
        	
        	current.add(1);
        	last = current;
        }
        
        return current;
    }
	
	public static List<Integer> getRow2(int rowIndex) {
		int[] result = new int[rowIndex + 1];
		result[0] = 1;
		
		for(int i = 1; i <= rowIndex; i++) {
			for(int j = i; j >= 1; j--) {
				result[j] += result[j - 1];
			}
		}
		
		return Arrays.stream(result).boxed().collect(Collectors.toList());
	}

}
