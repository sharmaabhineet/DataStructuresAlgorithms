/**
 * 
 */
package org.leIngeneursInc.problems.leetCode;

import java.util.Stack;

/**
 * Solves the problem 'Valid Parentheses' hosted on leetcode : https://leetcode.com/problems/valid-parentheses/
 * Here's the description of the problem :
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * Space Complexity : O(n)
 * Time Complexity : O(n)
 * 
 * @author Abhineet(sharma.abhineet31@gmail.com)
 *
 */
public class ParenthesisMatch {

	 public boolean isValid(String s) {
	        if( s== null || s.length() <= 0){
	            return true;
	        } else{
	            //do nothign here. go ahead
	        }
	        Stack<Character> objStack = new Stack<Character>();
	        char[] arr = s.toCharArray();
	        for(char ch : arr){
	            Operation op = getOp(ch);
	            if(op == Operation.PUSH){
	                objStack.push(ch);
	                continue;
	            } else if ( op == Operation.POP){
	                if (objStack.isEmpty()){
	                    return false;
	                }else if(objStack.pop() == getMatchingBracket(ch)){
	                    //do nothing here. 
	                    //continue
	                    continue;
	                } else{
	                    return false;
	                }
	            }else {
	                return false;
	            }
	        }
	        return objStack.isEmpty();
	    }
	    
	    private char getMatchingBracket(char ch){
	        switch(ch){
	            case ']':
	                return '[';
	            case ')':
	                return '(';
	            case '}':
	                return '{';
	            default:
	                return 0;
	        }
	    }
	    
	    private Operation getOp(char ch){
	        if( ch == '(' || ch == '{' || ch == '['){
	            return Operation.PUSH;
	        } else if ( ch == ')' || ch == '}' || ch == ']' ){
	            return Operation.POP;
	        } else{
	            return Operation.UNKNOWN;
	        }
	    }
	    
	    private enum Operation{
	        PUSH,
	        POP,
	        UNKNOWN
	    };
}
