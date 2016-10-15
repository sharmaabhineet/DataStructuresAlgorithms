/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.ctci.arraysAndStrings;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;
import org.leIngeneursInc.dataStructuresAlgorithms.ctci.arraysAndStrings.StringBuilder;

/**
 * Test class for StringBuilder
 * @author Abhineet (sharma.abhineet31@gmail.com)
 */
public class StringBuilderTest {
	
	/**
	 * Helper method to generate random strings of given length
	 * @param len the length of the string
	 * @return the randomly generated string
	 */
	private String getRandomString(int len){
		Random rndm = new Random();
		
		char[] arr = new char[len];
		for(int index = 0; index < len; index++){
			arr[index] = (char) ('a' + rndm.nextInt(26));
		}
		return new String(arr);
	}
	
	@Test
	public void testDefaultConstructor(){
		StringBuilder strBuilder = new StringBuilder();
		assertNotNull(strBuilder);
		assertEquals(0, strBuilder.length());
	}
	
	@Test
	public void testStringConstructor(){
		String rndmStr = getRandomString(10);
		StringBuilder strBuilder = new StringBuilder(rndmStr);
		assertNotNull(strBuilder);
		assertEquals(rndmStr.length(), strBuilder.length());
		assertEquals(rndmStr, strBuilder.toString());
	}
	
	
	@Test
	public void testAppendChar(){
		/*
		 * Idea to insert random characters for a certain number of 
		 * iterations and keep on validating the characters added length 
		 * and finally check the entire string returned, for which 
		 * an array is used to store the values of the randomly generated 
		 * characters for comparison in the end.
		 */
		final int NUM_ITER = 100;
		StringBuilder strBuilder = new StringBuilder();
		Random rndm = new Random();
		char[] arr = new char[NUM_ITER];
		for(int iter = 0; iter < NUM_ITER; iter++){
			arr[iter] = (char)(rndm.nextInt(26) + 'a');
			strBuilder.append(arr[iter]);
			assertEquals(iter + 1, strBuilder.length());
		}
		assertEquals(new String(arr), strBuilder.toString());
	}
	
	@Test
	public void testAppendString(){
		/*
		 * Idea to insert random string for a certain number of 
		 * iterations and keep on validating the characters added length 
		 * and finally check the entire string returned, for which 
		 * an array is used to store the values of the randomly generated 
		 * characters for comparison in the end.
		 */
		final int NUM_ITER = 100;
		StringBuilder strBuilder = new StringBuilder();
		Random rndm = new Random();
		String appendedStr = "";
		for(int iter = 0; iter < NUM_ITER; iter++){
			String str = getRandomString(rndm.nextInt(15));
			strBuilder.append(str);
			appendedStr += str;
			assertEquals(appendedStr.length(), strBuilder.length());
			
		}
		assertEquals(appendedStr, strBuilder.toString());
	}
	
	@Test
	public void testDeleteCharAt(){
		final int NUM_ITER = 100;
		String rndmStr = getRandomString(NUM_ITER * 10);
		java.lang.StringBuilder actualStrBuilder = new java.lang.StringBuilder(rndmStr);
		StringBuilder strBuilder = new StringBuilder(rndmStr);
		Random rndm = new Random();
		for(int iter = 0; iter < NUM_ITER; iter++){
			int index = rndm.nextInt(strBuilder.length());
			char ch = strBuilder.deleteCharAt(index);
			assertEquals(actualStrBuilder.charAt(index), ch);
			actualStrBuilder.deleteCharAt(index);
		}
		assertEquals(actualStrBuilder.toString(), strBuilder.toString());
	}
	
