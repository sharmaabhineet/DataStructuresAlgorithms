/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.lists;

/**
 * Generic Class for LinkedList
 * @author Abhineet (sharma.abhineet31@gmail.com)
 *
 * @param <T> Generic representing the value type for the list
 */
public class LinkedList<T> {
	/**
	 * Reference to the head of the linked list.
	 */
	private ListNode<T> head;
	
	
	/**
	 * Reference to the end of linked list. To save some computational costs.
	 */
	private ListNode<T> end;
	
	
	/**
	 * Default constructor for the list. Head points to none.
	 */
	public LinkedList(){
		this.head = null;
		this.end = null;
	}
	
	/**
	 * Intialize the list with another list or a single node.
	 * Time Complexity: O(n) , where n is the number of nodes that can be reached from head
	 * Space Complexity : O(1)
	 * @param head reference to another node or a head of another list
	 */
	public LinkedList(ListNode<T> head){
		setHead(head);
	}
	
	/**
	 * Set reference to the head of the list to a new head.
	 * @param head the new head of the linked list
	 */
	public void setHead(ListNode<T> head){
		this.head = head;
		this.end = this.getLastNode();
	}
	
	/**
	 * Returns boolean value indicating whether or not the list is empty
	 * @return boolean value indicating whether or not the list is empty.
	 */
	public boolean isEmpty(){
		return head == null;
	}
	
	
	/**
	 * Insert a node at the end of the list
	 * Best & Average Case Time Complexity : O(1)
	 * Time Complexity : O(n) , where node is not a single node rather a list and n = length of that list
	 * Space Complexity : O(1)
	 * @param node
	 */
	public void insert(ListNode<T> node){
		if(head == null){
			setHead(node);
			return;
		} else{
			//do nothing here.
		}
		
		end.setNext(node);
		end = Util.getLastNode(node);
	}
	
	/**
	 * Delete the node containing a given value in the list
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 * @param val the value that has to be deleted from the list
	 * @return the node that was deleted from the list.
	 */
	public ListNode<T> delete(T val){
		if (val == null ){
			throw new IllegalArgumentException("Val can not be null");
		} else if (head == null ){
			return null;
		}else {
			//do nothing here. go ahead
		}
		
		//Check beforehand if there is only one element in the lsit
		//If yes, explicitly check for the value and process accordingly
		if(head.getNext() == null){ 
			if(val.equals(head.getVal())){
				ListNode<T> retVal = head;
				head = null;
				end = null;
				return retVal;
			} else {
				return null;
			}
		} else { 
			//do nothing here. go ahead.
		}
		
		//Following function returns null in case the value is not found
		// or the list is empty or list has only one node. all the cases have been taken care 
		// of by the if blocks above. The only case nodePtr will be null here
		// is when the vlaue is not found.
		ListNode<T> nodePtr = Util.findNodeBeforeVal(val, head);
		if(nodePtr == null){
			// Implies the value was not found. Return null
			return null;
		} else {
			//do nothing here. go ahead and set the pointers accordingly.
		}
		
		ListNode<T> retVal = nodePtr.getNext();
		nodePtr.setNext(retVal.getNext());
		// if the node to be deleted was the last one of the list
		// then we need to reset the end pointer as well.
		if(nodePtr.getNext() == null){
			this.end = nodePtr;
		} else {
			//do nothing here. we are done.
		}
		return retVal;
	}
	
	
	/**
	 * Returns the last node of the linked list
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 * @return the reference to the last node
	 */
	public ListNode<T> getLastNode(){
		return Util.getLastNode(head);
	}
	
	/**
	 * Returns the reference to node before the given node & Null otherwise. It checks for the exact same reference
	 * and does not compare the nodes just by values.
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 * @param node the node that has to be located in the linked list.
	 * @return the reference to the node before the given node in the list. Null, otherwise.
	 */
	public ListNode<T> getNodeBefore(ListNode<T> node){
		if(head == null){
			return null;
		} else {
			//do nothing here. go ahead
		}
		
		ListNode<T> travNode = head;
		while(travNode != null && travNode != node){
			travNode = travNode.getNext();
		}
		return travNode;
	}
	
	/**
	 * Returns the reference to the nth node from the start. n = 0 implies head of the list
	 * Time Complexity : O(n)
	 * Space Complexity : O(1) 
	 * @param n index value representing the nth node from the start. Throws IllegalArgumentException if n is negative.
	 * @return the reference value to the nth node from the start. 
	 */
	public ListNode<T> getNthNodeFromStart(long n){
		if( n < 0 ){
			throw new IllegalArgumentException("n can not be negative");
		} else if(head == null){
			return null;
		} else{ 
			//do nothing here. go ahead.
		}
		
		ListNode<T> travNode = head;
		while(travNode != null && --n >= 0){
			travNode = travNode.getNext();
		}
		
		return travNode;
	}
	
	
	/**
	 * Returns the reference to the nth node from end if it exists. Null otherwise
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 * @param n the index representing the nth node from the end of the list. Throws IllegalArgumentException if n < 0.
	 * @return the reference to the nth node from the end of the list. Null otherwise 
	 */
	public ListNode<T> getNthNodeFromEnd(long n){
		if( n < 0 ){
			throw new IllegalArgumentException("n can not be negative");
		} else if(head == null){
			return null;
		} else{ 
			//do nothing here. go ahead.
		}
		
		ListNode<T> fastPtr = getNthNodeFromStart(n);
				
		if(fastPtr == null){
			return null;
		} else{ 
			//do nothing here. go ahead
		}
		ListNode<T> slowPtr = head;
		while(fastPtr.getNext() != null){
			fastPtr = fastPtr.getNext();
			slowPtr = slowPtr.getNext();
		}
		return slowPtr;
	}
}
