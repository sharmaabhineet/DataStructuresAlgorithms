/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import org.junit.Test;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.BinarySearchTree;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.BinaryTreeNode;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.TreeUtil;

/**
 * Test Class for testing out all the methods of Binary Search Tree
 * 
 * @author Abhineet (sharma.abhineet31@gmail.com)
 * 
 */
public class BinarySearchTreeTest {

	private static Comparator<Integer> getIntComparator() {
		return new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				if (arg0.intValue() == arg1.intValue()) {
					return 0;
				} else if (arg0.intValue() < arg1.intValue()) {
					return -1;
				} else {
					return 1;
				}
			}
		};
	}

	private static BinarySearchTree<Integer> getTreeWithRootNode() {
		return new BinarySearchTree<Integer>(new BinaryTreeNode<Integer>(1),
				getIntComparator());
	}

	private static BinarySearchTree<Integer> getSimpleBST() {

		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(
				new BinaryTreeNode<Integer>(2), getIntComparator());
		bst.getRoot().setLeft(new BinaryTreeNode<Integer>(1));
		bst.getRoot().setRight(new BinaryTreeNode<Integer>(3));
		return bst;

	}

	private static BinarySearchTree<Integer> generateRandomIntTree(int size,
			List<Integer> setVals, boolean isUnique) {
		if (setVals == null) {
			throw new IllegalArgumentException(
					"This methods expects an empty set to output all the added values in this set");
		} else {
			// do nothing here. go ahead
		}
		setVals.clear();
		BinarySearchTree<Integer> retBst = new BinarySearchTree<Integer>();
		retBst.setComp(getIntComparator());

		Random random = new Random();
		int maxValue = size * 10;
		int val = -1;
		for (int iter = 0; iter < size; iter++) {
			do {
				val = random.nextInt(maxValue);
			} while (isUnique && setVals.contains(val));
			setVals.add(val);
			retBst.insert(val);
		}
		return retBst;
	}

	@Test
	public void testIsEmpty_EmptyTree() {
		assertTrue("Empty BST Must return true", getEmptyBST().isEmpty());
	}

	@Test
	public void testIsEmpty_NonEmptyTree() {
		assertFalse("Simple BST Must return false", getSimpleBST().isEmpty());
	}

	// Helper methods to create trees with integer values

	private static BinarySearchTree<Integer> getEmptyBST() {
		return new BinarySearchTree<Integer>();
	}

	@Test
	public void test_isValidBST_SimpleTree() {
		assertTrue("Value must be true for this case.", getSimpleBST()
				.isValidBST());
	}

	@Test
	public void test_isValidBST_TreeWithSingleNode() {
		assertTrue("Value must be true for this case.", getTreeWithRootNode()
				.isValidBST());
	}

	@Test
	public void test_isValidBST_InValidBST() {
		BinarySearchTree<Integer> bst = getSimpleBST();
		bst.getRoot().setVal(-1);
		assertFalse("Value must be false for this case.", bst.isValidBST());
	}

	@Test
	public void test_isValidBST_RandomSet() {
		List<Integer> lstVals = new ArrayList<Integer>();
		int MAX_SIZE = 20;
		BinarySearchTree<Integer> bst = generateRandomIntTree(MAX_SIZE, lstVals, true);
		assertTrue("Random BST must be a valid Binary Search Tree",
				bst.isValidBST());
		List<Integer> lst = TreeUtil.inOrderTraversal(bst.getRoot());
		assertTrue(
				"Size of the inserted values set must be less than equal to the "
						+ "list of values returned from the inorder traversal. Less than in case of duplicates.",
				lstVals.size() <= lst.size());

		for (int val : lst) {
			assertTrue(
					"Value returned from in order traversal must be a valid value from the set of inserted values",
					lstVals.contains(val));
		}

		// Also, validating the inorder traversal.
		int index = 0;
		for (int val : new TreeSet<Integer>(lstVals)) {
			assertEquals(
					"Values from the inorder traversal of BST must be sorted",
					val, lst.get(index++).intValue());
		}
	}

	@Test
	public void test_find_AllCases_RootWithSingleNode() {
		BinarySearchTree<Integer> bst = getTreeWithRootNode();
		assertNotNull(bst.find(1));
		assertEquals(1, bst.find(1).getVal().intValue());
		assertNull(bst.find(2));
	}

	@Test
	public void test_find_AllCases_SimpleBST() {
		BinarySearchTree<Integer> bst = getSimpleBST();
		assertNotNull(bst.find(1));
		assertEquals(1, bst.find(1).getVal().intValue());

		assertNotNull(bst.find(2));
		assertEquals(2, bst.find(2).getVal().intValue());

		assertNotNull(bst.find(3));
		assertEquals(3, bst.find(3).getVal().intValue());

		assertNull(bst.find(4));
	}

	@Test
	public void test_find_AllCases_RandomBST() {
		int MAX_TRIES = 100;
		int MAX_SIZE = 20;
		for (int iter = 0; iter < MAX_TRIES; iter++) {
			List<Integer> lstVals = new ArrayList<Integer>();
			BinarySearchTree<Integer> bst = generateRandomIntTree(MAX_SIZE, lstVals,
					false);
			String msg = "Random BST. Iteration : " + (iter + 1)
					+ " Tree Generated From elements in same order " + lstVals;
			for (int val : lstVals) {
				String msg1 = "Error trying to Locate : " + val + " " + msg;
				BinaryTreeNode<Integer> node = bst.find(val);
				assertNotNull(msg1, node);
				assertEquals(msg1, val, node.getVal().intValue());
			}
			for (int i = lstVals.size() * 10; i >= 0; i--) {
				String msg1 = "Error trying to Locate : " + i + " " + msg;
				if(!lstVals.contains(i)){
					BinaryTreeNode<Integer> node = bst.find(i);
					assertNull(msg1, node);
				}else{
					//do nhothing here. continue.xt
				}
			}
		}
	}
	
	@Test
	public void test_findMin_SingleNode(){
		BinarySearchTree<Integer> bst = getTreeWithRootNode();
		assertEquals("Expecting min value to be 1",  1, bst.findMin().getVal().intValue());
	}
	
	@Test
	public void test_findMin_SimpleBST(){
		BinarySearchTree<Integer> bst = getSimpleBST();
		assertEquals("Expecting min value to be 1",  1, bst.findMin().getVal().intValue());
	}
	
	@Test
	public void test_findMin_RandomBST(){
		int MAX_ITER = 10;
		int MAX_SIZE = 20;
		for(int iter= 0 ; iter < MAX_ITER; iter++){
			List<Integer> lstVals = new ArrayList<Integer>();
			BinarySearchTree<Integer> bst = generateRandomIntTree(MAX_SIZE, lstVals,
					false);
			String msg = "Random BST. Iteration : " + (iter + 1)
					+ " Tree Generated From elements in same order " + lstVals;
			assertEquals(msg, new TreeSet<Integer>(lstVals).first().intValue() , bst.findMin().getVal().intValue());
		}
	}
	
	
	@Test
	public void test_findMax_SingleNode(){
		BinarySearchTree<Integer> bst = getTreeWithRootNode();
		assertEquals("Expecting min value to be 1",  1, bst.findMax().getVal().intValue());
	}
	
	@Test
	public void test_findMax_SimpleBST(){
		BinarySearchTree<Integer> bst = getSimpleBST();
		assertEquals("Expecting min value to be 3",  3, bst.findMax().getVal().intValue());
	}
	
	@Test
	public void test_findMax_RandomBST(){
		int MAX_ITER = 10;
		int MAX_SIZE = 20;
		for(int iter= 0 ; iter < MAX_ITER; iter++){
			List<Integer> lstVals = new ArrayList<Integer>();
			BinarySearchTree<Integer> bst = generateRandomIntTree(MAX_SIZE, lstVals,
					false);
			String msg = "Random BST. Iteration : " + (iter + 1)
					+ " Tree Generated From elements in same order " + lstVals;
			assertEquals(msg, new TreeSet<Integer>(lstVals).last().intValue() , bst.findMax().getVal().intValue());
		}
	}
	
	@Test
	public void test_successorPredecessor_RandomBST_MultiIter(){
		int MAX_ITER = 10;
		int MAX_SIZE = 20;
		for(int iter= 0 ; iter < MAX_ITER; iter++){
			List<Integer> lstVals = new ArrayList<Integer>();
			BinarySearchTree<Integer> bst = generateRandomIntTree(MAX_SIZE, lstVals,
					true);
			String msg = "Random BST. Iteration : " + (iter + 1)
					+ " Tree Generated From elements in same order " + lstVals;
			Collections.sort(lstVals);
			for(int index = 0; index < lstVals.size(); index++){
				String msg1 = "Predecessor of " +lstVals.get(index) +" " + msg;
				BinaryTreeNode<Integer> pred = bst.findPredecessor(lstVals.get(index));
				if(index == 0){
					assertNull(msg1, pred);
				}else{
					assertNotNull(msg1, pred);
					assertEquals(msg1, lstVals.get(index-1).intValue(), pred.getVal().intValue());
				}
				
				 msg1 = "Successor of " +lstVals.get(index) +" " + msg;
				BinaryTreeNode<Integer> succ = bst.findSuccessor(lstVals.get(index));
				if(index == lstVals.size()-1){
					assertNull(msg1, succ);
				}else{
					assertNotNull(msg1, succ);
					assertEquals(msg1, lstVals.get(index+1).intValue(), succ.getVal().intValue());
				}
			}
		}
	}
	
	@Test
	public void test_Delete_RandomBST(){
		int MAX_ITER = 100;
		int MAX_SIZE = 100;
		for(int iter= 0 ; iter < MAX_ITER; iter++){
			List<Integer> lstVals = new ArrayList<Integer>();
			BinarySearchTree<Integer> bst = generateRandomIntTree(MAX_SIZE, lstVals,
					true);
			String msg = "Random BST. Iteration : " + (iter + 1)
					+ " Tree Generated From elements in same order " + lstVals;
			Random random = new Random();
			while(!lstVals.isEmpty()){
				int randomIndex = random.nextInt(lstVals.size());
				String msg1 = "Removing " +lstVals.get(randomIndex) + " " +msg;
				bst.delete(lstVals.get(randomIndex));
				lstVals.remove(randomIndex);
				assertEquals(lstVals.isEmpty(), bst.isEmpty());
				assertTrue(msg1, bst.isValidBST());
				List<Integer> inOrderLst = TreeUtil.inOrderTraversal(bst.getRoot());
				List<Integer> sortedLstVals = new ArrayList<Integer>(lstVals);
				Collections.sort(sortedLstVals);
				int index = 0;
				assertEquals(msg1, sortedLstVals.size(), inOrderLst.size() );
				for(int val : inOrderLst){
					assertEquals(msg1, sortedLstVals.get(index++).intValue(), val);
				}
			}
		}
		
	}

}
