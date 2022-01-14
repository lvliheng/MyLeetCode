package p0089_Gray_Code;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		/**以二进制为0值的格雷码为第零项，
		 * 第一项改变最右边的位元，
		 * 第二项改变右起第一个为1的位元的左边位元，
		 * 第三、四项方法同第一、二项，
		 * 如此反复，即可排列出n个位元的格雷码。
		 */
		System.out.println("[0,1,3,2] --> " + grayCode2(2));
	}
	
	public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < 1 << n; i++) {
        	result.add(i ^ (i >> 1));
        }
        
        return result;
    }
	
	public static List<Integer> grayCode2(int n) {
        List<Integer> result = new ArrayList<>();                                                                 
        result.add(0);
        
        for(int i = 0; i < n; i++) {
        	int size = result.size();
        	
        	for(int j = size - 1; j >= 0; j--) {
        		result.add(result.get(j) | 1 << i);
        	}
        }
        
        return result;
    }

}
