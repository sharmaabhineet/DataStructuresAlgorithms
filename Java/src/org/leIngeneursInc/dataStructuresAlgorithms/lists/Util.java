/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.lists;

import java.util.Comparator;

/**
 * Utility class containing utility functions pertaining to lists and list nodes
 * 
 * @author Abhineet ( sharma.abhineet31@gmail.com )
 *
 */
public class Util {

	/**
	 * Returns the last node pointed to by the start node. Time Complexity :
	 * O(n) Space Complexity : O(1)
	 * 
	 * @param startNode
	 *            the node from where to start
	 * @return the last node referred to by the list starting from startNode
	 */
	public static <T> ListNode<T> getLastNode(ListNode<T> startNode) {
		if (startNode == null) {
			return null;
		} else {
			// do nothing here. go ahead
		}

		ListNode<T> travNode = startNode;
		while (travNode.getNext() != null) {
			travNode = travNode.getNext();
		}

		return travNode;
	}
	
	/**
	 * Returns the reference to the node referring to the node containing given
	 * value, starting from the list pointed to by the startingPoint. 
	 * 
	 * @param val
	 *            the value that has to be searched
	 * @param listNode
	 *            the starting node from where the search has to be made. 
	 * @return the node containing the value. Null Otherwise, if the value is not
	 *         found or list is empty or has just one element
	 */
	public static<T> ListNode<T> findNode(T val, ListNode<T> startingPoint){
		if (val == null) {
			throw new IllegalArgumentException("Value can not be null");
		} else if (startingPoint == null ) {
			return null;
		} else {
			// do nothing here. go ahead.
		}
		while (startingPoint != null && !(val.equals(startingPoint.getVal()))) {
			startingPoint = startingPoint.getNext();
		}
		return startingPoint;
	}
	
	/**
	 * Returns the reference to the node referring to the node containing given
	 * value, starting from the list pointed to by the listNode. One corner case
	 * that must be taken care while using this method is that when there is
	 * only one node i.e. listNode does not point to any other node, then the
	 * this method returns null. It should be explicitly handled.
	 * 
	 * @param val
	 *            the value that has to be searched
	 * @param listNode
	 *            the starting node from where the search has to be made
	 * @return the node containing the value. Null Othewise, if the value is not
	 *         found or list is empty or has just one element
	 */
	public static <T> ListNode<T> findNodeBeforeVal(T val, ListNode<T> listNode) {
		if (val == null) {
			throw new IllegalArgumentException("Value can not be null");
		} else if (listNode == null || listNode.getNext() == null) {
			return null;
		} else {
			// do nothing here. go ahead.
		}

		while (listNode.getNext() != null && !(val.equals(listNode.getNext().getVal()))) {
			listNode = listNode.getNext();
		}
		return listNode;
	}

	/**
	 * Detect cycle in a linked list. Returns boolean value indicating whether
	 * or not a cycle exists. Time Complexity : O(n) Algorithm : 1. Declare a
	 * slowPtr that moves single node at a time 2. Declare a fastPtr that moves
	 * two nodes at a time 3. Until FastPtr != null, do a. Check if slowPtr ==
	 * fastPtr, Return TRUE b. slowPtr = slowPtr.next // Move slow pointer fwd
	 * one space c. fastPtr = fastPtr.next.next // move fast pointer fwd two
	 * spaces 4. Return False. // If fast pointer reaches end of list. No Cycles
	 * 
	 * @param list
	 *            in which cycle has to be detected
	 * @return boolean value whether or not a cycle is present
	 */
	public static <T> boolean hasCycle(LinkedList<T> list) {
		ListNode<T> slowPtr = list.getHead();
		if (slowPtr == null || slowPtr.getNext() == null) {
			return false;
		} else {
			// do nothin ghere go ahead
		}

		ListNode<T> fastPtr = slowPtr.getNext();
		while (fastPtr != null) {
			if (slowPtr == fastPtr) {
				return true;
			}
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext();
			if (fastPtr != null) {
				fastPtr = fastPtr.getNext();
			}
		}
		return false;
	}
	
