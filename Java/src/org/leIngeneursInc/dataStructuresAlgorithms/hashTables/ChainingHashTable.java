/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.hashTables;

import org.leIngeneursInc.dataStructuresAlgorithms.lists.LinkedList;
import org.leIngeneursInc.dataStructuresAlgorithms.lists.ListNode;
import org.leIngeneursInc.dataStructuresAlgorithms.lists.Util;

/**
 * Package private class that implements HashTable using Chaining as collision resolution technique.
 * @author Abhineet(sharma.abhineet31@gmail.com)
 */
class ChainingHashTable<V> extends HashTable<V> {
	
	// I know what I am doing here. Warning can be suppressed for trivial reasons.
	@SuppressWarnings("unchecked")
	private LinkedList<V>[] arrLists = (LinkedList<V>[])new LinkedList[DEFAULT_ARR_SIZE]; 

	/* (non-Javadoc)
	 * @see org.leIngeneursInc.dataStructuresAlgorithms.hashTables.HashTable#add(java.lang.Object)
	 */
	@Override
	public void add(V value) {
		// considering just in case object returns a negative hash code 
		// to check out this implementation's limits.
		int hash = Math.abs(value.hashCode()) % arrLists.length ;
		if(arrLists[hash] == null){
			arrLists[hash] = new LinkedList<V>();
		}
		
		/*
		 * If the list is empty. Simply insert the node
		 * Otherwise insert at the head. Now, my implementation does not provide 
		 * that code, therefore, put a little workaround.
		 */
		if(arrLists[hash].isEmpty()){
			arrLists[hash].insert(new ListNode<V>(value));
		}else{
			ListNode<V> newHead = new ListNode<V>(value);
			newHead.setNext(arrLists[hash].getHead());
			arrLists[hash].setHead(newHead);
		}
		
	}

	/* (non-Javadoc)
	 * @see org.leIngeneursInc.dataStructuresAlgorithms.hashTables.HashTable#lookup(java.lang.Object)
	 */
	@Override
	public boolean lookup(V value) {
		// considering just in case object returns a negative hash code 
		// to check out this implementation's limits.
		int hash = Math.abs(value.hashCode()) % arrLists.length ;
		if(arrLists[hash] == null || arrLists[hash].isEmpty()){
			return false;
		}else{
			return Util.findNode(value, arrLists[hash].getHead()) != null;	
		}
	}

	/* (non-Javadoc)
	 * @see org.leIngeneursInc.dataStructuresAlgorithms.hashTables.HashTable#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(V value) {
		// considering just in case object returns a negative hash code 
		// to check out this implementation's limits.
		int hash = Math.abs(value.hashCode()) % arrLists.length ;
		if(arrLists[hash] == null || arrLists[hash].isEmpty()){
			return false;
		}else{
			return arrLists[hash].delete(value) != null;	
		}
	}

}
