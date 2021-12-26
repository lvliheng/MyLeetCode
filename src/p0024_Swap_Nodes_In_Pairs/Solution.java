package p0024_Swap_Nodes_in_Pairs;

public class Solution {

	public static void main(String[] args) {
		
		ListNode inputNode = new ListNode(1);
		ListNode inputNode1 = new ListNode(2);
		inputNode.next = inputNode1;
		ListNode inputNode2 = new ListNode(3);
		inputNode1.next = inputNode2;
		ListNode inputNode3 = new ListNode(4);
		inputNode2.next = inputNode3;
		
		ListNode resultListNode = swapPairs2(inputNode);
		
		System.out.print("swapPairs: ");
		
		while(resultListNode != null) {
			System.out.print(resultListNode.val + " ");
	
			resultListNode = resultListNode.next;
		}
	}
	
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static ListNode swapPairs(ListNode head) {
		ListNode result = new ListNode(0);
		result.next = head;
		ListNode pre = result;
		
		while(pre.next != null && pre.next.next != null) {
			ListNode first = pre.next;
			ListNode second = first.next;
			
			first.next = second.next;
			second.next = first;
			pre.next = second;
			
			pre = first;
		}
		
		return result.next;
	}
	
	public static ListNode swapPairs2(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode result = head.next;
		
		head.next = swapPairs2(head.next.next);
		
		result.next = head;
		
		return result;
	}

}
