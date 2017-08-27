package org.leIngeneursInc.problems.others;

/**
 * Class to print a matrix sprially
 */
public class PrintMatrixSpirally {

    public static void main(String[] args) {
        int[][] mat = generateSquareMat(3);
        printMat(mat, 3);
        printSpirally(mat, 3);
    }

    public static void printSpirally(int[][] mat, int n) {
        for (int rowIdx = 0; rowIdx <= n/2; rowIdx++) {
            printOuterSquare(mat, rowIdx, n - 2 * rowIdx);
        }
        System.out.println("");
    }

    public static void printOuterSquare(int[][] mat, int rowIdx, int size) {
        // this is going to be interesting
        int r = rowIdx;
        int c = rowIdx;

        int maxIdx = rowIdx + size - 1;

        while (c < size - rowIdx) {
            System.out.print(mat[r][c++] +"\t");
        }

        c = maxIdx;
        r++;
        while(r <= maxIdx) {
            System.out.print(mat[r++][c] +"\t");
        }

        r = maxIdx;
        c--;
        while (c >= rowIdx) {
            System.out.print(mat[r][c--] +"\t");
        }

        c = rowIdx;
        r--;
        while(r > rowIdx) {
            System.out.print(mat[r--][c] +"\t");
        }
    }

    private static int[][] generateSquareMat(int n) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = i * n + j + 1;
            }
        }
        return mat;
    }

    private static void printMat(int[][] mat, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] +"\t");
            }
            System.out.println("");
        }
    }
}
