/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.ctci.arraysAndStrings;

/**
 * Solves the palindrome permutation question of CTCI
 * @author Abhineet (sharma.abhineet31@gmail.com)
 */
public class PalindromePermutation {
	
	/**
	 * Idea is that if any permutation of the given string is a palindrome, it would 
	 * have even number of characters and at most only character with an odd count.
	 * Scan the string count characters, and finally check if there are more than two 
	 * odd numbers in the array.
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 * @param inputStr the inputs string
	 * @return whether any permutation of input string is a palindrome
	 */
	public static boolean isPalindromePermutation(String inputStr){
		if(inputStr == null || inputStr.length() <= 0){
			return true;
		}else{
			//do nothing here. go ahead.
		}
		
		int[] arr = new int[26];
		int strLen = inputStr.length();
		for(int index =  0; index < strLen; index++){
			char ch = inputStr.charAt(index);
			if(ch >= 'a' && ch <= 'z'){
				arr[ch - 'a'] += 1;
			}else if( ch >= 'A' && ch <= 'Z'){
				arr[ch - 'A'] += 1;
			} else{
				//do nothing
			}
		}
		
		int oddCount = 0;
		for(int index =0 ; index < 26; index++){
			if(arr[index] % 2 != 0){
				oddCount++;
			}else{
				//do nothing
			}
		}
		
		return oddCount <= 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("VALID CASE -> Returns :  " +isPalindromePermutation("Tact Coa"));
		System.out.println("VALID CASE -> Returns :  " +isPalindromePermutation("Tact Coak"));
		System.out.println("VALID CASE -> Returns :  " +isPalindromePermutation("ab ba "));

	}

}
