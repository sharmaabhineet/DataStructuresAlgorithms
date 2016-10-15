/**
 * 
 */
package org.leIngeneursInc.problems.ctci.arraysStrings;

/**
 * Performs basic string compression. For e.g. : aabcccccaaa is compressed to : a2b1c5a3.
 * 
 * @author Abhineet(sharma.abhineet31@gmail.com)
 *
 */
public class BasicStringCompressor {
	
	/**
	 * Compresses the string by appending the number of repititions after each character. Returns the original string if there are no repititions
	 * Time Complexity : O(n)
	 * Space complexity : O(n)
	 * @param inputStr the input string
	 * @return the compressed string, if compression needed. Original String otherwise.
	 */
	public static String compress(String inputStr){
		if(inputStr == null || inputStr.length() <= 0){
			return inputStr;
		} else{
			//do nothign here. We got work to do
		}
		
		StringBuffer strBuf = new StringBuffer();
		int currCount = 1;
		boolean atLeastOneRep = false;
		char currChar = inputStr.charAt(0);
		int index = 1;
		while(index < inputStr.length()){
			if(inputStr.charAt(index) == currChar){
				atLeastOneRep = true;
				currCount++;
			}else{
				strBuf.append(currChar);
				strBuf.append(currCount);
				currChar = inputStr.charAt(index);
				currCount = 1;
			}
			index++;
		}
		strBuf.append(currChar);
		strBuf.append(currCount);
		
		if(atLeastOneRep){
			return strBuf.toString();
		}else{
			return inputStr;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		runTestCase(1, null, null);
		runTestCase(2, "", "");
		runTestCase(3, "abc", "abc");
		runTestCase(4, "aabc", "a2b1c1");
		runTestCase(5, "abbc", "a1b2c1");
		runTestCase(6, "abcc", "a1b1c2");
		runTestCase(7, "aabcccccaaa", "a2b1c5a3");
		System.out.println("SUMMARY : " +passCount +" passed out of " +(passCount + failCount));
	}
	
	
	private static int passCount = 0;
	private static int failCount = 0;
	
	private static void runTestCase(int testCaseNum, String inputStr , String expectedVal){
		System.out.println("===================================");
		System.out.println("Running Test Case # " +testCaseNum +" : ");
		System.out.println("\t Input String : " +inputStr);
		String output = compress(inputStr);
		if( (output == null && expectedVal == null ) || output.equals(expectedVal)){
			System.out.println("\t\t==> RESULT : PASSED");
			passCount++;
		} else{
			System.out.println("\t\t==> RESULT : FAILED\n\t\tExpected : " +expectedVal +"\tActual : " +output);
			failCount++;
		}
		System.out.println("===================================");
	}
	
}
