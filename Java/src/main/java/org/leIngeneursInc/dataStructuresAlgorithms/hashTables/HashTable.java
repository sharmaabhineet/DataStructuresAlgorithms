/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.hashTables;

import java.util.Random;

/**
 * An abstract class that wraps hash table implementation with three collision resolution
 * techniques that can be specified using an enumeration defined in this class.
 * It exposes a factory that would return an appropriate instance given a collision resolution
 * strategy
 * @author Abhineet(sharma.abhineet31@gmail.com)
 *
 */
public abstract class HashTable<V> {
	
	/**
	 * Choosing an arbitrary prime number for now.
	 */
	protected static final int DEFAULT_ARR_SIZE = 1789;

	public static enum CollisionStrategy{
		/**
		 * Collision resolution by chaining
		 */
		CHAINING,		 
		/**
		 * Collision resolution by open addressing and linear probing
		 */
		OPEN_ADDRESSING_LINEAR_PROBING, 	
		/**
		 * Collision resolution by open addressing and double hashing
		 */
		OPEN_ADDRESSING_DOUBLE_HASHING, 	 
		/**
		 * Any built in collision resolution technique.
		 */
		SURPRISE_ME							
	};
	
	/**
	 * Factory method that returns a hash table implementation given a collision resolution strategy
	 * @param colStrat the collision strategy to be used. Collision strategies are defined in HasthTable.CollisionStrategy
	 * @return the appropriate hash function implementation
	 */
	public static<V> HashTable<V> createHashTable(CollisionStrategy colStrat){
		switch(colStrat){
		case CHAINING:
			return new ChainingHashTable<V>();
		case OPEN_ADDRESSING_LINEAR_PROBING:
			return new OpenAddressingLinearProbingHashTable<V>();
		case OPEN_ADDRESSING_DOUBLE_HASHING:
			return new OpenAddressingDoubleHashingHashTable<V>();
		case SURPRISE_ME:
			Random rndm = new Random();
			CollisionStrategy[] arrStrategies = CollisionStrategy.values();
			int randomIndex = rndm.nextInt(arrStrategies.length);
			return createHashTable(arrStrategies[randomIndex]);
			default:
				throw new IllegalArgumentException("Invalid Input. Valid Inputs are the ones defined in HashTable.CollisionStrategy");
		}
	}
	
	
	/**
	 * Add an entry into the hasht able. Note that this implementation relies on 
	 * objects own implementation of hashCode() method.
	 * This method would dynamically reallocate the values, if there we are running out of space. 
	 * @param value the value to be added to the table
	 */
	public abstract void add( V value);
	
	/**
	 * Looks up for a particular value and returns a boolean value indicating whether or not 
	 * the value is present in the hashtable
	 * @param value the value that needs to be searched for
	 * @return boolean value indicating the presence of the value in the hash table.
	 */
	public abstract boolean lookup(V value);
	
	/**
	 * Removes given value from the hashtable if the value was present.
	 * @param value the value that needs to be deleted.
	 * @return a boolean value indicating whether or not the value was present or not.
	 */
	public abstract boolean delete(V value);
	
}
