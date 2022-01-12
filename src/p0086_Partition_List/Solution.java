package p0086_Partition_List;

public class Solution {

	public static void main(String[] args) {
		
		ListNode first = new ListNode(1);
		ListNode first1 = new ListNode(4);
		first.next = first1;
		ListNode first2 = new ListNode(3);
		first1.next = first2;
		ListNode first3 = new ListNode(2);
		first2.next = first3;
		ListNode first4 = new ListNode(5);
		first3.next = first4;
		ListNode first5 = new ListNode(2);
		first4.next = first5;
		
		ListNode result = partition(first, 3);
		
		while(result != null) {
			System.out.print(result.val + " ");
	
			result = result.next;
		}
	}
	
	public static ListNode partition(ListNode head, int x) {
        ListNode resultHead = new ListNode(-1);
        ListNode result = resultHead;
        
        ListNode tailHead = new ListNode(-1);
        ListNode tail = tailHead;
		
		while(head != null) {
			if(head.val >= x) {
				tailHead.next = head;
				tailHead = tailHead.next;
			} else {
				resultHead.next = head;
				resultHead = resultHead.next;
			}
			head = head.next;
		}
		
		tailHead.next = null;
		
		resultHead.next = tail.next;
		
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
