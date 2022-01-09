package p0082_Remove_Duplicates_from_Sorted_List_II;


public class Solution {

	public static void main(String[] args) {
		
		System.out.print("[1,2,5] --> ");	
		
		ListNode first = new ListNode(1);
		ListNode first1 = new ListNode(2);
		first.next = first1;
		ListNode first2 = new ListNode(3);
		first1.next = first2;
		ListNode first3 = new ListNode(3);
		first2.next = first3;
		ListNode first4 = new ListNode(4);
		first3.next = first4;
		ListNode first5 = new ListNode(4);
		first4.next = first5;
		ListNode first6 = new ListNode(5);
		first5.next = first6;
		
		ListNode result = deleteDuplicates2(first);
		
		while(result != null) {
			System.out.print(result.val + " ");
	
			result = result.next;
		}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
		
        ListNode result = new ListNode(-1), pre = result;
        result.next = head;
        
        while(pre.next != null) {
        	ListNode current = pre.next;
        	
        	while(current.next != null && current.next.val == current.val) {
        		current = current.next;
        	}
        	
        	if(current != pre.next) {
        		pre.next = current.next;
        	} else {
        		pre = pre.next;
        	}
        }
		
		return result.next;
    }
	
	public static ListNode deleteDuplicates2(ListNode head) {
		if(head == null) return head;
		
		if(head.next != null && head.val == head.next.val) {
			while(head.next != null && head.val == head.next.val) {
				head = head.next;
			}
			return deleteDuplicates2(head.next);
		}
		
		head.next = deleteDuplicates2(head.next);
		
		return head;
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
