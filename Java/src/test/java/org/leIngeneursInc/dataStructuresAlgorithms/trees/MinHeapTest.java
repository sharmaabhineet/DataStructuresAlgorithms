/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.trees;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;
import org.leIngeneursInc.dataStructuresAlgorithms.trees.MinHeap;

/**
 * 
 * @author Abhineet(sharma.abhineet31@gmail.com)
 */
public class MinHeapTest {
	
	@Test
	@Ignore //FIXME Fix this test
	public void testAdditionDeletion(){
		Random rndm = new Random();
		for(int iter = 0; iter < 100; iter++){
			MinHeap<Integer> minHeap = new MinHeap<Integer>();
			for(int i = 0; i < 10; i++){
				int val = rndm.nextInt(100);
				System.out.print(val +"    ");
				minHeap.insert(val);
			}
			System.out.println("");
			testHeapPropertyDestructive(minHeap);
		}
	}

	/*
	 * Helper method and not a test method. Need not annotate @Test
	 */
	private void testHeapPropertyDestructive(MinHeap<Integer> minHeap){
		Integer oldEle = minHeap.extractMin();
		
		while(oldEle != null){
			Integer newEle = minHeap.extractMin();
			System.out.println(oldEle +" v/s " +newEle);
			if(newEle != null){
				assertTrue(newEle.intValue() >= oldEle.intValue());
			}
			oldEle = newEle;
		}
	}
}
