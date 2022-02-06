package p0042_Trapping_Rain_Water;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("6 --> " + trap4(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}
	
	public static int trap(int[] height) {
		int result = 0, mx = 0, n = height.length;
		int[] dp = new int[n];
		
		for(int i =0; i < n; i++) {
			dp[i] = mx;
			mx = Math.max(mx, height[i]);
		}
		
		mx = 0;
		
		for(int i = n- 1; i >= 0; i--) {
			dp[i] = Math.min(dp[i], mx);
			mx = Math.max(mx, height[i]);
			if(dp[i] - height[i] > 0) result += dp[i] - height[i];
		}
		
		return result;
	}
	
	public static int trap2(int[] height) {
		int result = 0, l = 0, r = height.length - 1;
		
		while(l < r) {
			int mn = Math.min(height[l], height[r]);
			
			if(height[l] == mn) {
				l++;
				while(l < r && height[l] < mn) {
					result += mn - height[l++];
				}
			} else {
				r--;
				while(l < r && height[r] < mn) {
					result += mn - height[r--];
				}
			}
		}
		
		return result;
	}
	
	public static int trap3(int[] height) {
		int l = 0, r = height.length - 1, level = 0, result = 0;
		
		while(l < r) {
			int lower = height[(height[l] < height[r]) ? l++ : r--];
			level = Math.max(level, lower);
			result += level - lower;
		}
		
		return result;
	}
	
	public static int trap4(int[] height) {
		Stack<Integer> s = new Stack<>();
		int i = 0, n = height.length, result = 0;
		
		while(i < n) {
			if(s.isEmpty() || height[i] <= height[s.peek()]) {
				s.push(i++);
			} else {
				int t = s.pop();
				if(s.isEmpty()) continue;
				result += (Math.min(height[i], height[s.peek()]) - height[t]) * (i - s.peek() - 1);
			}
		}
		
		return result;
	}

}
