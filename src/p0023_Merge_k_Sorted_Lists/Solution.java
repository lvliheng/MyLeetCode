package p0023_Merge_k_Sorted_Lists;

public class Solution {

	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(4);
		node1.next = node2;
		ListNode node3 = new ListNode(5);
		node2.next = node3;
		
		lists[0] = node1;
		
		ListNode node11 = new ListNode(1);
		ListNode node12 = new ListNode(3);
		node11.next = node12;
		ListNode node13 = new ListNode(4);
		node12.next = node13;
		
		lists[1] = node11;
		
		ListNode node111 = new ListNode(2);
		ListNode node112 = new ListNode(6);
		node111.next = node112;
		
		lists[2] = node111;
		
		System.out.println("[1,1,2,3,4,4,5,6] --> ");
		
		ListNode result = mergeKLists2(lists);
		
		while(result != null) {
			System.out.print(result.val + " ");
	
			result = result.next;
		}
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        
        int n = lists.length;
        
        while(n > 1) {
        	int k = (n + 1) / 2;
        	
        	for(int i = 0; i < n / 2; i++) {
        		lists[i] = mergeTwoLists(lists[i], lists[i + k]);
        	}
        	
        	n = k;
        }
        
		return lists[0];
    }
	
	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1), curr = dummy;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2; 
				l2 = l2.next;
			}
			
			curr = curr.next;
		}
		
		if(l1 != null) curr.next = l1;
		if(l2 != null) curr.next = l2;
		
		return dummy.next;
	}
	
	public static ListNode mergeKLists2(ListNode[] lists) {
		return helper(lists, 0, lists.length - 1);
	}
	
	private static ListNode helper(ListNode[] lists, int start, int end) {
		if(start > end) return null;
		if(start == end) return lists[start];
		
		int mid = start + (end - start) / 2;
		ListNode left = helper(lists, start, mid);
		ListNode right = helper(lists, mid + 1, end);
		
		return mergeTwoLists2(left, right);
	}
	
	private static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		if(l1.val < l2.val) {
			l1.next = mergeTwoLists2(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists2(l1, l2.next);
			return l2;
		}
	}
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
