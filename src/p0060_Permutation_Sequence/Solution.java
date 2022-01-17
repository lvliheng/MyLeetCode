package p0060_Permutation_Sequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("213 --> " + getPermutation2(3, 3));
	}
	
	public static String getPermutation(int n, int k) {
		StringBuilder result = new StringBuilder();
		
		List<String> nums = new ArrayList<>();
		for(int i = 1; i < 10; i++) {
			nums.add(String.valueOf(i));
		}
		
		int[] factors = new int[n];
		factors[0] = 1;
		for(int i = 1; i < n; i++) {
			factors[i] = factors[i - 1] * i;
		}
		
		k--;
		
		for(int i = n; i >= 1; i--) {
			int j = k / factors[i - 1];
			k %= factors[i - 1];
			result.append(nums.get(j));
			nums.remove(j);
		}
		
		return result.toString();
    }
	
	public static String getPermutation2(int n, int k) {
		StringBuilder result = new StringBuilder();
		
		int factor = 1;
		List<String> nums = new ArrayList<>();
		for(int i = 1; i < n; i++) {
			factor *= i;
			nums.add(String.valueOf(i));
		}
		nums.add(String.valueOf(n));
		
		k--;
		
		while(true) {
			result.append(nums.get(k / factor));
			nums.remove(k / factor);
			
			if(nums.isEmpty()) break;
			
			k %= factor;
			factor /= nums.size();
		}
		
		return result.toString();
	}

}
