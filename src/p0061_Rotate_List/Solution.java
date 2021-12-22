package p0061_Rotate_List;

public class Solution {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		ListNode node5 = new ListNode(5);
		node4.next = node5;
		
		System.out.print("[4,5,1,2,3] --> ");
		
		ListNode result = rotateRight2(node1, 2);
		
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
	
	public static ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null || k == 0) return head;
		
        ListNode resultHead = head;
        ListNode resultBody = head.next;
		
        ListNode temp = resultHead;
        ListNode result = resultBody;
        
        int n = 1;
        
        ListNode node = head;
        while(node.next != null) {
        	node = node.next;
        	n++;
        }
        
        for(int i = 0; i < n - k % n; i++) {
            if(temp != null) {
        		resultHead = temp;
        		resultBody = temp.next;
        	}
            
            result = resultBody;
            temp = result;
        	
        	while(resultBody.next != null) {
        		resultBody = resultBody.next;
        	}
        	
        	resultBody.next = resultHead;
        	resultHead.next = null;
        }
    	
		return result;
    }
	
	public static ListNode rotateRight2(ListNode head, int k) {
		if(head == null) return head;
		
		ListNode curr = head;
		int n = 1;
		
		while(curr.next != null) {
			curr = curr.next;
			n++;
		}
		
		curr.next = head;
		
		for(int i = 0; i < n - k % n; i++) {
			curr = curr.next;
		}
		
		ListNode result = curr.next;
		curr.next = null;
		
		return result;
	}

}
