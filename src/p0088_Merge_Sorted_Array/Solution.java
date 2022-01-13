package p0088_Merge_Sorted_Array;

public class Solution {

	public static void main(String[] args) {
		
		System.out.print("[1,2,2,3,5,6] --> ");
		merge3(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3);
		
		System.out.println();
		System.out.print("[1] --> ");
		merge3(new int[] {1}, 1, new int[] {}, 0);
		
		System.out.println();
		System.out.print("[1] --> ");
		merge3(new int[] {0}, 0, new int[] {1}, 1);
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i < n; i++) {
        	
        	int temp = nums2[i], j;
        	
        	for(j = m + i - 1; j >= 0; j--) {
        		if(temp < nums1[j]) {
        			nums1[j + 1] = nums1[j];
        		} else {
        			break;
        		}
        	}
        	nums1[j + 1] = temp;
        }
        
        for(int item : nums1) {
        	System.out.print(item + " ");
        }
    }
	
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		
		while(i >= 0 && j >= 0) {
			if(nums1[i] > nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}
		while(j >= 0) nums1[k--] = nums2[j--];
			
		for(int item : nums1) {
        	System.out.print(item + " ");
        }
	}
	
	public static void merge3(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		
		while(j >= 0) {
			if(i >= 0 && nums1[i] > nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}
			
		for(int item : nums1) {
        	System.out.print(item + " ");
        }
	}

}
