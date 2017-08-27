package org.leIngeneursInc.problems.others;

import java.util.Scanner;

/**
 * Problem description: [http://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams/0]
 * Given a word and a text, return the count of the occurences of anagrams of the word in the text(For eg: anagrams of word for are for, ofr, rof etc.))

 Input:
 The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
 The first line of each test case contains a text  consisting of only lowercase Latin Letters.
 The second line contains a word consisting of only lowercase Latin Letters.

 Output:
 Print the count of the occurences of anagrams of the word in the text.

 Constraints:
 1 <= T <= 50
 1 <= |word|<= |text| <= 50
 here |word| denotes the size of word and |text| denotes the size of text

 Example:
 Input:
 2
 forxxorfxdofr
 for
 aabaabaa
 aaba

 Output:
 3
 4

 Explaination:
 for, orf and ofr appears in the first test case and hence answer is 3.
 */
public class FindAnagramOccurences {
    public static void main(String[] args) {
        //code
        try (Scanner scn = new Scanner(System.in)) {
            int numTestCases = scn.nextInt();
            for (int idx = 0; idx < numTestCases; idx++) {
                String inputStr = scn.next();
                String anaStr = scn.next();
                System.out.println(findAnaOccurences(inputStr, anaStr));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    /**
     * Use a window scanning of input string to count the number of characters in the current window. This window size is
     * same as the size of string we are matching for anagrams. Whenever the count of characters is same, we have found an
     * anagram. Return the total count upon scanning entire string. Time Conmplexity : O(n) Space Complexity : O(1)
     * @param inputStr
     * @param anaStr
     * @return
     */
    private static int findAnaOccurences(String inputStr, String anaStr) {
        if (inputStr == null || inputStr.length() <= 0
                || anaStr == null || anaStr.length() <= 0) {
            return 0;
        }

        inputStr = inputStr.toLowerCase();
        anaStr = anaStr.toLowerCase();
        int[] anaCtr = new int[26];
        for (char ch : anaStr.toCharArray()) {
            anaCtr[ch - 'a'] += 1;
        }

        int windowLen = anaStr.length();
        if (inputStr.length() < windowLen) {
            return 0;
        }

        int[] winCtr = new int[26];
        for (int idx = 0; idx < windowLen; idx++) {
            winCtr[inputStr.charAt(idx) - 'a'] += 1;
        }

        int count = areEqual(anaCtr, winCtr) ? 1 : 0;
        for (int idx = windowLen; idx < inputStr.length(); idx++) {
            // we know idx is > 0 here
            winCtr[inputStr.charAt(idx - 1) - 'a'] -= 1;
            winCtr[inputStr.charAt(idx) - 'a'] += 1;
            if (areEqual(anaCtr, winCtr)) {
                count++;
            }
        }
        return count;
    }

    private static boolean areEqual(int[] arr1, int[] arr2) {
        if (arr1 == arr2) {
            return true;
        }

        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            return false;
        }

        for (int idx = 0; idx < arr1.length; idx++) {
            if (arr1[idx] != arr2[idx]) {
                return false;
            }
        }

        return true;
    }
}
