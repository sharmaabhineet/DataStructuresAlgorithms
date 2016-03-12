/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.hashTables;

/**
 * @author Abhineet
 *
 */
class OpenAddressingDoubleHashingHashTable<V> extends OpenAddressingHashTable<V> {

	
	/* (non-Javadoc)
	 * @see org.leIngeneursInc.dataStructuresAlgorithms.hashTables.OpenAddressingHashTable#resolveCollision(java.lang.Object)
	 */
	@Override
	protected int resolveCollision(int index) {
		// It increments the value with 23 (say)
		int secondHash = getSecondHash();
		int len = arrEntries.length;
		int newIndex = (index + secondHash) % len;
		while(newIndex != index){
			if(arrEntries[newIndex] == null || arrEntries[newIndex] == DUMMY_ENTRY){
				return newIndex;
			}else{
				newIndex = (newIndex + secondHash) % len;
			}
		}
		// We need the hash to be recomputed as array size would change
		// so would the hash returned
		System.out.println("OLD INDEX : " +index);
		V oldValue = arrEntries[index].value;
		increaseSize();
		newIndex = Math.abs(oldValue.hashCode()) % arrEntries.length;
		System.out.println("\tNEW INDEX : " +newIndex +" ( VAL : " +oldValue +" ) ");
		if(arrEntries[newIndex] == null || arrEntries[newIndex] == DUMMY_ENTRY){
			return newIndex;
		}else{
			return resolveCollision(index);
		}
	}
	
	/**
	 * @return the second hash value with which to move. 
	 */
	//Keeping it independent of the value. May or May not be, I guess.
	private int getSecondHash(){
		//returning another prime for now
		return 23;
	}
	
	/* (non-Javadoc)
	 * @see org.leIngeneursInc.dataStructuresAlgorithms.hashTables.OpenAddressingHashTable#locateIndex(int, java.lang.Object)
	 */
	@Override
	protected int locateIndex(int index, V value){
		int secondHash = getSecondHash();
		int len = arrEntries.length;
		int newIndex = index;
		do{
			if(arrEntries[newIndex] != DUMMY_ENTRY && 
						(value == arrEntries[newIndex].value || value.equals(arrEntries[newIndex].value))){
				return newIndex;
			}else{
				newIndex = ( newIndex +  secondHash) % len;
			}
		}while(arrEntries[newIndex] != null && newIndex != index);
		return -1;
	}
}
