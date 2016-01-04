/**
 * 
 */
package org.leIngeneursInc.problems.ctci.stacksQueues;

import java.util.Comparator;
import java.util.Random;
import java.util.Stack;

/**
 * @author Abhineet ( sharma.abhineet31@gmail.com )
 *
 */
public class SortStackUsingAtMostOneStack {

	public static<T> Stack<T> sort(Stack<T> inputStack, Comparator<T> comp){
		Stack<T> sortedStack = new Stack<T>();
		while(!inputStack.isEmpty()){
			T val = inputStack.pop();
			while(!sortedStack.isEmpty()){
				if(comp.compare(val, sortedStack.peek()) >= 0){
					break;
				}else{
					inputStack.push(sortedStack.pop());
				}
			}
			sortedStack.push(val);
		}
		return sortedStack;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int NUM_ITER = 50;
		int MAX_SIZE = 100;
		int passCount = 0;
		int failCount = 0;
		Random random = new Random();
		for(int iter = 0; iter < NUM_ITER; iter++){
			int size = random.nextInt(MAX_SIZE);
			if(size == 0 ){
				size = random.nextInt(MAX_SIZE) + 1;
			}
			Stack<Integer> stackInt = new Stack<Integer>();
			Random random2 = new Random();
			for(int i = 0; i < size ; i++){
				stackInt.push(random2.nextInt(Integer.MAX_VALUE));
			}
			stackInt = sort(stackInt, new Comparator<Integer>() {

				@Override
				public int compare(Integer arg0, Integer arg1) {
					if(arg0 == arg1){
						return 0;
					} else if ( arg0 < arg1){
						return -1;
					} else{
						return 1;
					}
				}

			});
			if(stackInt.isEmpty()){
				System.out.println("TEST FAILED. Expected Size : " +size +"\t ACTUAL SIZE: " +stackInt.isEmpty());
			}
			int topVal = stackInt.pop();
			boolean flagFailed = false;
			while(!stackInt.isEmpty()){
				if(topVal < stackInt.peek()){
					System.out.println("TEST FAILED. Expected Value Lesser Than : " +topVal +" but Actually is : " +stackInt.peek());
					flagFailed = true;
					break;
				}else{
					stackInt.pop();
				}
			}
			if(!flagFailed){
				passCount++;
				System.out.println("Test Number : " +(iter + 1) +" --> PASSED");
			}else{
				failCount++;
				System.out.println("Test Number : " +(iter + 1) +" --> FAILED");
			}
		} 
		System.out.println("SUMMARY : " +passCount +" passed out of " +(passCount + failCount));
	}
}
