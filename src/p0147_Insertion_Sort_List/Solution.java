package p0147_Insertion_Sort_List;

public class Solution {

	
	public static ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode(-1), curr = result;
        
        while(head != null) {
        	ListNode temp = head.next;
        	curr = result;
        	
        	while(curr.next != null && curr.next.val <= head.val) {
        		curr = curr.next;
        	}
        	
        	head.next = curr.next;
        	curr.next = head;
        	head = temp;
        }
        
        return result.next;
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
