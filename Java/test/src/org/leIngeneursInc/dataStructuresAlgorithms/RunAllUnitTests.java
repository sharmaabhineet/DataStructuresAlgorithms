package org.leIngeneursInc.dataStructuresAlgorithms;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.leIngeneursInc.dataStructuresAlgorithms.ctci.arraysAndStrings.test.StringBuilderTest;
import org.leIngeneursInc.dataStructuresAlgorithms.hashTables.test.HashTablesTest;
import org.leIngeneursInc.dataStructuresAlgorithms.lists.test.LinkedListTest;
import org.leIngeneursInc.dataStructuresAlgorithms.lists.test.UtilTest;
import org.leIngeneursInc.dataStructuresAlgorithms.sorting.test.SortTest;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.test.BinarySearchTreeTest;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.test.MinHeapTest;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.test.TreeUtilTest;


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