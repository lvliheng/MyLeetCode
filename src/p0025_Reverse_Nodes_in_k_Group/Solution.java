package p0025_Reverse_Nodes_in_k_Group;

public class Solution {

	public static void main(String[] args) {
		
		ListNode inputNode = new ListNode(1);
		ListNode inputNode1 = new ListNode(2);
		inputNode.next = inputNode1;
		ListNode inputNode2 = new ListNode(3);
		inputNode1.next = inputNode2;
		ListNode inputNode3 = new ListNode(4);
		inputNode2.next = inputNode3;
		ListNode inputNode4 = new ListNode(5);
		inputNode3.next = inputNode4;
		
		System.out.println("[2,1,4,3,5] --> ");
		
		ListNode resultListNode = reverseKGroup3(inputNode, 2);
		
		while(resultListNode != null) {
			System.out.print(resultListNode.val + " ");
	
			resultListNode = resultListNode.next;
		}
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(-1), pre = dummy, curr = head;
        dummy.next = head;
        
        for(int i = 1; curr != null; i++) {
        	if(i % k == 0) {
        		pre = reverseOneGroup(pre, curr.next);
        		curr = pre.next;
        	} else {
        		curr = curr.next;
        	}
        }
        
        return dummy.next;
    }
	
	private static ListNode reverseOneGroup(ListNode pre, ListNode next) {
		ListNode last = pre.next, curr = last.next;
		
		while(curr != next) {
			last.next = curr.next;
			curr.next = pre.next;
			pre.next = curr;
			curr = last.next;
		}
		
		return last;
	}
	
	public static ListNode reverseKGroup2(ListNode head, int k) {
		ListNode dummy = new ListNode(-1), pre = dummy, curr = pre;
		dummy.next = head;
		
		int num = 0;
		
		while(curr.next != null) {
			curr = curr.next;
			num++;
		}
		
		while(num >= k) {
			curr = pre.next;
			
			for(int i = 1; i < k; i++) {
				ListNode temp = curr.next;
				curr.next = temp.next;
				temp.next = pre.next;
				pre.next = temp;
			}
			
			pre = curr;
			num -= k;
		}
		
		return dummy.next;
	}
	
	public static ListNode reverseKGroup3(ListNode head, int k) {
		ListNode curr = head;
		
		for(int i = 0; i < k; i++) {
			if(curr == null) return head;
			curr = curr.next;
		}
		
		ListNode newHead = reverse(head, curr);
		head.next = reverseKGroup3(curr, k);
		
		return newHead;
	}
	
	private static ListNode reverse(ListNode head, ListNode tail) {
		ListNode pre = tail;
		
		while(head != tail) {
			ListNode temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}
		
		return pre;
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
