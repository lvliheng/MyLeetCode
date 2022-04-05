package p0143_Reorder_List;

public class Solution {

	
	public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        ListNode mid = slow.next;
        slow.next = null;
        ListNode last = mid, pre = null;
        
        while(last != null) {
        	ListNode next = last.next;
        	last.next = pre;
        	pre = last;
        	last = next;
        }
        
        while(head != null & pre != null) {
        	ListNode next = head.next;
        	head.next = pre;
        	pre = pre.next;
        	head.next.next = next;
        	head = next;
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
