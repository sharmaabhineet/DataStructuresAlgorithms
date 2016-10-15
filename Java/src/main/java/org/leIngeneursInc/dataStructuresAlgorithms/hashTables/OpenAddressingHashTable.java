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
	 * Protected class that serves as an entry in the hash table.
	 * @author Abhineet(sharma.abhineet31@gmail.com)
	 * @param <V>
	 */
	protected static class Entry<V>{
		V value;
		Entry(V value){
			this.value = value;
		}
	}
	
	protected final Entry<V> DUMMY_ENTRY;
	
	public OpenAddressingHashTable() {
		DUMMY_ENTRY = new Entry<V>(null);
	}
	
	/**
	 * Array that holds all the entries.
	 */
	//I know what i am doing here. Warnings can be suppressed for trivial reasons.
	@SuppressWarnings("unchecked")
	protected Entry<V>[] arrEntries = (Entry<V>[])new Entry[DEFAULT_ARR_SIZE];
	
	/**
	 * Resolves collision for the value and returns the new index in the array that should be used. 
	 * Returns -1 in case no location was found. Need to increase the size of the array.
	 * @param index the index for which collision needs to be resolved.
	 * @return the resolved location for this value.
	 */
	protected abstract int resolveCollision(int index); 
	
	
	/* (non-Javadoc)
	 * @see org.leIngeneursInc.dataStructuresAlgorithms.hashTables.HashTable#add(java.lang.Object)
	 */
	@Override
	public void add(V value) {
		// considering just in case object returns a negative hash code 
		// to check out this implementation's limits.
		int hash = Math.abs(value.hashCode()) % arrEntries.length ;
		if(arrEntries[hash] == null){
			arrEntries[hash] = new Entry<V>(value);
		}else{
			int newIndex = resolveCollision(hash);
			arrEntries[newIndex] = new Entry<V>(value);
		}
	}

	/* (non-Javadoc)
	 * @see org.leIngeneursInc.dataStructuresAlgorithms.hashTables.HashTable#lookup(java.lang.Object)
	 */
	@Override
	public boolean lookup(V value) {
		// considering just in case object returns a negative hash code 
		// to check out this implementation's limits.
		int hash = Math.abs(value.hashCode()) % arrEntries.length ;
		if(arrEntries[hash] == null){
			return false;
		}else{
			return locateIndex(hash, value) != -1;
		}
	}

	/* (non-Javadoc)
	 * @see org.leIngeneursInc.dataStructuresAlgorithms.hashTables.HashTable#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(V value) {
		// considering just in case object returns a negative hash code 
		// to check out this implementation's limits.
		int hash = Math.abs(value.hashCode()) % arrEntries.length ;
		if(arrEntries[hash] == null){
			return false;
		}else{
			int newIndex = locateIndex(hash, value);
			if(newIndex != -1){
				arrEntries[newIndex] = DUMMY_ENTRY;
				return true;
			}else{
				return false;
			}
		}
	}

	/**
	 * Locates the index of the value in the array
	 * @param index the index to start with. Basically, hash of the vlaue
	 * @param value the value to search for
	 * @return the index of the entry containing the value. -1 Otherwise, if the value does ont exist
	 */
	protected abstract int locateIndex(int index, V value);
	
	@SuppressWarnings("unchecked")
	protected final void increaseSize() {
		Entry<V>[] oldArr = arrEntries;
		arrEntries = (Entry<V>[])new Entry[findNextPrime()];
		//Need to rehash everything
		for(Entry<V> entry : oldArr){
			add(entry.value);
		}
	}
	
	/**
	 * finds the next prime number after double of the size of current array.
	 * Stressing on prime numbers, as they say, its a good practice to keep it prime.
	 * @return the prime number next to double the size of current array. Integer.MAX_VALUE 
	 * if the size is really big. 
	 * Throws an error in case more space is required than Integer.MAX_VALUE
	 */
	private int findNextPrime(){
		if(arrEntries.length == Integer.MAX_VALUE){
			throw new Error("Don't have enough space");
		}else if(arrEntries.length > Integer.MAX_VALUE / 2){
			return Integer.MAX_VALUE;
		}else{
			int startingPoint = arrEntries.length * 2 + 1;
			while(startingPoint < Integer.MAX_VALUE){
				if(isPrime(startingPoint)){
					return startingPoint; 
				}else{
					if(startingPoint < Integer.MAX_VALUE - 1){
						startingPoint++;
					}else{
						break;
					}
				}
			}
			return Integer.MAX_VALUE;
		}
	}
	
	/**
	 * Checks if given number if prime. This is probably the most naiive of 
	 * implementations. Sticking to it for now. There are probably better algorithms.
	 * @param num the number that is to be checked
	 * @return boolean value indicating whether or not the number is prime
	 */
	private boolean isPrime(int num){
		for(int div = 2; div <= Math.sqrt(num); div++){
			if(num % div == 0){
				return false;
			}
		}
		return true;
	}
}
