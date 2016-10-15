/**
 * 
 */
package org.leIngeneursInc.problems.ctci.arraysStrings;

import java.util.Arrays;

/**
 * Class that determines if a string has all unique characters
 * @author Abhineet(sharma.abhineet31@gmail.com)
 */
public class UniqueCharactersInString {
	/**
	 * Determines if a string has all unique characters
	 * Runtime : O(nlogn)
	 * Space : O(n) : as it reduces the input string to character array in order to save runtime
	 * @param inputStr the input string
	 * @param caseSensitive boolean value specifying whether the operation has to be case sensitive or not
	 * @return boolean value indicating whether or not the input string has all unique characters
	 */
	public static boolean hasUniqueCharacters(String inputStr, boolean caseSensitive){
		if(inputStr == null || inputStr.length() <= 0 ) {
			return true;
		} else{
			//do nothing here. go ahead
		}
		if(!caseSensitive){
			// Still takes O(n) space and O(n) time
			inputStr = inputStr.toLowerCase();
		} else{
			//do nothing here. we are good to go.
		}
				
		// This operation also takes O(n) space and O(n) time
		char[] arrChar = inputStr.toCharArray();
		//Takes O(nlogn) time
		Arrays.sort(arrChar);
		
		//Following for loop takes O(n) time
		for(int i = 0; i < arrChar.length - 1; i++){
			if(arrChar[i] == arrChar[i+1]){
				return false;
			}else{
				//continue
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		System.out.println("Test Unique Characters in String : ");
		System.out.println("After the first test case, odd test case number implies case sensitive and even test case number implies case insensitive");
		//Test Case 1 : NULL String
		{
			System.out.println("Test Case 1 : <Null String> --> \t\t" +hasUniqueCharacters(null, true));
		}
		
		//Test Case 2 : Empty String , Case Sensitive
		{
			System.out.println("Test Case 2 : <Empty String> \"\" --> \t\t" +hasUniqueCharacters("", true));
		}
		
		//Test Case 3 : Empty String , Case Insensitive
		{
			System.out.println("Test Case 3 : <Empty String> \"\" --> \t\t" +hasUniqueCharacters("", false));
		}
		
		//Test Case 4 : ABCDEF , Case Insensitive
		{
			System.out.println("Test Case 4 : \"ABCDEF\" --> \t\t" +hasUniqueCharacters("ABCDEF", false));
		}
		
		//Test Case 5 : ABCDEF , Case Sensitive
		{
			System.out.println("Test Case 5 : \"ABCDEF\" --> \t\t" +hasUniqueCharacters("ABCDEF", true));
		}
		
		//Test Case 6 : ABCCDEF , Case Insensitive
		{
			System.out.println("Test Case 6 : \"ABCCDEF\" --> \t\t" +hasUniqueCharacters("ABCCDEF", false));
		}
		
		//Test Case 7 : ABCCDEF , Case Sensitive
		{
			System.out.println("Test Case 7 : \"ABCCDEF\" --> \t\t" +hasUniqueCharacters("ABCCDEF", true));
		}
		
		//Test Case 8 : AABCDEF , Case Insensitive
		{
			System.out.println("Test Case 8 : \"AABCDEF\" --> \t\t" +hasUniqueCharacters("AABCDEF", false));
		}
		
		//Test Case 9 : ABCCDEF , Case Sensitive
		{
			System.out.println("Test Case 9 : \"AABCDEF\" --> \t\t" +hasUniqueCharacters("AABCDEF", true));
		}
		
		//Test Case 10 : ABCDEFF , Case Insensitive
		{
			System.out.println("Test Case 10 : \"ABCDEFF\" --> \t\t" +hasUniqueCharacters("ABCDEFF", false));
		}
		
		//Test Case 11 : ABCCDEFF , Case Sensitive
		{
			System.out.println("Test Case 11 : \"ABCDEFF\" --> \t\t" +hasUniqueCharacters("ABCDEFF", true));
		}
		
		//Test Case 12 : ABCDEFf , Case Insensitive
		{
			System.out.println("Test Case 12 : \"ABCDEFf\" --> \t\t" +hasUniqueCharacters("ABCDEFf", false));
		}
		
		//Test Case 13 : ABCCDEFF , Case Sensitive
		{
			System.out.println("Test Case 13 : \"ABCDEFf\" --> \t\t" +hasUniqueCharacters("ABCDEFf", true));
		}
		
		
	}
}
