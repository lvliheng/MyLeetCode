package p0109_Convert_Sorted_List_to_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[0,-3,9,-10,null,5] -->");
		
		ListNode head = new ListNode(-10);
		ListNode head1 = new ListNode(-3);
		head.next = head1;
		ListNode head2 = new ListNode(0);
		head1.next = head2;
		ListNode head3 = new ListNode(5);
		head2.next = head3;
		ListNode head4 = new ListNode(9);
		head3.next = head4;
		
		printResult(sortedListToBST3(head));
	}
	
	public static TreeNode sortedListToBST(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        
        while(head != null) {
        	nums.add(head.val);
        	head = head.next;
        }
        
        return helper(nums, 0, nums.size() - 1);
    }
	
	private static TreeNode helper(List<Integer> nums, int left, int right) {
		if(left > right) return null;
		
		int mid = left + (right - left) / 2;
		
		TreeNode result = new TreeNode(nums.get(mid));
		result.left = helper(nums, left, mid - 1);
		result.right = helper(nums, mid + 1, right);
		
		return result;
	}
	
	public static TreeNode sortedListToBST2(ListNode head) {
		if(head == null) return null;
		
		if(head.next == null) return new TreeNode(head.val);
		
		ListNode slow = head, fast = head, last = slow;
		
		while(fast.next != null && fast.next.next != null) {
			last = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		fast = slow.next;
		last.next = null;
		
		TreeNode result = new TreeNode(slow.val);
		if(head != slow) result.left = sortedListToBST2(head);
		result.right = sortedListToBST2(fast);
		
		return result;
	}
	
	public static TreeNode sortedListToBST3(ListNode head) {
		if(head == null) return null;
		
		return helper3(head, null);
	}
	
	private static TreeNode helper3(ListNode head, ListNode tail) {
		if(head == tail) return null;
		
		ListNode slow = head, fast = head;
		
		while(fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		TreeNode result = new TreeNode(slow.val);
		result.left = helper3(head, slow);
		result.right = helper3(slow.next, tail);
		
		return result;
	}
	
	private static void printResult(TreeNode node) {
		if(node != null) {
			System.out.print(node.val + " ");
			
			printResult(node.left);
			printResult(node.right);
		}
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
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
