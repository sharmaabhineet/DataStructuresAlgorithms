/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.ctci.arraysAndStrings;

/**
 * My own implementation of StringBuilder. Implements some of the basic methods
 * The idea is to implement it using a dynamic array. If the character array
 * gets full, it doubles it size, giving it an amortized time of O(n) for
 * insertions. Similarly, it halves the size when array is reduced to quarter of
 * its size.
 * 
 * @author Abhineet ( sharma.abhineet31@gmail.com )
 */
public class StringBuilder {

	private char[] arrChars;
	private int insertAtIndex = 0;
	private static int DEFAULT_LENGTH = 10;

	/**
	 * Default Constructor
	 */
	public StringBuilder() {
		arrChars = new char[DEFAULT_LENGTH];
	}

	/**
	 * Initialize string builder with a given string
	 * 
	 * @param inputStr
	 *            the string with which the string builder has to be initialized
	 */
	public StringBuilder(String inputStr) {
		// Because, we are following the policy that the length of
		// array is doubled when its full.
		int inputStrLen = inputStr.length();
		arrChars = new char[(inputStrLen == 0 ? DEFAULT_LENGTH : inputStrLen * 2)];
		for (int index = 0; index < inputStr.length(); index++) {
			arrChars[insertAtIndex++] = inputStr.charAt(index);
		}
	}

	/**
	 * Append a character to the stringbuilder
	 * 
	 * @param ch
	 *            the character that needs to be appended.
	 */
	public void append(char ch) {
		if (insertAtIndex == arrChars.length) {
			increaseSize(arrChars.length);
		} else {
			// do nothing
		}

		arrChars[insertAtIndex++] = ch;
	}

	/**
	 * @return the length of the string that is held by this stringbuilder
	 * 
	 */
	public int length() {
		return insertAtIndex;
	}

	public void insertAt(int index, char ch) {
		if (insertAtIndex == arrChars.length) {
			increaseSize(arrChars.length);
		} else {
			// do nothing here.
		}

		// Shift the contents of the array
		for (int iterIndex = insertAtIndex; iterIndex > index ; iterIndex--) {
			arrChars[iterIndex] = arrChars[iterIndex - 1];
		}
		insertAtIndex++;
		arrChars[index] = ch;
	}

	public void insertAt(int index, String str) {
		int len = str.length();
		if (insertAtIndex + len >= arrChars.length) {
			increaseSize(insertAtIndex + len * 2);
		} else {
			// do nothing here. we are good.
		}

		// Shift the contents of the array
		for (int iterIndex = insertAtIndex - 1; iterIndex >= index; iterIndex--) {
			arrChars[iterIndex + len] = arrChars[iterIndex];
		}

		// Copy the string into the space made available
		for (int iterIndex = 0; iterIndex < len; iterIndex++) {
			arrChars[iterIndex + index] = str.charAt(iterIndex);
		}
		insertAtIndex += len;
	}

	/**
	 * Appends string to the StringBuilder
	 * 
	 * @param str
	 *            : The string that needs to be appended.
	 */
	public void append(String str) {
		if (str == null || str.isEmpty()) {
			return;
		} else {
			// do nothing here. go ahead.
		}
		int len = str.length();

		if (insertAtIndex + len >= arrChars.length) {
			increaseSize(len * 2 + insertAtIndex);
		} else {
			// do nothing.
		}

		for (int index = 0; index < len; index++) {
			arrChars[insertAtIndex++] = str.charAt(index);
		}
	}

	/**
	 * Delete character at a specified index. Throws
	 * ArrayIndexOutOfBoundException if index < 0 or is > length of the string
	 * 
	 * @param index
	 *            : at which the character has to be deleted
	 * @return the deleted character
	 */
	public char deleteCharAt(int index) {
		if (index < 0 || index >= insertAtIndex) {
			throw new ArrayIndexOutOfBoundsException("Invalid index for deletion");
		} else {
			// do nothign here. go ahead
		}
		char retCh = arrChars[index];
		insertAtIndex--;
		while (index < insertAtIndex) {
			arrChars[index] = arrChars[index + 1];
			index++;
		}

		if (insertAtIndex <= arrChars.length / 4) {
			reduceSize((arrChars.length - 1) / 2);
		} else {
			// do nothing here.
		}
		return retCh;
	}

	/**
	 * Returns substring starting from the given index until the end
	 * 
	 * @param index
	 *            : Starting index
	 * @return the substring
	 */
	public String subString(int index) {
		if (index < 0) {
			throw new ArrayIndexOutOfBoundsException("Invalid index for deletion");
		} else if (index >= insertAtIndex) {
			return "";
		} else {
			// do nothing
		}
		char[] arr = new char[insertAtIndex - index ];
		for (int iterIndex = 0; iterIndex < insertAtIndex - index; iterIndex++) {
			arr[iterIndex] = arrChars[index + iterIndex];
		}
		return new String(arr);
	}

	/**
	 * Returns the substring of given length starting from given index
	 * 
	 * @param index
	 *            starting index
	 * @param len
	 *            the length of the substring
	 * @return the substring
	 */
	public String subString(int index, int len) {
		if (index < 0 || index >= insertAtIndex) {
			throw new ArrayIndexOutOfBoundsException("Invalid index for deletion");
		} else if (index + len > insertAtIndex) {
			len = insertAtIndex;
		} else {
			// do nothing
		}

		char[] arr = new char[len];
		for (int iterIndex = 0; iterIndex < len; iterIndex++) {
			arr[iterIndex] = arrChars[index + iterIndex];
		}
		return new String(arr);
	}

	/**
	 * Delete a substring of given length starting from given index
	 * 
	 * @param index
	 *            starting index
	 * @param len
	 *            the length of the substring
	 * @return the substring deleted
	 */
	public String deleteSubStringFrom(int index, int len) {
		if (index < 0 || index >= insertAtIndex) {
			throw new ArrayIndexOutOfBoundsException("Invalid index for deletion");
		} else if (len == 0) {
			return "";
		} else if (index + len > insertAtIndex) {
			len = insertAtIndex;
		} else {
			// do nothing
		}

		String retString = subString(index, len);
		insertAtIndex -= len;
		while (index < insertAtIndex) {
			arrChars[index] = arrChars[index + len];
			index++;
		}

		if (insertAtIndex <= arrChars.length / 4) {
			reduceSize((arrChars.length - 1) / 2);
		} else {
			// do nothing here.
		}
		return retString;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return subString(0);
	}

	/**
	 * Increases the size of the array by given input parameter. If the input
	 * parameter is less than or equal to 0, then the size of array is increased
	 * by DEFAULT_LENGTH
	 * 
	 * @param size
	 *            the size by which array's size has to be increased.
	 */
	private void increaseSize(int size) {
		char[] oldCharArr = arrChars;
		arrChars = new char[arrChars.length + (size <= 0 ? DEFAULT_LENGTH : size)];
		for (int index = 0; index < insertAtIndex; index++) {
			arrChars[index] = oldCharArr[index];
		}
	}

	/**
	 * Decreases the size of the array by given size. If the size is <= 0, then
	 * it sets the array size to DEFAULT_LENGTH
	 * 
	 * @param size
	 *            the size by which the array's size has to be decreased
	 */
	private void reduceSize(int size) {
		char[] oldCharArr = arrChars;
		int newSize = arrChars.length - size;
		arrChars = new char[(newSize <= 0 ? DEFAULT_LENGTH : newSize)];
		for (int index = 0; index < insertAtIndex; index++) {
			arrChars[index] = oldCharArr[index];
		}
	}

}
