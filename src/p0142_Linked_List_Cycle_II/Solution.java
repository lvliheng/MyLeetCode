package p0142_Linked_List_Cycle_II;

public class Solution {

	
	public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	
        	if(slow == fast) break;
        }
        
        if(fast == null || fast.next == null) return null;
        
        slow = head;
        while(slow != fast) {
        	slow = slow.next;
        	fast = fast.next;
        }
        
        return fast;
    }
	
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
