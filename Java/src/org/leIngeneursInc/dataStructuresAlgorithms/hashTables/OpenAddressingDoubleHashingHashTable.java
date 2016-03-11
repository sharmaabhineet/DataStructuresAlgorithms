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
		int newIndex = (index + getSecondHash()) % arrEntries.length;
		while(newIndex != index){
			if(arrEntries[newIndex] == null || arrEntries[newIndex] == DUMMY_ENTRY){
				return newIndex;
			}else{
				newIndex = (index + 23) % arrEntries.length;
			}
		}
		increaseSize();
		return resolveCollision(index);
	}
	
	/**
	 * @return the second hash value with which to move. 
	 */
	//Keeping it independent of the value. May or May not be, I guess.
	private static int getSecondHash(){
		//returning another prime for now
		return 23;
	}
}
