package org.leIngeneursInc.problems.fbHackerCup2016;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Abhineet (sharma.abhineet31@gmail.com)
 *
 */

/*
You've managed to become a contestant on the hottest new game show, The Price is Correct!

After asking you to come on down to the stage, the show's host presents you with a row of N closed boxes, numbered from 1 to N in order, each containing a secret positive integer. A curtain opens to reveal a shiny, new tricycle — you recognize it as an expensive, top-of-the-line model.

The host then proceeds to explain the rules: you must select a contiguous sequence of the boxes (boxes a..b, for some 1 ≤ a ≤ b ≤ N). Your chosen boxes will then be opened, and if the sum of the numbers inside is no greater than the price of the tricycle, you win it!

You'd sure like to win that tricycle. Fortunately, not only are you aware that its price is exactly P, but you've paid off the host to let you in on the contents of the boxes! You know that each box i contains the number Bi.

How many different sequences of boxes can you choose such that you win the tricycle? Each sequence is defined by its starting and ending box indices (a and b).

Input
Input begins with an integer T, the number of times you appear on The Price is Correct. For each show, there is first a line containing the space-separated integers N and P. The next line contains N space-separated integers, B1 through BN in order.

Output
For the ith show, print a line containing "Case #i: " followed by the number of box sequences that will win you the tricycle.

Constraints
1 ≤ T ≤ 40 
1 ≤ N ≤ 100,000 
1 ≤ P ≤ 1,000,000,000 
1 ≤ Bi ≤ 1,000,000,000 
Explanation of Sample
In the first case no sequence adds up to more than 50, so all 10 sequences are winners. In the fourth case, you can select any single box, or the sequences (1, 2), (1, 3), and (2, 3), for 9 total winning sequences.

Example input · DownloadExample output · Download
5
4 50
10 10 10 10
4 50
51 51 51 51
3 1000000000
1000000000 1000000000 1000000000
6 6
1 2 3 4 5 6
10 77
12 3 52 25 9 83 45 21 33 3


ANS : 
Case #1: 10
Case #2: 0
Case #3: 3
Case #4: 9
Case #5: 18
 */
public class PriceIsCorrect {
	
	private static final String DIR_PATH = "D:/Downloads/";
	private static final String FILE_NAME = "the_price_is_correct.txt";
	
	public static void main(String[] args){
		try{
			Scanner objScanner = new Scanner(new File(DIR_PATH +FILE_NAME));
			PrintWriter pw = new PrintWriter(new File(DIR_PATH +FILE_NAME +"out.txt"));
			int numTestCases = Integer.parseInt(objScanner.nextLine());
			for(int testCase = 1; testCase <= numTestCases; testCase++){
				String[] arrTokens = objScanner.nextLine().split(" ");
				int numBoxes = Integer.parseInt(arrTokens[0]);
				int price = Integer.parseInt(arrTokens[1]);
				int[] arrBoxes = new int[numBoxes];
				arrTokens = objScanner.nextLine().split(" ");
				for(int box = 0; box < numBoxes; box++){
					arrBoxes[box] = Integer.parseInt(arrTokens[box]);
				}
				int count = 0;
				for(int startSeq = 0; startSeq < numBoxes; startSeq++){
					int seqTotal = 0;
					for(int seqLength = 0; seqLength < numBoxes && startSeq + seqLength < numBoxes; seqLength++){
						seqTotal += arrBoxes[startSeq + seqLength];
						if(seqTotal <= price){
							count++;
						}else{
							break;
						}
					}
				}
				String output = "Case #" +testCase+": " +count;
				pw.println(output);
				System.out.println(output +" ( out of " +numTestCases +" test cases )");
			}
			objScanner.close();
			pw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
