package p0056_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		
		System.out.println("[[1,6],[8,10],[15,18]] --> ");
		for(int[] itemList : merge(new int[][] {{1,3},{2,6},{8,10},{15,18}})) {
			for(int item : itemList) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("[[1,5]] --> ");
		for(int[] itemList : merge(new int[][] {{1,4},{4,5}})) {
			for(int item : itemList) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("[[1,4]] --> ");
		for(int[] itemList : merge(new int[][] {{1,4},{2,3}})) {
			for(int item : itemList) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		
	}
	
	public static int[][] merge(int[][] intervals) {
		if(intervals.length == 0) return intervals;
		
		Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
		
		List<int[]> result = new ArrayList<>();
		
		int[] pre = intervals[0];
		
		for(int i = 1; i < intervals.length; i++) {
			if(pre[1] >= intervals[i][0]) {
				if(pre[1] > intervals[i][1]) {
					continue;
				}
				
				pre[1] = intervals[i][1];
			} else {
				result.add(pre);
				pre = intervals[i];
			}
		}
		
		result.add(pre);
		
		return result.toArray(new int[result.size()][]);
    }

}
