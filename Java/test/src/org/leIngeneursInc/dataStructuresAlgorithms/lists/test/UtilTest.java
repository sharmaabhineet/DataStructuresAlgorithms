/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.lists.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;

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
	public void test_findStartOfLoop_EmptyList(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		assertNull("Empty List must return null", Util.findStartOfLoop(list));
	}
	
	@Test
	public void test_findStartOfLoop_AcyclicList(){
		LinkedList<Integer> list = getIntegerLinkedList(10);
		assertNull("Acyclic List must return null", Util.findStartOfLoop(list));
	}
	
	@Test
	public void test_findStartOfLoop_CyclicList_FixedSmall(){
		LinkedList<Integer> list = getIntegerLinkedList(11);
		// Creating cycle at fifth node
		ListNode<Integer> lastNode = list.getHead();
		while(lastNode.getNext() != null){
			lastNode = lastNode.getNext();
		}
		ListNode<Integer> cyclicNode = list.getHead();
		for(int i = 0 ; i < 3 ; i ++){
			cyclicNode = cyclicNode.getNext();
		}
		lastNode.setNext(cyclicNode);
		System.out.println("Cycle at Value : " +cyclicNode.getVal());
		Util.findStartOfLoop(list);
	}
	
	@Test
	public void test_findStartOfLoop_CyclicList_RandomPlacementListsOfRandomSize() {
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
			assertEquals("Cyclic List with last node pointing to node at index : " + (cycleIndex - 1),
					nodeForCycle, Util.findStartOfLoop(list));
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
	
	private static final Comparator<Integer> getIntegerComparator(){
		return new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1.intValue() > o2.intValue()){
					return 1;
				} else if ( o1.intValue() == o2.intValue()){
					return 0;
				} else{
					return -1;
				}
			}
		};
	}
	
	@Test
	public void test_partition_EmptyList(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list = Util.partition(list, 0, getIntegerComparator());
		assertNotNull(list);
		//Expecting the head to be null
		assertNull(list.getHead());
		assertTrue(list.isEmpty());
	}

	@Test
	public void test_partition_SingleNode(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(new ListNode<Integer>(1));
		list = Util.partition(list, 0, getIntegerComparator());
		assertNotNull(list);
		//Expecting the head to be null
		assertNotNull(list.getHead());
		assertNull(list.getHead().getNext());
		assertEquals(1, list.getHead().getVal().intValue());
	}
	
	@Test
	public void test_partition_CornerCase1(){
		String assertFailTestMsg = "Fails for Input : list = [1,1] ; val = 0";
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(new ListNode<Integer>(1));
		list.insert(new ListNode<Integer>(1));
		list = Util.partition(list, 0, getIntegerComparator());
		assertNotNull(list);
		//Expecting the head to be null
		assertNotNull(assertFailTestMsg, list.getHead());
		int[] arr = new int[]{1,1};
		ListNode<Integer> trav = list.getHead();
		for(int i : arr){
			assertEquals(assertFailTestMsg, i, trav.getVal().intValue());
			trav = trav.getNext();
		}
		assertNull(assertFailTestMsg, trav);
	}
	
	@Test
	public void test_partition_CornerCase2(){
		String assertFailTestMsg = "Fails for Input : list = [1,1] ; val = 2";
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(new ListNode<Integer>(1));
		list.insert(new ListNode<Integer>(1));
		list = Util.partition(list, 0, getIntegerComparator());
		assertNotNull(list);
		//Expecting the head to be null
		assertNotNull(assertFailTestMsg, list.getHead());
		int[] arr = new int[]{1,1};
		ListNode<Integer> trav = list.getHead();
		for(int i : arr){
			assertEquals(assertFailTestMsg, i, trav.getVal().intValue());
			trav = trav.getNext();
		}
		assertNull(assertFailTestMsg, trav);
	}
	
	@Test
	public void test_partition_Case1(){
		String assertFailTestMsg = "Fails for Input : list = [1,4,3,2,5,2] ; val = 3";
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(new ListNode<Integer>(1));
		list.insert(new ListNode<Integer>(4));
		list.insert(new ListNode<Integer>(3));
		list.insert(new ListNode<Integer>(2));
		list.insert(new ListNode<Integer>(5));
		list.insert(new ListNode<Integer>(2));
		list = Util.partition(list, 3, getIntegerComparator());
		assertNotNull(list);
		//Expecting the head to be null
		assertNotNull(assertFailTestMsg, list.getHead());
		int[] arr = new int[]{1,2,2,4,3,5};
		ListNode<Integer> trav = list.getHead();
		for(int i : arr){
			assertEquals(assertFailTestMsg, i, trav.getVal().intValue());
			trav = trav.getNext();
		}
		assertNull(assertFailTestMsg, trav);
	}
	
	@Test
	public void test_partition_Case2(){
		String assertFailTestMsg = "Fails for Input : list = [4,1,4,3,2,5,2] ; val = 3";
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(new ListNode<Integer>(4));
		list.insert(new ListNode<Integer>(1));
		list.insert(new ListNode<Integer>(4));
		list.insert(new ListNode<Integer>(3));
		list.insert(new ListNode<Integer>(2));
		list.insert(new ListNode<Integer>(5));
		list.insert(new ListNode<Integer>(2));
		list = Util.partition(list, 3, getIntegerComparator());
		assertNotNull(list);
		//Expecting the head to be null
		assertNotNull(assertFailTestMsg, list.getHead());
		int[] arr = new int[]{1,2,2,4,4,3,5};
		ListNode<Integer> trav = list.getHead();
		for(int i : arr){
			assertEquals(assertFailTestMsg, i, trav.getVal().intValue());
			trav = trav.getNext();
		}
		assertNull(assertFailTestMsg, trav);
	}
	
	@Test
	public void test_partition_Case3(){
		String assertFailTestMsg = "Fails for Input : list = [4,1,4,3,-1,2,5,2] ; val = 3";
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(new ListNode<Integer>(4));
		list.insert(new ListNode<Integer>(1));
		list.insert(new ListNode<Integer>(4));
		list.insert(new ListNode<Integer>(3));
		list.insert(new ListNode<Integer>(-1));
		list.insert(new ListNode<Integer>(2));
		list.insert(new ListNode<Integer>(5));
		list.insert(new ListNode<Integer>(2));
		list = Util.partition(list, 3, getIntegerComparator());
		assertNotNull(list);
		//Expecting the head to be null
		assertNotNull(assertFailTestMsg, list.getHead());
		int[] arr = new int[]{1,-1,2,2,4,4,3,5};
		ListNode<Integer> trav = list.getHead();
		for(int i : arr){
			assertEquals(assertFailTestMsg, i, trav.getVal().intValue());
			trav = trav.getNext();
		}
		assertNull(assertFailTestMsg, trav);
	}
}
