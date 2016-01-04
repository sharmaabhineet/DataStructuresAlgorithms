/**
 * 
 */
package org.leIngeneursInc.problems.ctci.stacksQueues;

import java.util.Stack;

/**
 * Implements all queue operations using Stacks
 * @author Abhineet ( sharma.abhineet31@gmail.com )
 *
 */
public class QueueUsingStacks {
	
	/**
	 * A static class. Creating a queue for integers for now
	 * @author Abhineet ( sharma.abhineet31@gmail.com )
	 *
	 */
	public static class Queue<T>{
		//Using two stacks 
		// Main stack contains all the items
		private Stack<T> mainStack = null;
		
		// buffer stack would be used to copy all the other 
		// items for dequeue operation
		private Stack<T> bufferStack = null;
		
		public Queue(){
			mainStack = new Stack<T>();
			bufferStack = new Stack<T>();
		}
		
		public void enqueue(T val){
			mainStack.push(val);
		}
		
		public T dequeue(){
			if(mainStack.isEmpty()){
				return null;
			}else{
				//do nothing here. go ahead.
			}
			while(!mainStack.isEmpty()){
				bufferStack.push(mainStack.pop());
			}
			T retVal = bufferStack.pop();
			while(!bufferStack.isEmpty()){
				mainStack.push(bufferStack.pop());
			}
			return retVal;
		}
		
		public boolean isEmpty(){
			return mainStack.isEmpty();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int passCount = 0;
		int failCount = 0;
		System.out.println("Testing Queue ( FIFO ) using Stacks...");
		Queue<Integer> queue = new Queue<>();
		
		System.out.println("Test 1 : isEmpty() ? Expected : True\t Actual : " +queue.isEmpty());
		if(queue.isEmpty()){
			passCount++;
			System.out.println("\tRESULT : PASSED");
		}else{
			failCount++;
			System.out.println("\tRESULT : FAILED");
		}
		
		queue.enqueue(1);
		System.out.println("Test 2 : isEmpty() ? Expected : False\t Actual : " +queue.isEmpty());
		if(!queue.isEmpty()){
			passCount++;
			System.out.println("\tRESULT : PASSED");
		}else{
			failCount++;
			System.out.println("\tRESULT : FAILED");
		}
		
		int val = queue.dequeue();
		System.out.println("Test 3 : Enqueue - Dequeue. Expected Value : 1\t Actual : " +val);
		if(val == 1){
			passCount++;
			System.out.println("\tRESULT : PASSED");
		}else{
			failCount++;
			System.out.println("\tRESULT : FAILED");
		}
		
		System.out.println("Adding 1-5 to the queue");
		for(int i = 1 ; i <= 5; i++){
			queue.enqueue(i);
		}
		
		System.out.println("Removing first three...");
		for(int i = 1; i <= 3; i++){
			val = queue.dequeue();
			System.out.println("Expected : " +i +"\tActual : " + val);
			if( val == i){
				passCount++;
				System.out.println("\tRESULT : PASSED");
			}else{
				failCount++;
				System.out.println("\tRESULT : FAILED");
			}
		}
		
		System.out.println("Adding 6-10 to the queue");
		for(int i = 6; i <= 10; i++){
			queue.enqueue(i);
		}
		
		System.out.println("Removing all...");
		for(int i = 4; i <= 10; i++){
			val = queue.dequeue();
			System.out.println("Expected : " +i +"\tActual : " + val);
			if( val == i){
				passCount++;
				System.out.println("\tRESULT : PASSED");
			}else{
				failCount++;
				System.out.println("\tRESULT : FAILED");
			}
		}
		System.out.println("SUMMARY : " +passCount +" passed out of " +(passCount + failCount));
	}

}
