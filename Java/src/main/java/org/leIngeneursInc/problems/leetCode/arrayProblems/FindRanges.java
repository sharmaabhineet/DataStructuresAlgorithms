/**
 * 
 */
package org.leIngeneursInc.problems.leetCode.arrayProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Abhineet
 *
 */
public class FindRanges {

	public static List<String> summaryRanges(int[] nums) {
		if (nums.length <= 0) {
			return Collections.emptyList();
		} else {
			// do nothing here. go ahead.
		}

		List<String> retList = new ArrayList<String>();
		final String arrow = "->";
		StringBuffer range = new StringBuffer();
		range.append(nums[0]);
		range.append(arrow);
		for (int index = 1; index < nums.length; index++) {
			if (nums[index] - nums[index - 1] > 1) {
				range.append(nums[index - 1]);
				retList.add(range.toString());
				range = new StringBuffer();
				range.append(nums[index]);
				range.append(arrow);
			} else {
				// do nothing here. Carry on
			}
		}
		range.append(nums[nums.length - 1]);
		retList.add(range.toString());
		return retList;
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{0}; //, 1, 2, 4, 5, 7};
		System.out.println(summaryRanges(nums));
	}

}
