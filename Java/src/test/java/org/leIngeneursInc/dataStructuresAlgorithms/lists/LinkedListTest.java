package org.leIngeneursInc.dataStructuresAlgorithms.lists;

import static org.junit.Assert.*;

import org.junit.Test;
import org.leIngeneursInc.dataStructuresAlgorithms.lists.LinkedList;
import org.leIngeneursInc.dataStructuresAlgorithms.lists.ListNode;

public class LinkedListTest {
	
	private static final LinkedList<Integer> getIntegerLinkedList(int size){
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i =1; i <= size; i++){
			list.insert(new ListNode<Integer>(i));
		}
		return list;
	}

	@Test
	public void testLinkedListBasic() {
		int size = 10;
		LinkedList<Integer> list = getIntegerLinkedList(size);
		ListNode<Integer> trav = list.getHead();
		int i = 1;
		while(trav != null){
			assertEquals(i, trav.getVal().intValue());
			i++;
			trav = trav.getNext();
		}
		//Because of the i++ inside, after traversing 
		// through a list of size 10, i would be 11
		assertEquals(size + 1, i);;
	}

	@Test
	public void testSetHead() {
		LinkedList<Integer> list = getIntegerLinkedList(10);
		LinkedList<Integer> list2 = getIntegerLinkedList(20);
		list.setHead(list2.getNthNodeFromStart(0));
		
	}

	@Test
	public void testIsEmpty_emptyList() {
		LinkedList<Integer> list = getIntegerLinkedList(0);
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testIsEmpty_nonEmptyList() {
		LinkedList<Integer> list = getIntegerLinkedList(10);
		assertFalse(list.isEmpty());
	}

	@Test
	public void testInsert_oneElement() {
		LinkedList<Integer> list = getIntegerLinkedList(0);
		ListNode<Integer> headNode = new ListNode<Integer>(1);
		list.insert(headNode);
		assertEquals(headNode, list.getHead());
		assertEquals(1, list.getHead().getVal().intValue());
	}
	
	@Test
	public void testInsert_10ElementList(){
		LinkedList<Integer> list = getIntegerLinkedList(0);
		ListNode<Integer> lastNode = new ListNode<Integer>(1);
		list.insert(lastNode);
		ListNode<Integer> trav = list.getHead();
		while(trav.getNext() != null){
			trav = trav.getNext();
		}
		assertEquals(lastNode, trav);
		assertEquals(1, trav.getVal().intValue());
	}
	
	@Test
	public void testGetHead(){
		LinkedList<Integer> list = getIntegerLinkedList(0);
		ListNode<Integer> headNode = new ListNode<Integer>(1);
		list.insert(headNode);
		assertEquals(headNode, list.getHead());
	}
	

	@Test
	public void testDelete() {
		LinkedList<Integer> list = getIntegerLinkedList(10);
		list.delete(5);
		ListNode<Integer> trav = list.getHead();
		while(trav != null){
			if(trav.getVal() == 5){
				assertTrue("Expecting value 5 to be not present in the list", false);
			}
			trav = trav.getNext();
		}
		
		//Testing for presence of other values as well
		list = getIntegerLinkedList(10);
		list.delete(5);
		trav = list.getHead();
		for(int i = 1; i <= 10; i++){
			if(i == 5){
				//because we already know that 5 is gone
				continue;
			} else{
				assertEquals(i, trav.getVal().intValue());
			}
			trav = trav.getNext();
		}
		assertNull(trav);
	}

}
