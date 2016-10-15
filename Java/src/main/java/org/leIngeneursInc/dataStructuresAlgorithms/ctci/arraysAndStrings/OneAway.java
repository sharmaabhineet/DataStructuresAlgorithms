/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.ctci.arraysAndStrings;

/**
 * Solves the one away problem of CTCI
 * @author Abhineet (sharma.abhineet31@gmail.com)
 */
public class OneAway {
	
	public static boolean oneAway(String str1, String str2){
		if(Math.abs(str1.length() - str2.length()) > 1){
			return false;
		}else{
			//do nothing here go ahead.
		}
		
		int len1 = str1.length();
		int len2 = str2.length();
		if(len1 == len2){
			boolean foundOneDiff = str1.charAt(0) != str2.charAt(0);
			for(int index = 1; index < len1; index++){
				if(str1.charAt(index) != str2.charAt(index)){
					if(foundOneDiff) {
						return false;
					}else{
						foundOneDiff = true;
					}
				}else{
					//do nothing here. we are good.
				}
			}
			return true;
		} else{
			String shortStr = str1;
			String longStr = str2;
			if(len1 > len2){
				shortStr = str2;
				longStr = str1;
				int temp = len1;
				len1 = len2;
				len2 = temp;
			}else{
				//do nothing here. already taken care of
			}
			boolean foundOneDiff = false;
			for(int index = 0, longIndex = 0; index < len1; index++, longIndex++){
				if(shortStr.charAt(index) != longStr.charAt(longIndex)){
					if(foundOneDiff){
						return false;
					}else{
						foundOneDiff = true;
						//move it one back, to keep it on the same character 
						index--;
					}
				}else{
					//do nothing here. continue.
				}
			}
			return true;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("pale v/s ple : " +oneAway("pale", "ple"));
		System.out.println("pales v/s pale : " +oneAway("pales", "pale"));
		System.out.println("pale v/s  bale : " +oneAway("pale", "bale"));
		System.out.println("pale v/s  bake : " +oneAway("pale", "bake"));
	}

}
