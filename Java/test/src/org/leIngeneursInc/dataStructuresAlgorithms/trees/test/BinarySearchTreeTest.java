/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.trees.test;

import org.junit.Test;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.BinarySearchTree;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.BinaryTreeNode;
import static org.junit.Assert.*;

/**
 * Test Class for testing out all the methods of Binary Search Tree
 * @author Abhineet (sharma.abhineet31@gmail.com)
 *
 */
public class BinarySearchTreeTest {
	
	@Test
	public void testIsEmpty_EmptyTree(){
		assertTrue("Empty BST Must return true", getEmptyBST().isEmpty());
	}
	
	@Test
	public void testIsEmpty_NonEmptyTree(){
		assertFalse("Simple BST Must return false", getSimpleBST().isEmpty());
	}
	
	//Helper methods to create trees with integer values
	
	private static  BinarySearchTree<Integer> getEmptyBST(){
		return new BinarySearchTree<Integer>();
	}
	
	private static BinarySearchTree<Integer> getTreeWithRootNode(){
		return new BinarySearchTree<Integer>(new BinaryTreeNode<Integer>(1));
	}
	
	private static BinarySearchTree<Integer> getSimpleBST(){
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(new BinaryTreeNode<Integer>(2));
		bst.getRoot().setLeft(new BinaryTreeNode<Integer>(1));
		bst.getRoot().setRight(new BinaryTreeNode<Integer>(3));
		return bst;
		
	}

}
