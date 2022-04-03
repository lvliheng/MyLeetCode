package p0142_Linked_List_Cycle_II;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import p0142_Linked_List_Cycle_II.Solution.ListNode;

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
		
		assertEquals(head1, Solution.detectCycle(head));
	}

}
