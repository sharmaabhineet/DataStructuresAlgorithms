/**
 * 
 */
package org.leIngeneursInc.problems.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Generates all possible permutations without repitions
 * @author Abhineet ( sharma.abhineet31@gmail.com )
 *
 */
public class PermutationGenerator {

	public static void main(String[] args) {
		List<List<Integer>> permList = generatePermutations(new Integer[]{1, 2, 3, 4});
		int count = 0;
		for(List<Integer> lst : permList){
			System.out.print("PERM " +(++count) + " -> [\t\t ");
			for(int i : lst){
				System.out.print(i +"\t");
			}
			System.out.println(" ] ");
		}

	}
	
	public static<T> List<List<T>> generatePermutations(T[] arr){
		if(arr == null || arr.length <= 0){
			return Collections.emptyList();
		}
		return generatePermutationsRec(arr, 0);
	}
	
	public static<T> List<List<T>> generatePermutationsRec(T[] arr, int index){
		List<List<T>> retList = new ArrayList<List<T>>();
		if(index == arr.length - 1){
			List<T> lst = new ArrayList<T>();
			lst.add(arr[index]);
			retList.add(lst);
			return retList;
		}else{
			//do nothing here go ahead.
		}
		List<List<T>> permList = generatePermutationsRec(arr, index + 1);
		for(List<T> lst : permList){
			for(int i =0; i <= lst.size(); i++){
				List<T> newLst = new ArrayList<T>(lst);
				newLst.add(i, arr[index]);
				retList.add(newLst);
			}
		}
		return retList;
	}

}
