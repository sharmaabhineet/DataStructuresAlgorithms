/**
 * 
 */
package org.leIngeneursInc.problems.forFun;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class generates all the combinations of the elements of a given set
 * taken at most(not exactly) k at a time.
 * 
 * @author Abhineet ( sharma.abhineet31@gmail.com )
 *
 */
public class CombinatoricsGenerator {
	
	/**
	 * Generates all combinations from the elements of the given list taken at most k elements at a time.
	 * @param elemList the input list of elements
	 * @param k the parameter k
	 * @return set of generated combinations(represented as set of elements)
	 */
	public static<T> Set<Set<T>> generateCombinatoricsTakenAtMostKRec(List<T> elemList, int k){
		Set<Set<T>> retSet = new HashSet<Set<T>>();
		if(elemList.size() == 1){
			retSet.add(new HashSet<T>(elemList));
		}else{
			T elem = elemList.remove(0);
			Set<T> combSet=  new HashSet<T>();
			combSet.add(elem);
			retSet.add(combSet);
			for(Set<T> objSet : generateCombinatoricsTakenAtMostKRec(elemList, k) ){
				retSet.add(objSet);
				if(objSet.size() < k){
					Set<T> newSet=  new HashSet<T>(objSet);
					newSet.add(elem);
					retSet.add(newSet);
				}
			} 
		}
		return retSet;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> elemSet = new ArrayList<Integer>();
		for (int i = 1; i <= 5; i++) {
			elemSet.add(i);
		}

		Set<Set<Integer>> comb =  generateCombinatoricsTakenAtMostKRec(elemSet, 5);
		int index = 1;
		for (Set<Integer> combSet : comb) {
			System.out.println("Comb " + index++ + " --> " + combSet);
		}
	}

}