	@Test
	public void testDeleteSubstring(){
		final int NUM_ITER = 100;
		String rndmStr = getRandomString(NUM_ITER * 10);
		java.lang.StringBuilder actualStrBuilder = new java.lang.StringBuilder(rndmStr);
		StringBuilder strBuilder = new StringBuilder(rndmStr);
		Random rndm = new Random();
		for(int iter = 0; iter < NUM_ITER; iter++){
			int index = rndm.nextInt(strBuilder.length());
			int len = rndm.nextInt(strBuilder.length() + 1 - index);
			len = (len == 0 ? 1 : len);
			String subStr = strBuilder.deleteSubStringFrom(index, len);
			assertEquals(actualStrBuilder.substring(index, index + len), subStr);
			int delIndex = index + len;
			if(delIndex > actualStrBuilder.length()){
				delIndex = actualStrBuilder.length();
			}
			actualStrBuilder.delete(index, index + len );
			// in case we run out of strings
			if(strBuilder.length() <= 0){
				rndmStr = getRandomString(NUM_ITER * 10);
				actualStrBuilder = new java.lang.StringBuilder(rndmStr);
				strBuilder = new StringBuilder(rndmStr);
			}else{
				//do nothing
			}
		}
		assertEquals(actualStrBuilder.toString(), strBuilder.toString());
	}
	
	
	@Test
	public void testInsertAt(){
		final int NUM_ITER = 100;
		java.lang.StringBuilder actualStrBuilder = new java.lang.StringBuilder();
		StringBuilder strBuilder = new StringBuilder();
		Random rndm = new Random();
		for(int iter = 0; iter < NUM_ITER; iter++){
			char rndmCh = (char)(rndm.nextInt(26) +'a');
			int len = strBuilder.length();
			int rndmIndex = rndm.nextInt(len == 0 ? 1 : len);
			actualStrBuilder.insert(rndmIndex, rndmCh);
			strBuilder.insertAt(rndmIndex, rndmCh);
			assertEquals(actualStrBuilder.toString(), strBuilder.toString());
		}
	}
	
	@Test
	public void testInsertAtString(){
		final int NUM_ITER = 100;
		java.lang.StringBuilder actualStrBuilder = new java.lang.StringBuilder();
		StringBuilder strBuilder = new StringBuilder();
		Random rndm = new Random();
		for(int iter = 0; iter < NUM_ITER; iter++){
			String rndmString = getRandomString(rndm.nextInt(15));
			int len = strBuilder.length();
			int rndmIndex = rndm.nextInt(len == 0 ? 1 : len);
			actualStrBuilder.insert(rndmIndex, rndmString);
			strBuilder.insertAt(rndmIndex, rndmString);
			assertEquals(actualStrBuilder.toString(), strBuilder.toString());
		}
	}
	
	@Test
	public void testLength(){
		final int NUM_ITER = 100;
		Random rndm = new Random();
		StringBuilder strBuilder = new StringBuilder();
		int length = 0;
		for(int iter = 0; iter < NUM_ITER; iter++){
			String rndmStr = getRandomString(rndm.nextInt(15));
			length += rndmStr.length();
			strBuilder.append(rndmStr);
			assertEquals(length, strBuilder.length());
		}
	}
	
	@Test
	public void testSubString(){
		final int NUM_ITER = 2;
		Random rndm = new Random();
		String rndmStr = getRandomString(rndm.nextInt(NUM_ITER * 10));
		StringBuilder strBuilder = new StringBuilder(rndmStr);
		for(int iter = 0; iter < NUM_ITER; iter++){
			int index = rndm.nextInt(strBuilder.length());
			assertEquals(rndmStr.substring(index), strBuilder.subString(index));
		}
	}
	
	@Test
	public void testSubStringStartEnd(){
		final int NUM_ITER = 2;
		Random rndm = new Random();
		String rndmStr = getRandomString(rndm.nextInt(NUM_ITER * 10) + 1);
		StringBuilder strBuilder = new StringBuilder(rndmStr);
		for(int iter = 0; iter < NUM_ITER; iter++){
			int index = rndm.nextInt(strBuilder.length());
			int len = rndm.nextInt(strBuilder.length() - index);
			assertEquals(rndmStr.substring(index, index + len), strBuilder.subString(index, len));
		}
	}
	
	

}
