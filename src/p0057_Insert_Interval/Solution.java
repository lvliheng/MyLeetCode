package p0057_Insert_Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[[1,5],[6,9]] --> ");
		for(int[] itemList : insert(new int[][] {{1,3},{6,9}}, new int[] {2,5})) {
			for(int item : itemList) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("[[1,2],[3,10],[12,16]] --> ");
		for(int[] itemList : insert(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[] {4,8})) {
			for(int item : itemList) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("[[1,5],[6,8]] --> ");
		for(int[] itemList : insert(new int[][] {{1,5}}, new int[] {6,8})) {
			for(int item : itemList) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("[[0,5]] --> ");
		for(int[] itemList : insert(new int[][] {{1,5}}, new int[] {0,3})) {
			for(int item : itemList) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("[[0,0],[1,5]] --> ");
		for(int[] itemList : insert(new int[][] {{1,5}}, new int[] {0,0})) {
			for(int item : itemList) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("[[0,9]] --> ");
		for(int[] itemList : insert(new int[][] {{1,5},{6,8}}, new int[] {0,9})) {
			for(int item : itemList) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("[[0,2],[3,8],[10,12],[13,15]] --> ");
		for(int[] itemList : insert(new int[][] {{0,2},{3,5},{6,8},{10,12},{13,15}}, new int[] {4,7})) {
			for(int item : itemList) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int cur = 0;

        for(int i = 0; i < intervals.length; i++) {
        	if(intervals[i][1] < newInterval[0]) {
        		result.add(intervals[i]);
        		cur++;
        	} else if(intervals[i][0] > newInterval[1]) {
        		result.add(intervals[i]);
        	} else {
        		newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        		newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        	}
        }
        
        result.add(cur, newInterval);
        
        return result.toArray(new int[result.size()][]);
    }

}
