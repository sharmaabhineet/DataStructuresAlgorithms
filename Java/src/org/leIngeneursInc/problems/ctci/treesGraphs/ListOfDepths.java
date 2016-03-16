/**
 * 
 */
package org.leIngeneursInc.problems.ctci.treesGraphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import org.leIngeneursInc.dataStructuresAlgorithms.trees.BinarySearchTree;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.BinaryTreeNode;

/**
 * Solves the Lists of depths problems in CTCT : Tree & Graph
 * @author Abhineet(sharma.abhineet31@gmail.com)
 */
public class ListOfDepths {
	
	private static<T> List<List<T>> listsOfDepths(BinaryTreeNode<T> root){
		List<List<T>> retList = new ArrayList<List<T>>();
		Queue<BinaryTreeNode<T>> nodeQ = new LinkedList<BinaryTreeNode<T>>();
		nodeQ.add(root);
		Queue<BinaryTreeNode<T>> bufferQ = new LinkedList<BinaryTreeNode<T>>();
		while(!nodeQ.isEmpty()){
			List<T> lst = new ArrayList<T>();
			retList.add(lst);
			while(!nodeQ.isEmpty()){
				BinaryTreeNode<T> node = nodeQ.poll();
				lst.add(node.getVal());
				if(node.getLeft() != null){
					bufferQ.add(node.getLeft());
				}
				if(node.getRight() != null){
					bufferQ.add(node.getRight());
				}
			}
			Queue<BinaryTreeNode<T>> tempQ = nodeQ;
			nodeQ = bufferQ;
			bufferQ = tempQ;
		}
		return retList;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int inputSize = 10;
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.setComp(new Comparator<Integer>(){
			@Override
			public int compare(Integer obj1, Integer obj2){
				if(obj1 == obj2 || obj1.intValue() == obj2.intValue()){
					return 0;
				}else if (obj1.intValue() < obj2.intValue()){
					return -1;
				}else{
					return 1;
				}
			}
		});
		Random rndm = new Random();
		for(int index = 0; index < inputSize; index++){
			int randomVal = rndm.nextInt(100);
			System.out.print(randomVal +"    ");
			bst.insert(randomVal);
		}
		System.out.println("");
		
		
		List<List<Integer>> lst = listsOfDepths(bst.getRoot());
		for(int list =1 ; list <= lst.size(); list++){
			System.out.print("List # " +list +" : ");
			for(int val : lst.get(list-1)){
				System.out.print(val +"    ");
			}
			System.out.println("");
		}

	}

}
