/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.lists;

/**
 * Utility class containing utility functions pertaining to lists and list nodes 
 * @author Abhineet ( sharma.abhineet31@gmail.com )
 *
 */
public class Util {
	
	/**
	 * Returns the last node pointed to by the start node.
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 * @param startNode the node from where to start 
	 * @return the last node referred to by the list starting from startNode
	 */
	public static<T> ListNode<T> getLastNode(ListNode<T> startNode){
		if(startNode == null){
			return null;
		} else {
			//do nothing here. go ahead
		}
		
		ListNode<T> travNode = startNode;
		while(travNode.getNext() != null ){
			travNode = travNode.getNext();
		}
		
		return travNode;
	}
	
	/**
	 * Returns the reference to the node referring to the node containing given value, starting from the list pointed to by the listNode.
	 * One corner case that must be taken care while using this method is that when there is only one node i.e. listNode does not point to any 
	 * other node, then the this method returns null. It should be explicitly handled.
	 * @param val the value that has to be searched
	 * @param listNode the starting node from where the search has to be made
	 * @return the node containing the value. Null Othewise, if the value is not found or list is empty or has just one element
	 */
	public static<T> ListNode<T> findNodeBeforeVal(T val, ListNode<T> listNode){
		if ( val == null){
			throw new IllegalArgumentException("Value can not be null");
		}else if(listNode == null || listNode.getNext() == null){
			return null;
		} else {
			//do nothing here. go ahead.
		}
		
		while(listNode.getNext() != null && !(val.equals(listNode.getNext().getVal()))){
			listNode = listNode.getNext();
		}
		return listNode;
	}
	
	/**
	 * Detect cycle in a linked list. Returns boolean value indicating whether or not a cycle exists.
	 * Time Complexity : O(n)
	 * Algorithm : 
	 * 		1. Declare a slowPtr that moves single node at a time
	 * 		2. Declare a fastPtr that moves two nodes at a time
	 * 		3. Until FastPtr != null, do
	 * 				a. Check if slowPtr == fastPtr, Return TRUE
	 * 				b. slowPtr = slowPtr.next		// Move slow pointer fwd one space
	 * 				c. fastPtr = fastPtr.next.next		// move fast pointer fwd two spaces
	 * 		4. Return False. 			// If fast pointer reaches end of list. No Cycles
	 * @param list in which cycle has to be detected
	 * @return boolean value whether or not a cycle is present
	 */
	public static<T> boolean hasCycle(LinkedList<T> list){
		ListNode<T> slowPtr = list.getHead();
		if(slowPtr == null || slowPtr.getNext() == null){
            return false;
        } else{
            //do nothin ghere go ahead
        }
        
        ListNode<T> fastPtr = slowPtr.getNext();
        while(fastPtr != null){
            if(slowPtr == fastPtr){
                return true;
            }
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext();
            if(fastPtr != null){
                fastPtr = fastPtr.getNext();
            }
        }
        return false;
	}
	
	/**
	 * Swaps nodes in pairs.
	 * For E.g. 1 -> 2 -> 3 -> 4 , after swap returns
	 * 			2 -> 1 -> 4 -> 3
	 * Time complexity : O(n)
	 * This method makes changes to the same list passed as input.
	 * @param list input list whose nodes are to be swapped
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
}
