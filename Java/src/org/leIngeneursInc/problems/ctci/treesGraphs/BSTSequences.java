/**
 * 
 */
package org.leIngeneursInc.problems.ctci.treesGraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree prints out all the arrays that result in this tree. 
 * CTCI : Trees & Graphs
 * @author Abhineet (sharma.abhineet31@gmail.com)
 */
public class BSTSequences {
	
	private static class TreeNode<T>{
		T val;
		TreeNode<T> left = null;
		TreeNode<T> right = null;
		
		TreeNode(T val){
			this.val = val;
		}
		
		@Override
		public String toString(){
			return val.toString() +" Left : " +(left == null ? "False" : "True") +" Right : " +(right == null ? "False" : "True");
		}
		
		@Override
		public int hashCode(){
			return val.hashCode();
		}
	}
	
	public static<T> List<List<T>> bstSequences(TreeNode<T> root){
		List<List<T>> retList = new ArrayList<List<T>>();
		if(root == null){
			retList.add(new ArrayList<T>());
			return retList;
		}else{
			//do nothing here.
		}
		
		List<T> prefix = new ArrayList<T>();
		prefix.add(root.val);
		
		for(List<T> first : bstSequences(root.left)){
			for(List<T> second : bstSequences(root.right)){
				weaveLists(first, second, prefix, retList);
			}
		}
		return retList;
	}

	private static<T> void weaveLists(List<T> first, List<T> second, List<T> prefix, List<List<T>> results){
//		System.out.println("First : " +first);
//		System.out.println("Second : " +second);
//		System.out.println("Prefix : " +prefix);
//		System.out.println("\n\n------------------------\n\n");
		// Base case : if either of the two is empty. Just add other to the prefix and add it to results
		// Results must always be a new cloned list
		if(first.isEmpty() || second.isEmpty()){
			List<T> lst = new ArrayList<T>(prefix);
			lst.addAll(first);
			lst.addAll(second);
			results.add(lst);
			return;
		}else{
			//do ntohing here. Got some weaving to do 
		}
		
		//remove first and append it to the prefix
		T ele = first.remove(0);
		prefix.add(ele);
		weaveLists(first, second, prefix, results);
		// We have got all lists weaved. Now need to add 
		// first back so that we can do the same thing with second list
		prefix.remove(prefix.size() - 1);
		first.add(0,ele);
		
		//Need to do the same thing with second list and weave all
		ele = second.remove(0);
		prefix.add( ele);
		weaveLists(first, second, prefix, results);
		prefix.remove(prefix.size() -1);
		second.add(0,ele);
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(5);
		
		root.left = new TreeNode<Integer>(3);
		{
			TreeNode<Integer> tempNode = root.left;
			tempNode.left = new TreeNode<Integer>(2);
			tempNode.right = new TreeNode<Integer>(4);
		}
		
		root.right = new TreeNode<Integer>(8);
		{
			TreeNode<Integer> tempNode = root.right;
			tempNode.left = new TreeNode<Integer>(6);
			tempNode.right = new TreeNode<Integer>(9);
		}
		for(List<Integer> lst : bstSequences(root)){
			System.out.println(lst);
		}
		
		
		
		
		/*
		 * TEST CODE FOR WEAVE
		 */
//		int[] arr1 = new int[] {8,6,7};
//		int[] arr2 = new int[] {3,4,2};
//		List<List<Integer>> results = new ArrayList<List<Integer>>();
//		List<Integer> first = new ArrayList<Integer>();
//		List<Integer> second = new ArrayList<Integer>();
//		for(int val : arr1){
//			first.add(val);
//		}
//		for(int val : arr2){
//			second.add(val);
//		}
//		
//		weaveLists(first, second, new ArrayList<Integer>(), results);
//		for(List<Integer> lst : results){
//			System.out.println(lst);
//		}
//		System.out.println("TOTAL : " +results.size());

	}

}
