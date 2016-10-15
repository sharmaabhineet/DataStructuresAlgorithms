/**
 * 
 */
package org.leIngeneursInc.problems.fbHackerCup2016;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Abhineet (sharma.abhineet31@gmail.com)
 *
 */
// This solution does not work on large inputs.
public class TextEditor {

	private static final String DIR_PATH = "src/org/leIngeneursInc/problems/fbHackerCup2016/";
	private static final String FILE_NAME = "text_editor.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner objScanner = new Scanner(new File(DIR_PATH + FILE_NAME));
			PrintWriter pw = new PrintWriter(new File(DIR_PATH + FILE_NAME +"_out.txt"));
			int numTestCases = Integer.parseInt(objScanner.nextLine());
			for(int testCase = 1; testCase <= numTestCases; testCase++){
				String[] arrTokens = objScanner.nextLine().split(" ");
				int N = Integer.parseInt(arrTokens[0]);
				int K = Integer.parseInt(arrTokens[1]);
				Set<Integer> setIndices = new HashSet<Integer>();
				int[][] distMat = new int[N][N];
				String[] arrWords = new String[N];
				for(int index = 0; index < N ; index++){
					arrWords[index] = objScanner.nextLine();
					setIndices.add(index);
				}
				
				for(int i = 0; i < N; i++){
					for(int j = i +1; j < N ; j ++){
						distMat[i][j] = typeDistance(arrWords[i], arrWords[j]);
					}
				}
				
				System.out.println("Calculated Dist Mat ");
				
				int minOp = getMinOpCount(arrWords, K, -1, setIndices, distMat);
				
				String output = "Case #" +testCase +": " +minOp;
				pw.println(output);
				System.out.println(output +" ( of " +numTestCases +" test cases )");
			}
			objScanner.close();
			pw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static int getMinOpCount(String[] arrWords, int K, int prevWordIndex, Set<Integer> availableIndices,
			int[][] distMat){
		if(K == 1){
			int minOpCount = Integer.MAX_VALUE;
			for(int index : availableIndices){
				int val = 0;
				if(prevWordIndex == -1){
					// There is no previous word. Need to type in the word
					val += arrWords[index].length();
				}else {
					// Distance needed to go from previous word to this word
					val += Math.max(distMat[prevWordIndex][index], distMat[index][prevWordIndex]);
				}
				val += arrWords[index].length();
				// 1 to print
				val++;
				if(val < minOpCount){
					minOpCount = val;
				}
			}
			return minOpCount;
		} else{
			// fun begins here
			int[] arrOpCounts = new int[availableIndices.size()];
			int opCountIndex = 0;
			for(int index : availableIndices){
				Set<Integer> newSet = new HashSet<Integer>(availableIndices);
				newSet.remove(index);
				if(prevWordIndex == -1){
					// If there is no word printed. it is the length of the word
					arrOpCounts[opCountIndex] = arrWords[index].length();
				}else{
					// Otherwise it is the distance from the previous word
					arrOpCounts[opCountIndex] = Math.max(distMat[prevWordIndex][index], distMat[index][prevWordIndex]);
				}
				// Min count after printing this word +1 for the print command
				arrOpCounts[opCountIndex] +=  getMinOpCount(arrWords, K -1, index, newSet, distMat) + 1;
				opCountIndex++;
			}
			int minVal = Integer.MAX_VALUE;
			for(int opCount : arrOpCounts){
				if (minVal > opCount){
					minVal = opCount;
				}
			}
			return minVal;
		}
	}
	


	// Minimum distance between str1 and str2
	private static int typeDistance(String str1, String str2) {
		// System.out.println("Processing " +str1 +" -- " +str2);
		int index = 0;
		int dist = 0;
		while (index < str1.length() && index < str2.length() && str1.charAt(index) == str2.charAt(index)) {
			index++;
		}
		str1 = str1.substring(index);
		str2 = str2.substring(index);
		// System.out.println("\t After Removing same portions : " +str1 +" -- "
		// +str2);
		dist += Math.abs(str1.length() - str2.length());
		dist += 2 * Math.min(str1.length(), str2.length());
		// System.out.println("DISTANCE : " +dist);
		// System.out.println("\n---------------------------\n\n");
		return dist;
	}

}
