/**
 * 
 */
package org.leIngeneursInc.problems.ctci.treesGraphs;

import org.leIngeneursInc.dataStructuresAlgorithms.trees.BinaryTreeNode;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.TreeUtil;

/**
 * Solves the minimal tree problem in CTCI : Tree & Graphs
 * @author Abhineet(sharma.abhineet31@gmail.com)
 */
public class MinimalTree {
	
	public static<T> BinaryTreeNode<T> minimalTree(T[] arrVals){
		return minimalTreeRec(arrVals, 0 , arrVals.length - 1);
	}
	
	private static<T> BinaryTreeNode<T> minimalTreeRec(T[] arrVals, int  start, int end){
		if(start > end){
			return null;
		}else{
			//do nothign here. go ahead.
		}
		
		int mid = (start + end) / 2;
		BinaryTreeNode<T> root = new BinaryTreeNode<T>(arrVals[mid]);
		root.setLeft(minimalTreeRec(arrVals, start, mid - 1));
		root.setRight(minimalTreeRec(arrVals, mid + 1, end));
		return root;
	}
	 
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int inputSize = 10;
		Integer[] arrVals = new Integer[inputSize];
		for(int index = 0; index < inputSize; index++){
			arrVals[index] = index + 1;
		}
		
		for(int val : TreeUtil.inOrderTraversal(minimalTree(arrVals))){
			System.out.print(val +"  ");
		}
		System.out.println("");

	}

}
