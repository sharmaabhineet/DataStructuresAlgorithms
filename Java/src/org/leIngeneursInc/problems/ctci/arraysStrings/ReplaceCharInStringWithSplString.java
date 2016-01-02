/**
 * 
 */
package org.leIngeneursInc.problems.ctci.arraysStrings;

/**
 * Replaces spaces in a string with a special string : "%20"
 * @author Abhineet(sharma.abhineet31@gmail.com)
 *
 */
public class ReplaceCharInStringWithSplString {

	/**
	 * Replaces all the occurences of a given character in the input string with the given special string
	 * Time Complexity : O(n)
	 * Space Complexity : O(n)
	 * @param input the input string
	 * @param ch the characeter whose occurences have to be replaced
	 * @param splStr the special string that needs to be inserted
	 * @return the formatted string
	 */
	public static String replaceCharWithSpecialString(String input, char ch, String splStr){
		if(input == null || input.length() <= 0 || splStr == null){
			return input;
		}else{
			//do nothing
		}
		
		//count occurences first O(n) time
		int occ = 0;
		char[] arrChar = input.toCharArray();
		for(int index = 0; index < arrChar.length ; index++){
			if(arrChar[index] == ch){
				occ++;
			}else{
				//do nothing
			}
		}
		char[] retArr = null;
		boolean splCase = (splStr.length() == 0 ); 
		//Special case
		if(splCase){
			retArr = new char[input.length() - occ];
		}else{
			retArr = new char[input.length()  + (splStr.length() - 1) * occ];
		}
		char[] splArrChar = splStr.toCharArray();
		int retIndex = 0;
		for(int index= 0; index < arrChar.length; index++){
			if(arrChar[index] == ch){
				if(splCase){
					//continueW
				}else{
					for(char splCh : splArrChar){
						retArr[retIndex++] = splCh;
					}
				}
				
			} else{
				retArr[retIndex++] = arrChar[index]; 
			}
		}
		return new String(retArr);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char ch = ' ';
		String splStr = "%20";
		runTestCase(1, null, ch, splStr, null);
		runTestCase(2, "", ch, splStr, "");
		runTestCase(3, "abc", ch, null, "abc");
		runTestCase(4, "My Name is blackShadow ", ch, splStr, "My%20Name%20is%20blackShadow%20");
		runTestCase(5, " ", ch, splStr, "%20");
		runTestCase(6, " ", ch, "", "");
		runTestCase(7, "My Name is black Shadow", ch, splStr, "My%20Name%20is%20black%20Shadow");
		runTestCase(8, "My Name is black Shadow", ch, "", "MyNameisblackShadow");
		System.out.println("SUMMARY : " +passCount +" passed out of " +(passCount + failCount));
	}
	
	
	private static int passCount = 0;
	private static int failCount = 0;
	
	private static void runTestCase(int testCaseNum, String inputStr , char ch, String splStr,  String expectedVal){
		System.out.println("===================================");
		System.out.println("Running Test Case # " +testCaseNum +" : ");
		System.out.println("\t Input String : " +inputStr);
		System.out.println("\t Special String : " +splStr);
		System.out.println("\tChar : >" +ch +"<");
		String output = replaceCharWithSpecialString(inputStr, ch, splStr); 
		if( areStringsSame(output, expectedVal)){
			System.out.println("\t\t==> RESULT : PASSED");
			passCount++;
		} else{
			System.out.println("\t\t==> RESULT : FAILED\n\t\tExpected : " +expectedVal +"\tActual : " +output);
			failCount++;
		}
		System.out.println("===================================");
	}
	
	private static boolean areStringsSame(String str1 , String str2){
		if(str1 == null && str2 == null){
			return true;
		} else if (str1.length() <=0 && str2.length() <= 0){
			return true;
		} else if (str1.length() != str2.length()){
			return false;
		} else {
			//do nothing here. go ahead.
		}
		
		for(int index = 0; index < str1.length(); index++){
			if(str1.charAt(index) != str2.charAt(index)){
				return false;
			}else{
				//do nothing here. 
			}
		}
		return true;
	}

}