	/**
	 * Detects if a loop is present and returns the start of the loop.
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 * Algorithm:
	 * 1. Use two pointers to iterate the list. slowPtr moves one step
	 * 		at a time. fastPtr moves two at a time. 
	 * 2. while(slowPtr != fastPtr), do
	 * 		a. Move fastPtr two steps. If no such move possible, Return null. 
	 * 				<NO CYCLE EXISTS>
	 * 		b. Move slowPtr on step
	 *	// If code reaches here. Cycle has been detected. It can be proved 
	 * 	// mathematically that both the pointers and the start of the list are 
	 *  // some K steps away from the start of the loop.
	 *  3. slowPtr = start
	 *  4. int k = 0   // Just in case you wanna count the steps before the loop starts.
	 *  4. While(slowPtr != fastPtr), do
	 *  		a. slowPtr = slowPtr->next
	 *  		b. fastPtr = fastPtr->next
	 *  		c. k++
	 *  5. return slowPtr  // start of the loop is k steps away from the start
	 *  
	 * @param list the input linked list
	 * @return the start of the cycle in the linked list, null if there is no cycle
	 */
	public static <T> ListNode<T> findStartOfLoop(LinkedList<T> list){
		ListNode<T> slowPtr = list.getHead();
		ListNode<T> fastPtr = list.getHead();
		// If either the list is empty or first node points to no other 
		// node, there is no cycle.
		if(slowPtr == null || slowPtr.getNext() == null){
			return null;
		}else{
			//do nothing here. go ahead.
		}
		while(fastPtr != null && fastPtr.getNext() != null){
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
			if(fastPtr == slowPtr){
				break;
			}
		}
		//Check for possibility of no cycle, as there exists one according to the while loop above.
		if(fastPtr == null || fastPtr.getNext() == null){
			return null;
		}
		// If the code reaches here. There is definitely a cycle in the list.
		slowPtr = list.getHead();
		while(slowPtr != fastPtr){
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext();
		}
		return fastPtr;
	}

	/**
	 * Swaps nodes in pairs. For E.g. 1 -> 2 -> 3 -> 4 , after swap returns 2 ->
	 * 1 -> 4 -> 3 Time complexity : O(n) This method makes changes to the same
	 * list passed as input.
	 * 
	 * @param list
	 *            input list whose nodes are to be swapped
	 * @return the list with the swapped nodes.
	 */
	public static <T> LinkedList<T> swapPairs(LinkedList<T> list) {
		ListNode<T> head = list.getHead();
		if (head == null || head.getNext() == null) {
			return list;
		} else {
			// do nothing go ahead.
		}
		ListNode<T> a = head;
		ListNode<T> b = head.getNext();
		ListNode<T> c = b.getNext();
		list.setHead(b);
		while (c != null) {
			b.setNext(a);
			if (c.getNext() != null) {
				a.setNext(c.getNext());
			} else {
				a.setNext(c);
			}
			a = c;
			b = c.getNext();
			if (b == null) {
				return list;
			} else {
				c = b.getNext();
			}
		}
		b.setNext(a);
		a.setNext(null);
		return list;
	}

	
	/**
	 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
	 * You should preserve the original relative order of the nodes in each of the two partitions.
	 * 
	 * For example,
	 * Given 1->4->3->2->5->2 and x = 3,
	 * return 1->4->2->2->3->5.
	 * 
	 * This problem is listed on Leet code : 	https://leetcode.com/problems/partition-list/
	 * 
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 * 
	 * @param list the linked list that has to partition
	 * @param val value of the node stated as x in the problem
	 * @param comparator a comparator to compare two nodes
	 * @return
	 */
	public static <T> LinkedList<T> partition(LinkedList<T> list, T val, Comparator<T> comparator) {
		if(list == null){
			return list;
		}
		ListNode<T> head = list.getHead();
		if (head == null || head.getNext() == null) {
			return list;
		} else {
			// do nothing
		}

		// Find the position after which replace has to be made
		
		//to store the value if the replacement has to be done 
		boolean isRepAtHead = false;
		ListNode<T> rep = null;
		ListNode<T> scan = null;
		int compVal = comparator.compare(head.getVal(), val);
		if (compVal >= 0) {
			isRepAtHead = true;
			scan = head;
		} else {
			ListNode<T> slow = head;
			ListNode<T> fast = head.getNext();
			while (fast != null) {
				int compSlowVal = comparator.compare(slow.getVal(), val);
				int compFastVal = comparator.compare(fast.getVal(), val);
				if (compSlowVal < 0 && compFastVal >= 0) {
					break;
				} else {
					// continue
				}
				slow = fast;
				fast = fast.getNext();
			}
			if (fast == null) {
				// there is nothing to be modified
				return list;
			} else {
				rep = slow;
				scan = fast;
			}
		}
		//Scanning the rest of the list for replacement of the nodes.
		while (scan.getNext() != null) {
			int compScanVal = comparator.compare(scan.getNext().getVal(), val);
			if (compScanVal >= 0) {
				scan = scan.getNext();
			} else {
				if (isRepAtHead) {
					ListNode<T> temp = scan.getNext().getNext();
					scan.getNext().setNext(head);
					head = scan.getNext();
					scan.setNext(temp);
					rep = head;
					isRepAtHead = false;
				} else {
					ListNode<T> temp = scan.getNext().getNext();
					scan.getNext().setNext(rep.getNext());
					rep.setNext(scan.getNext());
					scan.setNext(temp);
					rep = rep.getNext();
				}
			}
		}
		list.setHead(head);
		return list;
	}
	
