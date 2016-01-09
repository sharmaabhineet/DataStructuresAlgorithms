/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.trees.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.BinarySearchTree;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.BinaryTreeNode;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.TreeUtil;

/**
 * Class to test TreeUtil methods
 * @author Abhineet ( sharma.abhineet31@gmail.com )
 *
 */
public class TreeUtilTest {
	
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
			List<Integer> lstVals, boolean isUnique) {
		if (lstVals == null) {
			throw new IllegalArgumentException(
					"This methods expects an empty set to output all the added values in this set");
		} else {
			// do nothing here. go ahead
		}
		lstVals.clear();
		BinarySearchTree<Integer> retBst = new BinarySearchTree<Integer>();
		retBst.setComp(getIntComparator());

		Random random = new Random();
		int maxValue = size * 10;
		int val = -1;
		for (int iter = 0; iter < size; iter++) {
			do {
				val = random.nextInt(maxValue);
			} while (isUnique && lstVals.contains(val));
			lstVals.add(val);
			retBst.insert(val);
		}
		return retBst;
	}

	@Test
	public void testLevelOrderTraversal_EmptyTree(){
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		List<List<Integer>> lst = TreeUtil.levelOrderTraversal(bst.getRoot());
		assertNotNull("Expecting an empty list in case root node is null",lst);
		assertTrue("Expecting an empty list in case root node is null", lst.isEmpty());
	}
	
	@Test
	public void testLevelOrderTraversal_SingleNode(){
		BinarySearchTree<Integer> bst =  getTreeWithRootNode();
		List<List<Integer>> lst = TreeUtil.levelOrderTraversal(bst.getRoot());
		String msg = "Expecting [ [1] ]";
		assertNotNull(msg,lst);
		assertEquals(msg, 1, lst.size());
		assertEquals(msg, 1, lst.get(0).size());
		assertEquals(msg, 1, lst.get(0).get(0).intValue());
	}
	
	@Test
	public void testLevelOrderTraversal_SimpleBST(){
		BinarySearchTree<Integer> bst =  getSimpleBST();
		List<List<Integer>> lst = TreeUtil.levelOrderTraversal(bst.getRoot());
		String msg = "Expecting [ [2], [ 1, 3] ]";
		List<List<Integer>> expectedValLst = new ArrayList<List<Integer>>();
		expectedValLst.add(new ArrayList<Integer>());
		expectedValLst.add(new ArrayList<Integer>());
		expectedValLst.get(0).add(2);
		expectedValLst.get(1).add(1);
		expectedValLst.get(1).add(3);
		assertNotNull(msg,lst);
		assertEquals(msg, expectedValLst.size(), lst.size());
		for(int index = 0; index < expectedValLst.size(); index++){
			List<Integer> eLst = expectedValLst.get(index);
			List<Integer> aLst = lst.get(index);
			assertEquals(msg, eLst.size(), aLst.size());
			for(int index1 = 0; index1 < eLst.size(); index1++){
				assertEquals(msg, eLst.get(index1), aLst.get(index1));
			}
		}
	}
	
	@Test
	public void testLevelOrderTraversal_HandCraftedTree(){
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.setComp(getIntComparator());
		List<List<Integer>> expectValList = new ArrayList<List<Integer>>();
		bst.insert(100);
		int level = 0;
		expectValList.add(new ArrayList<Integer>());
		expectValList.get(level).add(100);
		
		
		level++;		
		expectValList.add(new ArrayList<Integer>());
		bst.insert(50);
		expectValList.get(level).add(50);
		bst.insert(150);
		expectValList.get(level).add(150);
		
		level++;
		expectValList.add(new ArrayList<Integer>());
		bst.insert(30);
		expectValList.get(level).add(30);		
		bst.insert(130);
		expectValList.get(level).add(130);
		bst.insert(180);
		expectValList.get(level).add(180);
		
		List<List<Integer>> lst = TreeUtil.levelOrderTraversal(bst.getRoot());
		String msg = "Input Tree : [ 100, 50, 150, 30, #, 130, 180 ]";
		assertNotNull(msg,lst);
		assertEquals(msg, expectValList.size(), lst.size());
		for(int index = 0; index < expectValList.size(); index++){
			List<Integer> eLst = expectValList.get(index);
			List<Integer> aLst = lst.get(index);
			assertEquals(msg, eLst.size(), aLst.size());
			for(int index1 = 0; index1 < eLst.size(); index1++){
				assertEquals(msg, eLst.get(index1), aLst.get(index1));
			}
		}
	}

	
	@Test
	public void testBFS_TreeWithSingleNode(){
		BinarySearchTree<Integer> bst = getTreeWithRootNode();
		Comparator<Integer> comp = getIntComparator();
		String msg = "Searching for values 0 to 9 in tree with values inserted in the same order : [ 1 ]";
		for(int i = 0 ; i < 10; i++){
			if( i == 1){
				BinaryTreeNode<Integer> node = TreeUtil.bfs(bst.getRoot(), i, comp); 
				assertNotNull(msg, node);
				assertEquals(msg,  1, node.getVal().intValue());
			}else{
				assertNull(TreeUtil.bfs(bst.getRoot(), i, comp));
			}
		}
	}
	
	@Test
	public void testBFS_RandomBST(){
		int MAX_ITER = 100;
		int MAX_SIZE = 10;
		
		for(int iter = 0 ; iter < MAX_ITER; iter++){
			List<Integer> lstVals = new ArrayList<Integer>();
			BinarySearchTree<Integer> bst = generateRandomIntTree(MAX_SIZE, lstVals, true);
			Comparator<Integer> comp = bst.getComp();
			String msg = "Searching for values " +lstVals +" in tree with values inserted in the same order : " +lstVals;
			for(int val : lstVals){
				BinaryTreeNode<Integer> node = TreeUtil.bfs(bst.getRoot(), val, comp); 
				assertNotNull(msg, node);
				assertEquals(msg,  val, node.getVal().intValue());
			}
			
			//Testing for values that do not exist
			for(int i = 0 ; i < 100; i++){
				if(!lstVals.contains(i)){
					assertNull(msg, TreeUtil.bfs(bst.getRoot(), i, comp));
				}
			}
		}
	}
	

	@Test
	public void testDFS_TreeWithSingleNode(){
		BinarySearchTree<Integer> bst = getTreeWithRootNode();
		Comparator<Integer> comp = getIntComparator();
		String msg = "Searching for values 0 to 9 in tree with values inserted in the same order : [ 1 ]";
		for(int i = 0 ; i < 10; i++){
			if( i == 1){
				BinaryTreeNode<Integer> node = TreeUtil.dfs(bst.getRoot(), i, comp); 
				assertNotNull(msg, node);
				assertEquals(msg,  1, node.getVal().intValue());
			}else{
				assertNull(TreeUtil.bfs(bst.getRoot(), i, comp));
			}
		}
	}
	
	@Test
	public void testDFS_RandomBST(){
		int MAX_ITER = 100;
		int MAX_SIZE = 10;
		
		for(int iter = 0 ; iter < MAX_ITER; iter++){
			List<Integer> lstVals = new ArrayList<Integer>();
			BinarySearchTree<Integer> bst = generateRandomIntTree(MAX_SIZE, lstVals, true);
			Comparator<Integer> comp = bst.getComp();
			String msg = "Searching for values " +lstVals +" in tree with values inserted in the same order : " +lstVals;
			for(int val : lstVals){
				BinaryTreeNode<Integer> node = TreeUtil.dfs(bst.getRoot(), val, comp); 
				assertNotNull(msg, node);
				assertEquals(msg,  val, node.getVal().intValue());
			}
			
			//Testing for values that do not exist
			for(int i = 0 ; i < 100; i++){
				if(!lstVals.contains(i)){
					assertNull(msg, TreeUtil.dfs(bst.getRoot(), i, comp));
				}
			}
		}
	}
}
