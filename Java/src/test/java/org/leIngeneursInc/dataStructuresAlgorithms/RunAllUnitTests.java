package org.leIngeneursInc.dataStructuresAlgorithms;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.leIngeneursInc.dataStructuresAlgorithms.ctci.arraysAndStrings.StringBuilderTest;
import org.leIngeneursInc.dataStructuresAlgorithms.hashTables.HashTablesTest;
import org.leIngeneursInc.dataStructuresAlgorithms.lists.LinkedListTest;
import org.leIngeneursInc.dataStructuresAlgorithms.lists.UtilTest;
import org.leIngeneursInc.dataStructuresAlgorithms.sorting.SortTest;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.BinarySearchTreeTest;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.MinHeapTest;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.TreeUtilTest;

/**
 * 
 * Runs all the Unit tests
 * @author abhineet ( sharma.abhineet31@gmail.com )
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
   LinkedListTest.class,
   UtilTest.class,
   BinarySearchTreeTest.class,
   TreeUtilTest.class,
   HashTablesTest.class,
   StringBuilderTest.class,
   SortTest.class,
   MinHeapTest.class
})
public class RunAllUnitTests {   
}  	