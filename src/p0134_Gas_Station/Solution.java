package p0134_Gas_Station;

public class Solution {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, sum = 0, start = 0;
        
        for(int i = 0; i < gas.length; i++) {
        	total += gas[i] - cost[i];
        	sum += gas[i] - cost[i];
        	
        	if(sum < 0) {
        		start = i + 1;
        		sum = 0;
        	}
        }
		
		return total < 0 ? -1 : start;
    }
	
	public static int canCompleteCircuit2(int[] gas, int[] cost) {
		int total = 0, mx = -1, start = 0;
		
		for(int i = gas.length - 1; i >= 0; i--) {
			total += gas[i] - cost[i];
			
			if(total > mx) {
				start = i;
				mx = total;
			}
		}
		
		return total < 0 ? -1 : start;
	}

}
