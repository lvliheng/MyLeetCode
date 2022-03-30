package p0138_Copy_List_with_Random_Pointer;

import static org.junit.Assert.*;

import org.junit.Test;

import p0138_Copy_List_with_Random_Pointer.Solution.Node;

public class SolutionTest {

	@Test
	public void test() {
		Node head = getHead();
		assertNotEquals(head, Solution.copyRandomList(head));
	}
	
	@Test
	public void test2() {
		Node head = getHead();
		assertNotEquals(head, Solution.copyRandomList2(head));
	}
	
	@Test
	public void test3() {
		Node head = getHead();
		assertNotEquals(head, Solution.copyRandomList3(head));
	}
	
	private Node getHead() {
		Node head = new Node(7);
		Node head1 = new Node(13);
		Node head2 = new Node(11);
		Node head3 = new Node(10);
		Node head4 = new Node(1);

		head.random = null;
		head1.random = head;
		head2.random = head4;
		head3.random = head2;
		head4.random = head;
		
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = null;
		
		return head;
	}

}