	/**
	 * Reverses the list in place
	 * Time complexity : O(n)
	 * Space complexity : O(1)
	 * Uses the classic algorithm using three pointers and swapping next pointers in place.
	 * @param list the linked list that needs to be reversed
	 */
	public static <T> void reverse(LinkedList<T> list){
		if(list == null || list.isEmpty()){
			return;
		}else{
			//do nothing here. go ahead.
		}
		// Using three pointers a, b, c 
		// Sequence remains invariant that is a points to b points to c ( a -> b -> c )
		ListNode<T> a = list.getHead();
		if(a == null || a.getNext() == null){
			return;
		}else{
			//do nothing here. go ahead
		}
		
		ListNode<T> b = a.getNext();
		// If only two nodes reverse it manually as a special case
		if(b.getNext() == null){
			b.setNext(a);
			a.setNext(null);
			list.setHead(b);
			return;
		}else{
			//do nothing here. go ahead
		}
		
		ListNode<T> c = b.getNext();
		while(b.getNext() != null){
			b.setNext(a);
			a = b;
			b = c;
			if(c != null){
				c = c.getNext();
			}else{
				//do nothing here. carry on, while loop wud take care of the rest
			}
		}
		//Need to reverse the last node after the loop ends.
		b.setNext(a);
		list.getHead().setNext(null);
		list.setHead(b);
	}
	
	/**
	 * Paritions the list such that all the nodes less than the given value 
	 * are on the left, followed by all the nodes with the same value (if present)
	 * followed by all the nodes with greater value than the given value. This function 
	 * also preserves the order of the node insertion. It does in place swaps.
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 * Variation of CTCI Linked list question
	 * @param list Given list 
	 * @param val value around which partitioning is to be done
	 * @param comp comparator to compare all the values.
	 */
	public static<T> void partitionSeparately(LinkedList<T> list, T val, Comparator<T> comp){
		if(list == null || list.isEmpty() || val == null){
			return;
		}else if(comp == null){
			throw new IllegalArgumentException("Comparator must not be null");
		}else{
			//do nothing here. We got work to do.
		}
		
		//O(1) space allocation
		ListNode<T> smallList = null;
		ListNode<T> smallListEnd = null;
		ListNode<T> sameList = null;
		ListNode<T> sameListEnd = null;
		ListNode<T> largeList = null;
		ListNode<T> largeListEnd = null;
		
		ListNode<T> travNode = list.getHead();
		while(travNode != null){
			T nodeVal = travNode.getVal();
			int compVal = comp.compare(nodeVal, val);
			if(compVal < 0){
				if(smallList == null){
					smallList = smallListEnd = travNode;
				}else{
					smallListEnd.setNext(travNode);
					smallListEnd = travNode;
				}
			} else if (compVal > 0){
				if(largeList == null){
					largeList = largeListEnd = travNode;
				}else{
					largeListEnd.setNext(travNode);
					largeListEnd = travNode;
				}
			} else{
				if(sameList == null){
					sameList = sameListEnd = travNode;
				}else{
					sameListEnd.setNext(travNode);
					sameListEnd = travNode;
				}
			}
			
			travNode = travNode.getNext();
		}

		// Re-arraging the pointers
		if(largeListEnd != null){
			largeListEnd.setNext(null);
		}else{
			if(sameListEnd != null){
				sameListEnd.setNext(null);
			}else{
				//Because there is atleast one node in the list
				smallListEnd.setNext(null);
			}
		}
		
		
		//First of all re-arranging the head of the list
		if(smallList != null){
			list.setHead(smallList);
			if(sameList != null){
				smallListEnd.setNext(sameList);
				sameListEnd.setNext(largeList);
			}else{
				smallListEnd.setNext(largeList);
			}
		} else{
			if(sameList != null){
				list.setHead(sameList);
				if(largeList != null){
					sameListEnd.setNext(largeList);
				}else{
					//do nothing here.
				}
			} else{
				//Because we know there is atleast one node present.
				list.setHead(largeList);
			}
		}
		
	}
	
}
