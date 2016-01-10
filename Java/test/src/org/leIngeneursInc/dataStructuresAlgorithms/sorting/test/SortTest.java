/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.sorting.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.leIngeneursInc.dataStructuresAlgorithms.sorting.Sort;

/**
 * Tests all the methords in the Sort class
 * @author Abhineet ( sharma.abhineet31@gmail.com)
 *
 */
public class SortTest {
	
	private static Comparator<Integer> getIntComparator() {
		return new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				if (arg0.intValue() == arg1.intValue()) {
					return 0;
				} else if (arg0.intValue() < arg1.intValue()) {
					return -1;
				} else {
					return 1;
				}
			}
		};
	}
	
	@Test
	public void testQuickSort(){
		int MAX_ITER = 100;
		int MAX_SIZE = 100;
		Random rndm = new Random();
		for(int iter = 0; iter < MAX_ITER; iter++){
			Integer[] arrInt = new Integer[MAX_SIZE];
			Integer[] expectedOutArr = new Integer[MAX_SIZE];
			for(int index = 0; index < MAX_SIZE; index++){
				arrInt[index] = expectedOutArr[index] = rndm.nextInt(Integer.MAX_VALUE);
			}
			Arrays.sort(expectedOutArr, getIntComparator());
			Sort.quickSort(arrInt, getIntComparator());
			for(int index = 0; index < MAX_SIZE; index++){
				assertEquals("Values must be equal", expectedOutArr[index].intValue(), arrInt[index].intValue());
			}
		}
	}
	
	@Test
	public void testMergeSort(){
		int MAX_ITER = 100;
		int MAX_SIZE = 100;
		Random rndm = new Random();
		for(int iter = 0; iter < MAX_ITER; iter++){
			Integer[] arrInt = new Integer[MAX_SIZE];
			Integer[] expectedOutArr = new Integer[MAX_SIZE];
			for(int index = 0; index < MAX_SIZE; index++){
				arrInt[index] = expectedOutArr[index] = rndm.nextInt(Integer.MAX_VALUE);
			}
			Arrays.sort(expectedOutArr, getIntComparator());
			Sort.mergeSort(arrInt, getIntComparator());
			for(int index = 0; index < MAX_SIZE; index++){
				assertEquals("Values must be equal", expectedOutArr[index].intValue(), arrInt[index].intValue());
			}
		}
	}
	
}
