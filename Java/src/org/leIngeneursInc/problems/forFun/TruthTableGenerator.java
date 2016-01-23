/**
 * 
 */
package org.leIngeneursInc.problems.forFun;

import java.util.Arrays;

/**
 * Generates a Truth table given n variables.
 * @author Abhineet (sharma.abhineet31@gmail.com)
 *
 */
public class TruthTableGenerator {

	/**
	 * Generates a binary values table containing all the possible combinations 
	 * of assignment to given number of variables
	 * Time Complexity : O(n*(2^n))
	 * Space Complexity : O(n*(2^n)) ( inclusive of the matrix as the end result ) 
	 * Can be made more efficient using byte array and bitwise operations
	 * @param vars the number of variables for which the table has to be generated
	 * @return
	 */
	public static byte[][] generateBinaryValueTable(int vars){
		if(vars <= 0){
			throw new IllegalArgumentException("Number of variables must be greater than 0");
		} else{
			//do nothing here. go ahead
		}
		
		int numRows = (int)Math.pow(2, vars);
		byte[][] retArr = new byte[numRows][];
		byte[] startArr = new byte[vars];
		retArr[0] = startArr;
		for(int iter = 1; iter < numRows; iter++){
			retArr[iter] = addOne(retArr[iter-1]);
		}
		return retArr;
	}
	
	/**
	 * Add one to the array of binary values to creaate a new array
	 * @param arr
	 * @return
	 */
	private static byte[] addOne(byte[] arr){
		if(arr == null || arr.length <= 0){
			throw new IllegalArgumentException("Array can not be null and must be of size greater than 0");
		}else{
			//do nothing here. go ahead
		}
		
		byte[] retArr = new byte[arr.length];
		//Initially keeping carryOne to true in order to add 1 to the last digit
		// Helps in avoiding handling a special case.
		boolean carryOne = true;
		for(int index = arr.length - 1; index >= 0 ; index --){
			if(carryOne){
				if(arr[index] == (byte)1){
					retArr[index] = (byte)0;
				}else{
					carryOne = false;
					retArr[index] = (byte)1;
				}
			}else{
				retArr[index] = arr[index];
			}
		}
		return retArr;
	}
	
	
	private static void print2dArray(byte[][] arr){
		for(int i =0; i < arr.length ; i++){
			for(int j =0 ; j < arr[i].length; j++){
				System.out.print(arr[i][j] +"\t");
			}
			System.out.println("");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		print2dArray(generateBinaryValueTable(20));

	}

}
