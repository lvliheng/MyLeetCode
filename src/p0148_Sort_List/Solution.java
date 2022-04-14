package p0148_Sort_List;

class Solution {
    
	
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode slow = head, fast = head, pre = head;
        
        while(fast != null && fast.next != null) {
        	pre = slow;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }
	
	private ListNode merge(ListNode listNode1, ListNode listNode2) {
		if(listNode1 == null) return listNode2;
		if(listNode2 == null) return listNode1;
		
		if(listNode1.val < listNode2.val) {
			listNode1.next = merge(listNode1.next, listNode2);
			return listNode1;
		} else {
			listNode2.next = merge(listNode1, listNode2.next);
			return listNode2;
		}
	}
    
	public class ListNode {
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