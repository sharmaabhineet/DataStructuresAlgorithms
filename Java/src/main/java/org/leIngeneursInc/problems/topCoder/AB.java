/**
 * 
 */
package org.leIngeneursInc.problems.topCoder;

/**
 * Problem Statement
 * You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:
 * The string has exactly N characters, each of which is either 'A' or 'B'.
 * The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
 * If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
 * 
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * 
 * @author Abhineet(sharma.abhineet31@gmail.com)
 *
 */
public class AB{
	
	public static void main(String[] args){
		System.out.println("<ANS>\"" +new AB().createString(10,13) +"\"</Ans>");
	}
	
    public String createString(int N, int K){
    	return createStringRec(N, K, 0);
    }
    
    private String createStringRec(int N, int K, int iter){
    	//System.out.println("N = " +N +"\tK = " +K +"\tIter = " +iter);
    	if(K > N * (N - 1) / 2){
    		// so good 
    		return "";
    	} else if (K <= N - 1){
    		char[] arr = new char[N];
    		for(int index=0; index <N; index++){
    			arr[index] = 'B';
    		}
    		arr[N- 1 -K] = 'A';
    		return new String(arr);
    	}else{
    		String str = createStringRec(N-1, K - (N - 1) + iter + 1, iter + 1);
    		if("".equals(str)){
    			return "";
    		}else{
    			return "A" +str;
    		}
    	}

    }
}
