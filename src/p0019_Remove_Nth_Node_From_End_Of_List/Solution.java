package p0019_Remove_Nth_Node_From_End_of_List;

public class Solution {

	public static void main(String[] args) {
		
		ListNode firstNode = new ListNode(1);
		ListNode firstNode1 = new ListNode(2);
		firstNode.next = firstNode1;
		ListNode firstNode2 = new ListNode(3);
		firstNode1.next = firstNode2;
		ListNode firstNode3 = new ListNode(4);
		firstNode2.next = firstNode3;
		ListNode firstNode4 = new ListNode(5);
		firstNode3.next = firstNode4;
		
		ListNode resultNode = removeNthFromEnd(firstNode, 2);
		
		System.out.print("removeNthFromEnd: ");
		
		while(resultNode != null) {
			System.out.print(resultNode.val + " ");
	
			resultNode = resultNode.next;
		}
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		
		if(head.next == null) {
			return null;
		}
		
		ListNode pre = head, curr = head;
		
		for(int i = 0; i < n; i++) {
			curr = curr.next;
		}
		
		if(curr == null) {
			return head;
		}
		
		while(curr.next != null) {
			curr = curr.next;
			pre = pre.next;
		}
		
		pre.next = pre.next.next;
		
		return head;
	}
	
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
