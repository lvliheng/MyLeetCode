package p0092_Reverse_Linked_List_II;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[1,4,3,2,5] --> ");
		
		ListNode firstNode = new ListNode(1);
		ListNode firstNode1 = new ListNode(2);
		firstNode.next = firstNode1;
		ListNode firstNode2 = new ListNode(3);
		firstNode1.next = firstNode2;
		ListNode firstNode3 = new ListNode(4);
		firstNode2.next = firstNode3;
		ListNode firstNode4 = new ListNode(5);
		firstNode3.next = firstNode4;
		
		ListNode result = reverseBetween(firstNode, 2, 4);
		
		while(result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
	
	public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode pre = result;
        
        for(int i = 0; i < left - 1; i++) {
        	pre = pre.next;
        }
        
        ListNode curr = pre.next;
        
        for(int j = left; j < right; j++) {
        	ListNode temp = curr.next;
        	curr.next = temp.next;
        	temp.next = pre.next;
        	pre.next = temp;
        }
        
        return result.next;
    }
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
