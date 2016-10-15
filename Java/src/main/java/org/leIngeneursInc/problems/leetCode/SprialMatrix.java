/**
 * 
 */
package org.leIngeneursInc.problems.leetCode;

/**
 * Solves the spiral matrix - II problem hosted on leet code : https://leetcode.com/problems/spiral-matrix-ii/
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 *  ]
 * 
 * Time Complexity : O(n)
 * Space Complexity : O(1) [Not counting the matrix to be returned]
 * 
 * @author Abhineet(sharma.abhineet31@gmail.com)
 *
 */
public class SprialMatrix {
	
	public static void main(String[] args){
		printMatrix(new SprialMatrix().generateMatrix2(4));
	}
	
	private static void printMatrix(int[][] mat){
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[i].length; j++){
				System.out.print(mat[i][j] +"\t");
			}
			System.out.println("");
		}
	}
	
	public int[][] generateMatrix2(int n) {
        int[][] retMat = new int[n][n];
		int count = 1;
		boolean  across = true;
		int iterPerLoop = n;
		int i = 0;
		int j = 0;
		// 0 -> Right , 1 -> down, 2-> left, 3 -> Up
		int dirCode = 0;
		int iterCount = 0;
		while(count <= n * n ){
			//System.out.println(i +" - " +j +" = " +count);
			retMat[i][j] = count++;
			iterCount++;
			if(iterCount == iterPerLoop){
				dirCode = (++dirCode) % 4;
				if(dirCode == 1 || dirCode == 3){
					iterPerLoop--;
				}
				//System.out.println("\t" +dirCode +" -- " +iterPerLoop);
				iterCount = 0;
			}
			switch(dirCode){
			case 0:
				j++;
				break;
			case 1:
				i++;
				break;
			case 2:
				j--;
				break;
			case 3:
				i--;
				break;
			default:
				System.err.println("INVALID CODE.. U R Going in Wrong Direction.");
			}
		}

		return retMat;
    }
}
