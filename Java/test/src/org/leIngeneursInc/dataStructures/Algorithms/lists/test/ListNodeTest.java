/**
 * 
 */
package org.leIngeneursInc.dataStructures.Algorithms.lists.test;

import java.util.Vector;

import org.jtestcase.JTestCase;
import org.jtestcase.JTestCaseException;
import org.jtestcase.TestCaseInstance;

import junit.framework.TestCase;

/**
 * Class for automated testing of ListNode class
 * @author Abhineet ( sharma.abhineet31@gmail.com )
 */
public class ListNodeTest extends TestCase{
	private JTestCase jTestCase = null;
	
	public ListNodeTest(String name){
		super(name);
		String dataFilePath = "ListNodeTest.xml";
		
		try{
			jTestCase = new JTestCase(dataFilePath, "ListNode");
		} catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	public void testGetVal(){
		if(jTestCase == null){
			fail("Could not read the test case file : ListNodeTest.xml") ;
		} else {
			//do nothign here. go ahead
		}
		
		final String METHOD = "getVal";
		Vector testCases = null;
		try {
			testCases = jTestCase.getTestCasesInstancesInMethod(METHOD);
		} catch (JTestCaseException e) {
			fail(e.getMessage());
		}
		for(int index = 0; index < testCases.size(); index++){
			//Get the name of test Case
			TestCaseInstance testCase = (TestCaseInstance) testCases.elementAt(index);
		}
	}
}
