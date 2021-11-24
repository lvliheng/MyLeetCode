package p0021_Merge_Two_Sorted_Lists;



public class Solution {

	public static void main(String[] args) {
		
		ListNode first = new ListNode(1);
		ListNode first1 = new ListNode(2);
		first.next = first1;
		ListNode first2 = new ListNode(4);
		first1.next = first2;
		
		ListNode second = new ListNode(1);
		ListNode second1 = new ListNode(3);
		second.next = second1;
		ListNode second2 = new ListNode(4);
		second1.next = second2;
		
		
		ListNode result = mergeTwoLists(first, second);
		
		System.out.print("mergeTwoLists: ");
		
		while(result != null) {
			System.out.print(result.val + " ");
	
			result = result.next;
		}

	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		ListNode flag = new ListNode();
		ListNode firstNode = flag;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				flag.next = l1;
				l1 = l1.next;
			} else {
				flag.next = l2;
				l2 = l2.next;
			}
			
			flag = flag.next;
		}
		
		flag.next = l1 != null ? l1 : l2;
		
		return firstNode.next;
	}
	
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
