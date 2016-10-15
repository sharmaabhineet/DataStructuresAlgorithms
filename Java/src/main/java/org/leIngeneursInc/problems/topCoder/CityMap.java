/**
 * 
 */
package org.leIngeneursInc.problems.topCoder;

/**
 * Solves CityMap Problem hosted on topcoder: https://arena.topcoder.com/#/u/practiceCode/15599/31257/12479/2/316806
 * 
 * Time Complexity : O(mn) where, m is the number of strings and n is the length of each string. 
 * 			(It is given that they are all of same length)
 * 
 * Space Complexity : O(n) , n is the length of string. Precisely it is O(p) where p is the number of POIs
 * 			( allocates space for the string to be returned) 
 * 
 * @author Abhineet(sharma.abhineet31@gmail.com)
 */

public class CityMap {

	public static void main(String[] args) {
		String[] cityMap = new String[] { "M....M", "...R.M", "R..R.R" };
		int[] POIs = new int[] { 3, 4 };
		System.out.println(new CityMap().getLegend(cityMap, POIs));
	}

	public String getLegend(String[] cityMap, int[] POIs) {
		char[] arr = new char[POIs.length];

		// To store the POI count. Each is initialized to 0
		// Each element in the array stores count of the alphabet A-Z corresponding to its index
		// Since '.' and A-Z are the only elements
		// Again a constant space memory
		int[] poiCount = new int[26];
		
		//Read thru entire input to calculate count
		for (String str : cityMap) {
			for (int index = 0; index < str.length(); index++) {
				char ch = str.charAt(index);
				if (ch == '.') {
					continue;
				} else {
					poiCount[ch - 'A'] += 1;
				}
			}
		}
		
		// Scan through all the entries in the count array
		for (int index = 0; index < 26; index++) {
			if (poiCount[index] == 0) {
				continue;
			} else {
				// For all the entries with non-zero count, 
				// We know the character it corresponds to accoring to index
				// find the poiIndex that count corresponds to 
				// and set the character to its poiIndex in the character array to be returned
				for (int poiIndex = 0; poiIndex < POIs.length; poiIndex++) {
					if (POIs[poiIndex] == poiCount[index]) {
						arr[poiIndex] = (char) (index + 'A');
						break;
					} else {
						// do nothing here. keep looking
					}
				}
			}
		}

		return new String(arr);
	}

}
