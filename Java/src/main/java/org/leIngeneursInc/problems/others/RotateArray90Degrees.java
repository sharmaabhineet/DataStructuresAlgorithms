package org.leIngeneursInc.problems.others;

/**
 * Created by blackShadow on 6/18/2017.
 */
public class RotateArray90Degrees {

    public static void main(String[] args) {
        print(arrOfsize(3));
        print(rotateByCopy(arrOfsize(3)));
    }

    public static int[][] rotateByCopy(int[][] arr) {
        int n = arr.length;
        int[][] newArr = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = n -1; c >= 0; c--) {
                newArr[c][r] = arr[r][c];
            }
        }
        return newArr;
    }

    public static void print(int[][] arr) {
        int n = arr.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(arr[r][c] +"\t");
            }
            System.out.println("");
        }
    }


    public static int[][] arrOfsize(int n) {
        int[][] arr = new int[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i-1][j-1] = i * j;
            }
        }
        return arr;
    }
}
