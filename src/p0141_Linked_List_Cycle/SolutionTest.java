package p0141_Linked_List_Cycle;

import static org.junit.Assert.*;

import org.junit.Test;

import p0141_Linked_List_Cycle.Solution.ListNode;

public class SolutionTest {

	@Test
	public void test() {
		ListNode head = new ListNode(3);
		ListNode head1 = new ListNode(2);
		head.next = head1;
		ListNode head2 = new ListNode(0);
		head1.next = head2;
		ListNode head3 = new ListNode(-4);
		head2.next = head3;
		head3.next = head1;
		
		assertEquals(true, Solution.hasCycle(head));
	}

}
