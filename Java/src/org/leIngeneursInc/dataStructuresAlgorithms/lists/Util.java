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
}
