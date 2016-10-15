/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.lists;

/**
 * Generic class representing a Linked List Node
 * @author Abhineet (sharma.abhineet31@gmail.com)
 * 
 * @param <T> Class for the value type of the List Node
 */
public class ListNode<T> {
	/**
	 * Stores the value of the node
	 */
	private T val;
	
	
	/**
	 * Returns value of the node
	 * @return value of the node
	 */
	public T getVal(){
		return val;
	}
	
	/**
	 * Stores the reference to the next node in the list
	 */
	private ListNode<T> next; 
	
	/**
	 * Getter for the reference to the next node to this list node
	 * @return the reference to the next node in the list
	 */
	public ListNode<T> getNext(){
		return next;
	}
	
	
	/**
	 * Setter for the next refence to the next node to this list node
	 * @param next reference to the next node to this list node
	 */
	public void setNext(ListNode<T> next){
		this.next = next;
	}
	
	/**
	 * Constructor for the list node. 
	 * @param val value for the list node. (Cannot be null). Throws IllegalArgumentException if val is null.
	 */
	public ListNode(T val){
		if( val == null){
			throw new IllegalArgumentException("Value can not be null");
		} else {
			//do nothing here. go ahead
		}
		this.val = val;
		this.next = null;
	}
	
	/**
	 * Constructor for list node
	 * @param val value for this list node ( cannot be null). Throws IllegalArgumentException if val is null.
	 * @param next Reference to the next List Node for this list node.
	 */
	public ListNode(T val, ListNode<T> next){
		this(val);
		this.next = next;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		return val.hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "Node[ " +val.toString() +" ] Has Next() ? : " +(next != null);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj){
		if( obj instanceof ListNode){
			// Since we are calling equals method on the val, therefore
			// it does not matter to check explicitly for ListNode<T>
			@SuppressWarnings("rawtypes")
			ListNode node = (ListNode) obj;
			return this.val.equals(node.getVal());
		} else{
			return false;
		}
	}
}
