package org.leIngeneursInc.dataStructuresAlgorithms.hashTables.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.leIngeneursInc.dataStructuresAlgorithms.hashTables.HashTable;

public class HashTablesTest {
	
	private static final int DEFAULT_STR_LEN = 15;
	private static final int DEFAULT_SIZE = 100;
	
	private static String getRandomString(){
		Random rndm = new Random();
		char[] arr = new char[DEFAULT_STR_LEN];
		for(int index =0 ; index < DEFAULT_STR_LEN; index++){
			arr[index] = (char)('a' + rndm.nextInt(26));
		}
		return new String(arr);
	}
	
	private static List<String> getRandomlyGeneratedHashTableStringVals(){
		return getRandomlyGeneratedHashTableStringVals( DEFAULT_SIZE);
	}
	
	private static List<String> getRandomlyGeneratedHashTableStringVals(int size){
		List<String> retList = new ArrayList<String>();
		for(int index = 0; index < size; index++){
			retList.add(getRandomString());
		}
		return retList;
	}
	
	@Test
	public void testFactory(){
		//Since, I have a single implementation class for each and every type. will check class as well
		
		HashTable<String> ht = HashTable.createHashTable(HashTable.CollisionStrategy.CHAINING);
		assertNotNull(ht);
		assertEquals("org.leIngeneursInc.dataStructuresAlgorithms.hashTables.ChainingHashTable", ht.getClass().getName());
		
		 ht = HashTable.createHashTable(HashTable.CollisionStrategy.OPEN_ADDRESSING_DOUBLE_HASHING);
		assertNotNull(ht);
		assertEquals("org.leIngeneursInc.dataStructuresAlgorithms.hashTables.OpenAddressingDoubleHashingHashTable", ht.getClass().getName());
		
		ht = HashTable.createHashTable(HashTable.CollisionStrategy.OPEN_ADDRESSING_LINEAR_PROBING);
		assertNotNull(ht);
		assertEquals("org.leIngeneursInc.dataStructuresAlgorithms.hashTables.OpenAddressingLinearProbingHashTable", ht.getClass().getName());
		
		ht = HashTable.createHashTable(HashTable.CollisionStrategy.SURPRISE_ME);
		assertNotNull(ht);
	}
	
	@Test
	public void testAdd_SMALL_Chaining(){
		List<String> lstStr = getRandomlyGeneratedHashTableStringVals(10);
		HashTable<String> ht = HashTable.createHashTable(HashTable.CollisionStrategy.CHAINING);
		for(String str : lstStr){
			ht.add(str);
		}
		
		for(String str : lstStr){
			assertTrue("Value not found. Expected value to exist in table : " +str, ht.lookup(str));
		}
	}
	
	@Test
	public void testAdd_SMALL_OpenAddressingLinearProbing(){
		List<String> lstStr = getRandomlyGeneratedHashTableStringVals(10);
		HashTable<String> ht = HashTable.createHashTable(HashTable.CollisionStrategy.OPEN_ADDRESSING_LINEAR_PROBING);
		for(String str : lstStr){
			ht.add(str);
		}
		
		for(String str : lstStr){
			assertTrue("Value not found. Expected value to exist in table : " +str, ht.lookup(str));
		}
	}
	
	@Test
	public void testAdd_SMALL_OpenAddressingDoubleHashing(){
		List<String> lstStr = getRandomlyGeneratedHashTableStringVals(10);
		HashTable<String> ht = HashTable.createHashTable(HashTable.CollisionStrategy.OPEN_ADDRESSING_DOUBLE_HASHING);
		for(String str : lstStr){
			ht.add(str);
		}
		
		for(String str : lstStr){
			assertTrue("Value not found. Expected value to exist in table : " +str, ht.lookup(str));
		}
	}
	
	@Test
	public void testAdd_LARGE_FORALL(){
		List<String> lstStr = getRandomlyGeneratedHashTableStringVals(1800);
		HashTable<String> htc = HashTable.createHashTable(HashTable.CollisionStrategy.CHAINING);
		HashTable<String> htOaLP = HashTable.createHashTable(HashTable.CollisionStrategy.OPEN_ADDRESSING_LINEAR_PROBING);
		HashTable<String> htOaDH = HashTable.createHashTable(HashTable.CollisionStrategy.OPEN_ADDRESSING_DOUBLE_HASHING);
		
		System.out.println("Adding Strings");
		for(String str : lstStr){
			htc.add(str);
			htOaLP.add(str);
			htOaDH.add(str);
		}
		System.out.println("Completed Adding All");
		
		for(String str : lstStr){
			assertTrue("Value not found in chaining. Expected value to exist in table : " +str, htc.lookup(str));
			//assertTrue("Value not found in linear probing. Expected value to exist in table : " +str, htOaLP.lookup(str));
			//assertTrue("Value not found in double hashing. Expected value to exist in table : " +str, htOaDH.lookup(str));
		}
		System.out.println("Completed all");
	}
	
	
}
