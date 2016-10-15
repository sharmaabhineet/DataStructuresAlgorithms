/**
 * 
 */
package org.leIngeneursInc.problems.leetCode;

import java.util.Stack;

/**
 * Solves simplify path problem hosted on leet code : https://leetcode.com/problems/simplify-path/
 * 
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases : 
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * @author Abhineet(sharma.abhineet31@gmail.com)
 *
 */
public class SimplifyPath {
	
	public static void main(String[] args){
		System.out.println("<Ans>\"" +new SimplifyPath().simplifyPath("/../../.././a/../b") +"\"</Ans>");
	}
	
	 public String simplifyPath(String path) {
	        Stack<String> stck = new Stack<String>();
	        String[] arr = path.split("/");
	        StringBuffer strBuf = new StringBuffer();
	        if(path.charAt(0) == '/'){
	            strBuf.append('/');
	        } else{
	            //do nothign here. Relative path
	        }
	        for(String token : arr){
	            if(token.length() <= 0 ){
	                continue;
	            }else{
	                if(".".equals(token)){
	                    //do nothing. continue.
	                    continue;
	                } else if ("..".equals(token)){
	                    if(!stck.isEmpty()){
	                        stck.pop();
	                    } else {
	                        //do nothing. Corner case E.g. : /.. ==> remains at /
	                    }
	                } else{
	                    stck.push(token);
	                }
	            }
	        }
	        int contentLenAdded = 0;
	        if(stck.isEmpty()){
	            //do nothing here
	        } else{
	            while(!stck.isEmpty()){
	                strBuf.insert(1, stck.pop() +"/");
	            } 
	            strBuf.deleteCharAt(strBuf.length() -1 );
	        }
	        return strBuf.toString();
	    }
}
