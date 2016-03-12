/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.hashTables;

/**
 * @author Abhineet
 *
 */
/**
 * @author Abhineet
 *
 * @param <V>
 */
class OpenAddressingLinearProbingHashTable<V> extends OpenAddressingHashTable<V> {

	/* (non-Javadoc)
	 * @see org.leIngeneursInc.dataStructuresAlgorithms.hashTables.OpenAddressingHashTable#resolveCollision(java.lang.Object)
	 */
	@Override
	protected int resolveCollision(int index){ 
		int newIndex = (index + 1) % arrEntries.length;
		while(newIndex != index){
			if(arrEntries[newIndex] == null || arrEntries[newIndex] == DUMMY_ENTRY){
				return newIndex;
			}else{
				newIndex = ( newIndex + 1 ) % arrEntries.length;
			}
		}
		increaseSize();
		return resolveCollision(index);
	}
	
	/* (non-Javadoc)
	 * @see org.leIngeneursInc.dataStructuresAlgorithms.hashTables.OpenAddressingHashTable#locateIndex(int, java.lang.Object)
	 */
	@Override
	protected int locateIndex(int index, V value){
		int newIndex = index;
		do{
			if(arrEntries[newIndex] != DUMMY_ENTRY && 
						(value == arrEntries[newIndex].value || value.equals(arrEntries[newIndex].value))){
				return newIndex;
			}else{
				newIndex = ( newIndex + 1 ) % arrEntries.length;
			}
		}while(arrEntries[newIndex] != null && newIndex != index);
		return -1;
	}
}
