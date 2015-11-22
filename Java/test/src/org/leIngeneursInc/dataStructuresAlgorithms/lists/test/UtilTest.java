/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.lists.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.leIngeneursInc.dataStructuresAlgorithms.lists.LinkedList;
import org.leIngeneursInc.dataStructuresAlgorithms.lists.ListNode;
import org.leIngeneursInc.dataStructuresAlgorithms.lists.Util;

/**
 * Contains JUnit test cases for the linked list utility class
 * 
 * @author Abhineet ( sharma.abhineet31@gmail.com )
 */
public class UtilTest {

	private static final LinkedList<Integer> getIntegerLinkedList(int size) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= size; i++) {
			list.insert(new ListNode<Integer>(i));
		}
		return list;
	}

	@Test
	public void test_hasCycle_EmptyList() {
		LinkedList<Integer> list = getIntegerLinkedList(0);
		assertFalse("Empty List must not have any cycle", Util.hasCycle(list));
	}

	@Test
	public void test_hasCycle_SingleNodeNoCycle() {
		LinkedList<Integer> list = getIntegerLinkedList(1);
		assertFalse("Linked List with no cycle and one node", Util.hasCycle(list));
	}

	@Test
	public void test_hasCycle_SingleNodeWithCycle() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(new ListNode<Integer>(1));
		list.getHead().setNext(list.getHead());
		assertTrue("Linked List with cycle and one node", Util.hasCycle(list));
	}

	@Test
	public void test_hasCycle_NoCycle() {
		LinkedList<Integer> list = getIntegerLinkedList(10);
		assertFalse("Linked List with no cycle and one node", Util.hasCycle(list));
	}

	@Test
	public void test_hasCycle_CyclicList_BasicAtRandomPlacementSmallList() {
		// Generating a linked list with cycle
		LinkedList<Integer> list = new LinkedList<Integer>();
		ListNode<Integer> nodeForCycle = null;
		int size = 10;
		// Adding 1 to index because i starts with 1
		int cycleIndex = (int) (Math.random() * size) + 1;
		for (int i = 1; i <= size; i++) {
			if (i == cycleIndex) {
				nodeForCycle = new ListNode<Integer>(i);
				list.insert(nodeForCycle);
			} else {
				list.insert(new ListNode<Integer>(i));
			}
		}
		list.getLastNode().setNext(nodeForCycle);
		assertTrue("Cyclic List with last node pointing to node at index : " + (cycleIndex - 1), Util.hasCycle(list));
	}

	@Test
	public void test_hasCycle_CyclicList_RandomPlacementListsOfRandomSize() {
		int NUM_ITERS = 10;
		int MAX_SIZE = 500;
		// Generating a linked list with cycle
		LinkedList<Integer> list = new LinkedList<Integer>();
		ListNode<Integer> nodeForCycle = null;
		for (int iter = 0; iter < NUM_ITERS; iter++) {
			int size = (int) (Math.random() * MAX_SIZE) + 1;
			// Adding 1 to index because i starts with 1
			int cycleIndex = (int) (Math.random() * size) + 1;
			for (int i = 1; i <= size; i++) {
				if (i == cycleIndex) {
					nodeForCycle = new ListNode<Integer>(i);
					list.insert(nodeForCycle);
				} else {
					list.insert(new ListNode<Integer>(i));
				}
			}
			list.getLastNode().setNext(nodeForCycle);
			assertTrue("Cyclic List with last node pointing to node at index : " + (cycleIndex - 1),
					Util.hasCycle(list));
		}
	}
	
	@Test
	public void test_swapPairs_EmptyList(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list = Util.swapPairs(list);
		assertNotNull(list);
		assertTrue("Expecting an empty list after swapParis on an empty list", list.isEmpty());
	}
	
	@Test
	public void test_swapPairs_SingleNode(){
		LinkedList<Integer> list = getIntegerLinkedList(1);
		list = Util.swapPairs(list);
		assertNotNull(list);
		int[] arrExpectedValues = new int[]{1};
		ListNode<Integer> head = list.getHead();
		for(int expected : arrExpectedValues){
			assertEquals(expected, head.getVal().intValue());
			head = head.getNext();
		}
		assertNull(head);
	}
	
	@Test
	public void test_swapPairs_TwoNodes(){
		LinkedList<Integer> list = getIntegerLinkedList(2);
		list = Util.swapPairs(list);
		assertNotNull(list);
		int[] arrExpectedValues = new int[]{2,1};
		ListNode<Integer> head = list.getHead();
		for(int expected : arrExpectedValues){
			assertEquals(expected, head.getVal().intValue());
			head = head.getNext();
		}
		assertNull(head);
	}
	
	@Test
	public void test_swapPairs_ThreeNodes(){
		LinkedList<Integer> list = getIntegerLinkedList(3);
		list = Util.swapPairs(list);
		assertNotNull(list);
		int[] arrExpectedValues = new int[]{2,1,3};
		ListNode<Integer> head = list.getHead();
		for(int expected : arrExpectedValues){
			assertEquals(expected, head.getVal().intValue());
			head = head.getNext();
		}
		assertNull(head);
	}
	
	@Test
	public void test_swapPairs_FourNodes(){
		LinkedList<Integer> list = getIntegerLinkedList(4);
		list = Util.swapPairs(list);
		assertNotNull(list);
		int[] arrExpectedValues = new int[]{2,1, 4, 3};
		ListNode<Integer> head = list.getHead();
		for(int expected : arrExpectedValues){
			assertEquals(expected, head.getVal().intValue());
			head = head.getNext();
		}
		assertNull(head);
	}
	
	@Test
	public void test_swapPairs_ListOf10Nodes(){
		LinkedList<Integer> list = getIntegerLinkedList(10);
		list = Util.swapPairs(list);
		assertNotNull(list);
		int[] arrExpectedValues = new int[]{2,1, 4,3, 6,5, 8, 7, 10, 9};
		ListNode<Integer> head = list.getHead();
		for(int expected : arrExpectedValues){
			assertNotNull(head);
			assertEquals(expected, head.getVal().intValue());
			head = head.getNext();
		}
		assertNull(head);
	}

}
