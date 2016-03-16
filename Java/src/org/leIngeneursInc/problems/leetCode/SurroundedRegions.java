package org.leIngeneursInc.problems.leetCode;

import java.util.Random;

public class SurroundedRegions {

	private static final char Z = 'Z'; // Can be captured
	private static final char Y = 'y'; // under processing

	/*
	 * Idea is : Find a circle and keep on checking out the neighbors Until
	 * either of the two conditions : COND I : u hit a dead end and are
	 * surrounded by x COND II : U hit arrays boundary. Update everthing
	 * accordingly on the way back
	 */

	public static void solve(char[][] board) {
		for (int j = 0; j < board[0].length; j++) {
			if (board[0][j] == 'O') {
				updateNeighbors(0, j, 'Z', 'O', board);
			}
			if (board[board.length - 1][j] == 'O') {
				updateNeighbors(board.length - 1, j, 'Z', 'O', board);
			}
		}
		

		for (int j = 1; j < board.length; j++) {
			if (board[j][0] == 'O') {
				updateNeighbors(j, 0, 'Z', 'O', board);
			}
			if (board[j][board[j].length - 1] == 'O') {
				updateNeighbors(j, board[j].length - 1, 'Z', 'O' , board);
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'O') {
					updateNeighbors(i, j, 'X', 'O', board);
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'Z') {
					updateNeighbors(i, j, 'O', 'Z',  board);
				}
			}
		}
	}

	private static void updateNeighbors(int row, int col, char val, char checkVal, char[][] board) {
		board[row][col] = val;

		// Update neighbor above
		if (row - 1 >= 0 && board[row - 1][col] == checkVal) {
			updateNeighbors(row - 1, col, val, checkVal , board);
		}

		// Update neighbor to the right
		if (col + 1 < board[row].length && board[row][col + 1] == checkVal) {
			updateNeighbors(row, col + 1, val, checkVal, board);
		}

		// Update neighbor down
		if (row + 1 < board.length && board[row + 1][col] == checkVal) {
			updateNeighbors(row + 1, col, val, checkVal, board);
		}

		// Update neighbor to the left
		if (col - 1 >= 0 && board[row][col - 1] == checkVal) {
			updateNeighbors(row, col - 1, val, checkVal,  board);
		}
	}
	
	public static void main(String[] args){
		int rows = 10;
		int cols = 10;
		Random rndm = new Random();
		char[][] board = new char[rows][cols];
		for(int i =0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(rndm.nextInt(10) < 4){
					board[i][j] = 'O';
				}else{
					board[i][j] = 'X';
				}
			}
		}
		board = new char[3][3];
		board[0][0] = board[0][1] = board[0][2] = board[1][0] = board[1][2] = board[2][0] = board[2][1] = board[2][2] = 'X';
		board[1][1] = 'O';
		printArr(board);
		System.out.println("OUTPUT : " );
		solve(board);
		printArr(board);
	}
	
	private static void printArr(char[][] map){
		for(int rowIndex = 0; rowIndex < map.length; rowIndex++){
			for(int colIndex = 0; colIndex < map[rowIndex].length; colIndex++){
				System.out.print(map[rowIndex][colIndex] +"\t");
			}
			System.out.println("");
		}
	}
}
