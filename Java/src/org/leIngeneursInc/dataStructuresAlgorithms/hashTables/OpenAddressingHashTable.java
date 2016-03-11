/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.hashTables;

/**
 * This is another abstract class that provides common ground work for OpenAddressing technique
 * @author Abhineet (sharma.abhineet31@gmail.com)
 */
abstract class OpenAddressingHashTable<V> extends HashTable<V> {
	
	/**
	 * Resolves collision for the value and returns the new index in the array that should be used. 
	 * Returns -1 in case no location was found. Need to increase the size of the array.
	 * @param val the value for which collision needs to be resolved.
	 * @return the resolved location for this value.
	 */
	protected abstract int resolveCollision(V val); 
	
	/**
	 * Increases the size of the array of hashes if we run out of memory.
	 */
	protected abstract void increaseSize();
}
