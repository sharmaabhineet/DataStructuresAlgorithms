/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Min Heap
 * 
 * @author Abhineet(sharma.abhineet31@gmail.com)
 */
public class MinHeap<T extends Comparable<T>> {
	List<T> lstEle = null;
	int heapSize = 0;

	public MinHeap() {
		lstEle = new ArrayList<T>();
	}

	public MinHeap(int capacity) {
		lstEle = new ArrayList<T>(capacity);
	}

	/**
	 * REturns the minimum element in the heap. Time Complexity : O(1) Space
	 * Complexity : O(1)
	 * 
	 * @return the minimum element in the min heap
	 */
	public T getMin() {
		if (heapSize > 0) {
			return lstEle.get(0);
		} else {
			return null;
		}
	}

	/**
	 * REturns the minimum element in the heap and removes it from the heap Time
	 * Complexity : O(logn) Space Complexity : O(1)
	 * 
	 * @return the minimum element in the heap
	 */
	public T extractMin() {
		if (heapSize > 0) {
			System.out.print("LIST:  " );
			printList();
			T retEle = lstEle.get(0);
			System.out.println("\tRemoving : " +retEle);
			lstEle.set(0, lstEle.get(heapSize - 1));
			lstEle.set(heapSize - 1, null);
			heapSize--;
			heapify();
			System.out.print("After HEAPIFY : ");
			printList();
			return retEle;
		} else {
			return null;
		}
	}
	
	
	private void printList(){
		for(int index = 0; index < heapSize; index++){
			System.out.print(lstEle.get(index) +"    ");
		}
		System.out.println("");
	}

	/**
	 * Inserts item into the heap
	 * 
	 * @param val
	 */
	public void insert(T val) {
		lstEle.add(val);
		heapSize++;
		// Need to move up the tree and satisfy the heap property
		int currIndex = heapSize - 1;
		int parentIndex = getParent(currIndex);
		if (parentIndex >= 0) {
			do {
				T parentVal = lstEle.get(parentIndex);
				if (parentVal.compareTo(val) > 0) {
					lstEle.set(parentIndex, val);
					lstEle.set(currIndex, parentVal);
					currIndex = parentIndex;
					parentIndex = getParent(currIndex);
				}else{
					break;
				}
			} while (parentIndex >= 0);
		}else{
			//do nothing
		}
		
	}

	private int getParent(int currIndex) {
		if (currIndex % 2 == 0) {
			return (currIndex - 2) / 2;
		} else {
			return (currIndex - 1) / 2;
		}
	}

	/**
	 * Re-Heapifies the heap. Time Complexity : O(logn) Space Complexity : O(1)
	 */
	private void heapify() {
		int currIndex = 0;
		while (currIndex < heapSize) {
			T val = lstEle.get(currIndex);
			int leftSubtreeIndex = getLeftSubtree(currIndex);
			int rightSubtreeIndex = getRightSubtree(currIndex);
			T leftChildVal = leftSubtreeIndex < heapSize ? lstEle.get(leftSubtreeIndex) : null;
			T rightChildVal = rightSubtreeIndex < heapSize ? lstEle.get(rightSubtreeIndex) : null;
			
			T minVal = null;
			int minValIndex = -1;
			if(leftChildVal != null && rightChildVal != null){
				int compVal = leftChildVal.compareTo(rightChildVal); 
				if(compVal < 0){
					minVal = leftChildVal;
					minValIndex = leftSubtreeIndex;
				}else {
					minVal = rightChildVal;
					minValIndex = rightSubtreeIndex;
				}
			}else{
				if(leftChildVal != null && leftChildVal.compareTo(val) < 0){
					minValIndex = leftSubtreeIndex;
					minVal = leftChildVal;
				}else if (rightChildVal != null && rightChildVal.compareTo(val) < 0 ){
					minValIndex = rightSubtreeIndex;
					minVal = rightChildVal;
				}else{
					break;
				}
			}
			System.out.println("\tMin Val : " +minVal +" --> " +minValIndex);
			
			lstEle.set(currIndex, minVal);
			currIndex = minValIndex;
			lstEle.set(minValIndex, val);
			
		}

	}

	private int getLeftSubtree(int index) {
		return 2 * index + 1;
	}

	private int getRightSubtree(int index) {
		return 2 * index + 2;
	}

}
