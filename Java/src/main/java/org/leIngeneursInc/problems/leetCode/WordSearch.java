/**
 * 
 */
package org.leIngeneursInc.problems.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * This Solves <a href="https://leetcode.com/problems/word-search/">Word Search problem</a>
 *  hosted on Leet Code : https://leetcode.com/problems/word-search/
 * 
 * Here's the description : 
 * Given a 2D board and a word, find if the word exists in the grid.

 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * For example,
 * Given board =
 * 
 * 	[
 * 	 ['A','B','C','E'],
 * 	 ['S','F','C','S'],
 * 	 ['A','D','E','E']
 * 	]
 *
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * The implemented aglorithm works correctly. But there is a lot of scope for performance improvement here. 
 * Removing the recursive calls should help a lot in performance improvement.
 * 
 * Overview of Algorithm : 
 * 	For each cell containing the starting character of word, do
 * 		1. Add the starting index to a visited set
 * 		2. Search for the next character in the word in the neighborhood of this cell
 * 		3. If character found, 
 * 				a. If there are more characters in the word, Run step 1 & 2 starting from the index of next char [Recursive Step]
 * 				b. Else, Return true
 * 		4. Else, continue with the next index of the first character on the board 
 * 
 * @author Abhineet ( sharma.abhineet31@gmail.com )
 *
 */
public class WordSearch {
	
	public boolean exist(char[][] board, String word) {
        if(board == null || board.length <= 0 || board[0].length <= 0 || word == null || word.length() <= 0){
            return false;
        } else{
            //do nothing here. go ahead
        }
        int nRows = board.length;
        //assuming board to be an m x n matrix
        int nCols = board[0].length;
        char ch = word.charAt(0);
        for(int i =0 ; i < nRows; i++){
            for(int j = 0; j < nCols; j++){
                if(ch == board[i][j]){
                    //we got index of interest
                    Set<Integer> setIndex = new HashSet<Integer>();
                    if(findRecursive(1, word, i, j, board, nRows, nCols, setIndex)){
                        return true;
                    }
                    else{
                        //do nothing here. continue    
                    }
                }
                else{
                    //do nothing continue.
                }
            }
        }
        return false;
    }
	
	 private boolean findRecursive(int currIndex, String word, int i, int j, char[][] board, int nRows, int nCols, Set<Integer> setIndex){
	        setIndex.add(i * nCols + j);
	        if(currIndex >= word.length()){
	            return true;
	        }
	        
	        char ch = word.charAt(currIndex);
	        //for(int iter =0 ; iter< currIndex; iter++){
	        //   System.out.print("\t");
	        //}
	        //System.out.println("Looking for " +ch +" around [" +i +"," +j +"]" +" -- " +board[i][j]);
	        if(i-1 >= 0 && board[i-1][j] == ch && !setIndex.contains((i-1) * nCols + j) && findRecursive( currIndex + 1, word, i-1, j, board, nRows, nCols, new HashSet(setIndex))){
	            return true;
	        } else{
	            //do nothing
	        }

	        if(i+1 < nRows && board[i+1][j] == ch && !setIndex.contains((i+1) * nCols + j) && findRecursive(currIndex + 1, word, i +1 , j, board, nRows, nCols, new HashSet(setIndex))){
	            return true;
	        } else{
	            //do nothing
	        }
	        
	        if( j-1 >= 0 && board[i][j-1] == ch && !setIndex.contains(i * nCols + j-1) && findRecursive(currIndex +1 , word, i, j-1, board, nRows, nCols, new HashSet(setIndex))){
	            return true;
	        } else{
	            //do nothing
	        }
	        
	        if( j+1 < nCols && board[i][j+1] == ch && !setIndex.contains(i * nCols + j+1) && findRecursive(currIndex + 1, word, i , j +1, board, nRows, nCols, new HashSet<Integer>(setIndex)) ){
	            return true;
	        }else{
	            //do nothing
	        }
	        return false;
	    }
}
