package org.leIngeneursInc.dataStructuresAlgorithms;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.leIngeneursInc.dataStructuresAlgorithms.lists.test.LinkedListTest;
import org.leIngeneursInc.dataStructuresAlgorithms.lists.test.UtilTest;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.test.BinarySearchTreeTest;
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
   TreeUtilTest.class
})
public class RunAllUnitTests {   
}  	