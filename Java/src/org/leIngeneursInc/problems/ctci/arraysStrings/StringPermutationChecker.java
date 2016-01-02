/**
 * 
 */
package org.leIngeneursInc.problems.ctci.arraysStrings;

import java.util.Arrays;

/**
 * Class that checks if two strings are permutation of each other
 * @author Abhineet(sharma.abhineet31@gmail.com)
 *
 */
public class StringPermutationChecker {

	/**
	 * Checks whether the input strings are permutation of each other.
	 * Time Complexity : O(nlogn)
	 * Space Complexity : O(n) [ Reduces input strings to character arrays ]
	 * @param str1 input string # 1
	 * @param str2 input string # 2
	 * @return boolean value indicating whether or not the input strings are permutation of each other
	 */
	public static boolean checkPermutation(String str1, String str2, boolean caseSensitive){
		if(str1 == null && str2 == null){
			return true;
		} else if (str1 == null || str2 == null){
			return false;
		} else {
			//do nothing here.
		}
		
		int len1 = str1.length();
		int len2 = str2.length();
		if(len1 != len2 ){
			return false;
		} else if ( len1 == 0){
			return true;
		} else{
			// do nothing here. Now we are ready to go ahead.
		}
		
		if(!caseSensitive){
			//Following operations take O(n) time
			str1 = str1.toLowerCase();
			str2 = str2.toLowerCase();
		}
		
		char[] arrChar1 = str1.toCharArray();
		Arrays.sort(arrChar1);
		char[] arrChar2 = str2.toCharArray();
		Arrays.sort(arrChar2);
		//len1 is same as len2. Either value c an be used in the for loop.
		for(int i = 0; i < len1; i++){
			if(arrChar1[i] != arrChar2[i]){
				return false;
			}else{
				//continue
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		runTestCase(1, null, null, true, true);
		runTestCase(2, null, null, false, true);
		runTestCase(3, "", "", true, true);
		runTestCase(4, "", "", false, true);
		runTestCase(5, "abc", "bca", true, true);
		runTestCase(6, "abc", "bca", false, true);
		runTestCase(7, "abc", "bce", true, false);
		runTestCase(8, "abc", "bce", false, false);
		runTestCase(9, "abc", "bcA", true, false);
		runTestCase(10, "abc", "bcA", false, true);
		runTestCase(11, "aabc", "bca", false, false);
		System.out.println("SUMMARY : " +passCount +" passed out of " +(passCount + failCount));
	}
	
	private static int passCount = 0;
	private static int failCount = 0;
	
	private static void runTestCase(int testCaseNum, String str1 , String str2, boolean caseSensitive, boolean expectedVal){
		System.out.println("===================================");
		System.out.println("Running Test Case # " +testCaseNum +" : ");
		System.out.println("\t Str1 : " +str1);
		System.out.println("\t Str2 : " +str2);
		System.out.println("\t Case Sensitive : " +caseSensitive);
		boolean result = checkPermutation(str1, str2, caseSensitive); 
		if(result == expectedVal){
			System.out.println("\t\t==> RESULT : PASSED");
			passCount++;
		} else{
			System.out.println("\t\t==> RESULT : FAILED\n\t\tExpected : " +expectedVal +"\tActual : " +result);
			failCount++;
		}
		System.out.println("===================================");
	}

}
