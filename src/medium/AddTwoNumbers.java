package medium;


public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode first = new ListNode(9);
		ListNode first1 = new ListNode(9);
		first.next = first1;
		ListNode first2 = new ListNode(9);
		first1.next = first2;
		
		ListNode second = new ListNode(9);
//		ListNode second1 = new ListNode(6);
//		second.next = second1;
//		ListNode second2 = new ListNode(4);
//		second1.next = second2;
		
		
		ListNode result = addTwoNumbers(first, second);
		
		System.out.print("addTwoNumbers: ");
		
		while(result != null) {
			System.out.print(result.val + " ");
	
			result = result.next;
		}
	}
	
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		ListNode firstNode = result;
		
		int carry = 0;
		
		while(l1 != null || l2 != null) {
			int val1 = l1 == null ? 0 : l1.val;
			int val2 = l2 == null ? 0 : l2.val;
			
			int sum = carry + val1 + val2;
			
			carry = sum > 9 ? 1 : 0;
			
			result.next = new ListNode(sum % 10);
			
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
			result = result.next;
		}
		
		if(carry == 1) {
			result.next = new ListNode(1);
		}
		
		return firstNode.next;
	}
	
	
}
