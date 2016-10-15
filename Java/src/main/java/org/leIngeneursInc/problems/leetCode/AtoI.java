/**
 * 
 */
package org.leIngeneursInc.problems.leetCode;

/**
 * Solution to atoi problem hosted on leetcode : https://leetcode.com/problems/string-to-integer-atoi/
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 * 
 * Requirements for atoi:
 * 		The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * 		The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * 		If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * 		If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * 
 * @author Abhineet (sharma.abhineet31@gmail.com)
 *
 */
public class AtoI {
	 public static int myAtoi(String str) {
	        str = str.trim();
	        if(str == null || str.length() <= 0){
	            return 0;
	        }
	        
	        int sign = 1;
	        if(str.charAt(0) == '-'){
	            sign = -1;
	            str = str.substring(1);
	        } else if (str.charAt(0) == '+'){
	            str = str.substring(1);
	        }else {
	            //do nothing
	        }
	        int[] arr = new int[str.length()];
	        int index = 0;
	        for(; index < str.length(); index++){
	            arr[index] = str.charAt(index) - 48;
	            if(arr[index] < 0 || arr[index] > 9){
	                break;
	            } else{
	                //carry on
	            }
	        }
	        int retVal = 0;
	        int multiplier = (int) Math.pow(10, index -1 );
	        for(int i = 0; i < index ; i++){
	            int numToBeAdded = multiplier * arr[i];
	            if(sign == 1 && (long)retVal + numToBeAdded > Integer.MAX_VALUE){
	                return Integer.MAX_VALUE;
	            } else if (sign == -1 && -(long)numToBeAdded - retVal < Integer.MIN_VALUE ){
	                return Integer.MIN_VALUE;
	            } else {
	                retVal += numToBeAdded;
	            }
	            multiplier /= 10;
	        }
	       
	        return sign * retVal;
	    }
}
