/**
 * 
 */
package org.leIngeneursInc.problems.fbHackerCup2016;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Abhineet
 *
 */

/*
 * PROBLEM STATEMENT
 * The night sky can be modeled as an infinite 2D plane. There are N stars at distinct positions on this plane, the ith of which is at coordinates (Xi, Yi).

A boomerang constellation is a pair of distinct equal-length line segments which share a single endpoint, such that both endpoints of each segment coincide with a star's location.

Two boomerang constellations are distinct if they're not made up of the same unordered pair of line segments. How many distinct boomerang constellations can you spot?

Input
Input begins with an integer T, the number of nights on which you look out at the sky. For each night, there is first a line containing the integer N. Then, N lines follow, the ith of which contains the space-separated integers Xi and Yi.

Output
For the ith night, print a line containing "Case #i: " followed by the number of boomerang constellations in the night sky.

Constraints
1 ≤ T ≤ 50 
1 ≤ N ≤ 2,000 
-10,000 ≤ Xi, Yi ≤ 10,000 
Explanation of Sample
On the first night, every pair of stars is a unique distance apart, so there are no boomerang constellations. On the second night, there are 4 boomerang constellations. One of them consists of the line segments (0,0)-(0,2) and (0,2)-(0,4).

Example input · DownloadExample output · Download
5
3
0 0
0 1
0 3
5
0 0
0 1
0 2
0 3
0 4
4
0 0
0 100
100 0
100 100
4
0 0
-3 4
0 5
-5 0
6
5 6
6 5
7 6
6 7
7 8
8 7

ANS : 
Case #1: 0
Case #2: 4
Case #3: 4
Case #4: 3
Case #5: 12
 */
public class BoomerangConstellation {
	
	private static final String DIR_PATH = "D:/Downloads/";
	private static final String FILE_NAME = "boomerang_constellations.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner objScanner = new Scanner(new File(DIR_PATH +FILE_NAME));
			PrintWriter pw = new PrintWriter(new File(DIR_PATH +FILE_NAME +"out.txt"));
			int numTestCases = Integer.parseInt(objScanner.nextLine());
			for(int testCase = 1; testCase <= numTestCases; testCase++){
				int numPoints = Integer.parseInt(objScanner.nextLine());
				int[][] points = new int[numPoints][2];
				for(int point = 0; point < numPoints; point++){
					String[]  tokens = objScanner.nextLine().split(" ");
					points[point][0] = Integer.parseInt(tokens[0]);
					points[point][1] = Integer.parseInt(tokens[1]);
				}
				int boomerangCount = 0;
				for(int iter1 = 0; iter1 < numPoints; iter1++){
					for(int iter2 = iter1 + 1; iter2 < numPoints; iter2++){
						for(int iter3 = iter2 + 1; iter3 < numPoints; iter3++){
							if(isPointsSetBoomerang(points, iter1, iter2, iter3)){
								boomerangCount++;
							}
						}
					}
				}
				String output = "Case #"+testCase +": " +boomerangCount;
				pw.println(output);
				System.out.println(output);
			}
			objScanner.close();
			pw.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	private static boolean isPointsSetBoomerang(int[][] points, int p1Index, int p2Index, int p3Index){
		double p1p2 = Math.pow(points[p1Index][0] - points[p2Index][0], 2) + Math.pow(points[p1Index][1] - points[p2Index][1], 2);
		double p2p3 = Math.pow(points[p2Index][0] - points[p3Index][0], 2) + Math.pow(points[p2Index][1] - points[p3Index][1], 2);
		double p1p3 = Math.pow(points[p1Index][0] - points[p3Index][0], 2) + Math.pow(points[p1Index][1] - points[p3Index][1], 2);
		return p1p2 == p2p3 || p2p3 == p1p3 || p1p3 == p1p2;
	}

}
