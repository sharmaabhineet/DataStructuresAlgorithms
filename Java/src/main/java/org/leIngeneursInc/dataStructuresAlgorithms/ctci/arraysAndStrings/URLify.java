/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.ctci.arraysAndStrings;

/**
 * @author Abhineet
 *
 */
public class URLify {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = " Mr John Smith         ";
		char[] arr = str.toCharArray();
		urlify(arr, 15);
		System.out.println(new String(arr));
	}

	
	/**
	 * This is solution to inplace URLify question in CTCI.
	 * Following information is provided :
	 * 1. arrChars have enough space to hold the entire urlified string
	 * 2. True length of the string is given.
	 * Time Complexity 	: 	O(n)
	 * Space Complexity : 	O(1) 
	 * @param arrChars the array of characters, large enough to hold the modified string
	 * @param trueLen the true length of the string
	 */
	public static void urlify(char[] arrChars, int trueLen ){
		int strIndex = trueLen - 1;
		int arrIndex = arrChars.length - 1;
		while(strIndex >= 0){
			if(arrChars[strIndex] == ' ' ){
				arrChars[arrIndex] = '0';
				arrChars[arrIndex - 1 ] = '2';
				arrChars[arrIndex - 2 ] = '%';
				arrIndex -= 3;
			}else{
				arrChars[arrIndex--] = arrChars[strIndex]; 
			}
			strIndex--;
		}
	}
}
