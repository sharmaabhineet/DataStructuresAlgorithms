package org.leIngeneursInc.dataStructuresAlgorithms.ctci.arraysAndStrings;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class RotateMatrixBy90Test {

    private static Integer[][] arrayOfDim(int N) {
        Integer[][] arr = new Integer[N][N];
        int ctr = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = ctr++;
            }
        }
        return arr;
    }

    @Test
    public void rotateBy90_arrayOf3() {
        Integer[][] arr = RotateMatrixBy90.rotate(arrayOfDim(3));
        assertTrue(Arrays.equals(arr[0], new Integer[] {7,4,1}));
        assertTrue(Arrays.equals(arr[1], new Integer[] {8,5,2}));
        assertTrue(Arrays.equals(arr[2], new Integer[] {9,6,3}));
    }

    @Test
    public void rotateBy90_arrayOf4() {
        Integer[][] arr = RotateMatrixBy90.rotate(arrayOfDim(4));
        assertTrue(Arrays.equals(arr[0], new Integer[] {13,9,5,1}));
        assertTrue(Arrays.equals(arr[1], new Integer[] {14,10,6,2}));
        assertTrue(Arrays.equals(arr[2], new Integer[] {15,11,7,3}));
        assertTrue(Arrays.equals(arr[3], new Integer[] {16,12,8,4}));
    }

}
