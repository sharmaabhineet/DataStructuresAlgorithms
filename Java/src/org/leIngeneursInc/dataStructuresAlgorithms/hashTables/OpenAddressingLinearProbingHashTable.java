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
}
