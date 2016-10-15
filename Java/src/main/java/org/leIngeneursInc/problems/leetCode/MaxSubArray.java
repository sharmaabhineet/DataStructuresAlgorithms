/**
 * 
 */
package org.leIngeneursInc.problems.leetCode;

/**
 * 
 * Solves the Max SubArray problem hosted on leet code : https://leetcode.com/problems/maximum-subarray/
 * This is an implementation of Kadane's algorithm. 
 * Here's a good source to read about it : https://en.wikipedia.org/wiki/Maximum_subarray_problem
 * Time Compexity : O(n)
 * Space Complexity : O(1)
 * Description :
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 *	For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 *	the contiguous subarray [4,−1,2,1] has the largest sum = 6.
	 *
 * click to show more practice.
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 
 * @author Abhineet ( sharma.abhineet31@gmail.com )
 */
public class MaxSubArray {

	
	public static void main(String[] args) {
		int[] inputArr = new int[] {-2, 1, -3, 4 , -1 , 2, 1, -5, 4};
		System.out.println("Sum : " +new MaxSubArray().maxSubArray(inputArr));
	}
    
    /**
     * Solves the Max subarray problem using Kadane's Algorithm
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
    	if(nums == null || nums.length <= 0){
    		return 0;
    	}else{
    		//do nothing here. go ahead.
    	}
        int maxSum = nums[0];
        int maxSumTillHere = nums[0];
        for(int i : nums){
        	maxSumTillHere = Math.max(i, maxSumTillHere + i);
        	maxSum = Math.max(maxSumTillHere, maxSum);
        }
        return maxSum;
    }
}
