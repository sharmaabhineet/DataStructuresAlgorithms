/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.sorting;

import java.util.Comparator;

/**
 * Provides static utility methods for sorting 
 * @author Abhineet (sharma.abhineet31@gmail.com)
 */
public class Sort {
	
	/**
	 * Performs quick sort using Lomuto's parition scheme
	 * Time Complexity : Avg Case : O(nlog n). Worst Case : O(n^2)
	 * Space Complexity : O(1). Constant space
	 * @param arr the array to be  sorted
	 * @param comp Comparator object for the values in the array. Must not be null. Throws IllegalArgumentException, if comp is null.
	 */
	public static<T> void quickSort(T[] arr, Comparator<T> comp){
		if(arr == null || arr.length == 0){
			return;
		} else if ( comp == null ){
			throw new IllegalArgumentException("Comparator object must not be null");
		}else{
			//do nothing here. go ahead.
		}
		quickSort(arr, 0, arr.length - 1, comp);
	}
	
	/**
	 * Recursive Quick sort method
	 * @param arr the array to be sorted
	 * @param lo the starting index of the array 
	 * @param hi the last index (inclusive) of the array
	 * @param comp the comparator to compare values
	 */
	private static<T> void quickSort(T[] arr, int lo, int hi, Comparator<T> comp){
		if(lo < hi){
			int partition = partition(arr, lo, hi, comp);
			quickSort(arr, lo, partition -1, comp);
			quickSort(arr, partition +1, hi, comp);
		}else{
			// do nothing here.
		}
	}
	
	/**
	 * Paritions the array for quick sort using Lomuto's scheme. Check wikipedia for more details
	 * @param arr the array to be sorted
	 * @param lo starting index of the array
	 * @param hi the last index(inclusive) of the array 
	 * @param comp comparator object to compare values
	 * @return the index of partition containing the pivot element
	 */
	private static<T> int partition(T[] arr, int lo, int hi, Comparator<T> comp){
		// using Lomuto Scheme
		T pivot = arr[hi]; 
		int swapIndex = lo;
		for(int j = lo; j < hi; j++){
			int compVal = comp.compare(arr[j], pivot);
			if(compVal <= 0){
				T temp = arr[j];
				arr[j] = arr[swapIndex];
				arr[swapIndex] = temp;
				swapIndex++;
			}else{
				// do nothing
			}
		}
		T temp = arr[swapIndex];
		arr[swapIndex] = arr[hi];
		arr[hi] = temp;
		return swapIndex;
	}
	
	
	/**
	 * Merge Sort. Sorts the array in the same array Object
	 * Time Complexity : O(nlogn)
	 * Space Complexity : O(n)
	 * @param arr
	 */
	public static<T> void mergeSort(T[] arr, Comparator<T> comp){
		if(arr == null || arr.length <= 0){
			return;
		}else if (comp == null){
			throw new IllegalArgumentException("Comparator object can not be null");
		}else{
			//do nothign here. go ahead
		}
		@SuppressWarnings("unchecked")
		T[] workArr = (T[]) new Object[arr.length];
		mergeSortRec(arr, 0, arr.length, workArr, comp);
	}
	
	
	private static<T> void mergeSortRec(T[] arr, int lo, int hi, T[] workArr, Comparator<T> comp){
		if(hi - lo < 2){
			return;
		}else{
			//do nothing here. go ahead
		}
		
		int mid = (lo + hi) / 2;
		mergeSortRec(arr, lo, mid, workArr, comp);
		mergeSortRec(arr, mid, hi, workArr, comp);
		merge(arr, lo, mid, hi, workArr, comp);
	}
	
	private static<T> void merge(T[] arr, int lo, int mid, int hi, T[] workArr, Comparator<T> comp){
		int i = lo;
		int j = mid;
		for(int k = lo; k < hi; k++){ 
			if(i < mid && j < hi){
				int compVal = comp.compare(arr[i], arr[j]);
				if(compVal <= 0){
					workArr[k] = arr[i++]; 
				}else{
					workArr[k] = arr[j++];
				}
			}else if ( i >= mid ){
				workArr[k] = arr[j++];
			} else{
				workArr[k] = arr[i++];
			}
		}
		//Copying the array
		for(int k = lo; k < hi; k++){
			arr[k] = workArr[k];
		}
	}
}
