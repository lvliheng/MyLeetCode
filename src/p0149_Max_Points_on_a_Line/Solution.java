package p0149_Max_Points_on_a_Line;
public class Solution {
    
	
	public static int maxPoints(int[][] points) {
        int result = 0, n = points.length;
        
        for(int i = 0; i < n; i++) {
        	int duplicate = 1;
        	
        	for(int j = i + 1; j < n; j++) {
        		int count = 0;
        		int x1 = points[i][0];
        		int y1 = points[i][1];
        		int x2 = points[j][0];
        		int y2 = points[j][1];
        		
        		if(x1 == x2 && y1 == y2) {
        			duplicate++;
        			continue;
        		}
        		
        		for(int k = 0; k < n; k++) {
        			int x3 = points[k][0];
        			int y3 = points[k][1];
        			
        			if(x1 * y2 + x2 * y3 + x3 * y1 - x3 * y2 - x2 * y1 - x1 * y3 == 0) {
        				count++;
        			}
        		}
        		
        		result = Math.max(result, count);
        	}
        	
        	result = Math.max(result, duplicate);
        }
        
        return result;
    }
}