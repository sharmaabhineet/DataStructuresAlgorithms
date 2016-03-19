/**
 * 
 */
package org.leIngeneursInc.problems.forFun;

/**
 * Class that solves the Longest Common Subsequence problem. A detailed
 * description can be found at
 * :http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-
 * subsequence/ or Wikipedia
 * 
 * @author Abhineet ( sharma.abhineet31@gmail.com )
 *
 */
public class LongestCommonSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "XMJYAUZ";
		String str2 = "MZJAWXU";
		System.out.println(str1 +" v/s " +str2 );
		System.out.println(LCS(str1, str2));

	}

	public static String LCS(String str1, String str2) {
		if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
			return "";
		} else {
			// do nothing here
		}
		int len1 = str1.length();
		int len2 = str2.length();
		// following array represents string1 along the rows
		// and string2 along the cols
		int[][] scoreArr = new int[len1 + 1][len2 + 1];
		// Initializing all the values not in the 0th row and 0th col
		// to -1.
		for (int row = 1; row < len1 + 1; row++) {
			for (int col = 1; col < len2 + 1; col++) {
				scoreArr[row][col] = -1;
			}
		}
		//printArr(scoreArr);

		LCSRec(str1, str2, scoreArr, str1.length(), str2.length());
		System.out.println("LENGTH OF SUBSEQ : " +scoreArr[str1.length()][str2.length()]);
		printArr(scoreArr);
		String retString = backtrack(scoreArr, str1, str2, str1.length() , str2.length());
		System.out.println("STRING : " + retString);
		return retString;
	}

	public static String backtrack(int[][] scoreArr, String str1, String str2, int i , int j) {
		if(i==0 || j == 0){
			return "";
		}else if (str1.charAt(i-1) == str2.charAt(j-1)){
			return backtrack(scoreArr, str1, str2, i-1, j -1) +str1.charAt(i-1);
		} else{
			if(scoreArr[i][j-1] > scoreArr[i-1][j]){
				return backtrack(scoreArr, str1, str2, i, j -1);
			}else{
				return backtrack(scoreArr, str1, str2, i-1, j);
			}
		}
	}

	private static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println("");
		}
	}

	private static int LCSRec(String str1, String str2, int[][] scoreArr, int len1, int len2) {
		//System.out.println("SCORE [" + len1 + " ] [ " + len2 + " ] = " + scoreArr[len1][len2]);
		if (scoreArr[len1][len2] != -1) {
			return scoreArr[len1][len2];
		} else {
			// do ntohign here. go ahead.
		}
		//System.out.println("\t" + str1 + " ( " + str1.length() + " ) v/s " + str2 + " ( " + str2.length() + " )");
		char ch1 = str1.charAt(len1-1);
		char ch2 = str2.charAt(len2-1);
		if (ch1 == ch2) {
			scoreArr[len1][len2] = LCSRec(str1.substring(0, len1-1), str2.substring(0, len2-1), scoreArr, len1 - 1,
					len2 - 1) + 1;
		} else {
			scoreArr[len1 - 1][len2] = LCSRec(str1.substring(0, len1-1), str2, scoreArr, len1 - 1, len2);
			scoreArr[len1][len2 - 1] = LCSRec(str1, str2.substring(0, len2-1), scoreArr, len1, len2 - 1);
			scoreArr[len1][len2] = Math.max(scoreArr[len1 - 1][len2], scoreArr[len1][len2 - 1]);
		}
		return scoreArr[len1][len2];
	}

}
