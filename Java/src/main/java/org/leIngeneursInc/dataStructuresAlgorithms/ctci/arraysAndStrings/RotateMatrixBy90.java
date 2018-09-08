package org.leIngeneursInc.dataStructuresAlgorithms.ctci.arraysAndStrings;

/**
 * Rotates all the object of a N x N matrix by 90 degrees. Strategy rotates the matrix in layers.
 * A layer comprises of all the elements at the boundary of the matrix. It approaches the
 * rotation from outermost layer to the innermost. It can be observed that any element at
 * index (i,j) after rotation by 90 degrees would be present at (j, N - 1 - i) following 0-index
 * convention. At any layer (0-indexed), pick the first element and move it to its new position determined
 * by the calculation mentioned before. Then pick that element which was replaced to its new index. Need to do this
 * 4 times because after that we return to the position that was already moved. Then move onto the next element in the
 * layer and repeat the steps.
 */
public class RotateMatrixBy90 {
    private RotateMatrixBy90() {}

    public static <T> T[][] rotate(T[][] arr) {
        int N = arr.length;
        int layers = N / 2 + (N % 2);
        for (int layerIdx = 0; layerIdx < layers; layerIdx++) {
            //rotate the layer ==> (i,j) ==> (j, N - 1 - i)
            for (int col = layerIdx; col < (N - layerIdx) / 2 + 1; col++) {
                int i = layerIdx;
                int j = col;
                // Temporary reference to swap current object with the one at new position
                T tmp = arr[i][j];
                for (int itr = 0; itr < 4; itr++) {
                    T newTmpVal = arr[j][N-1-i];
                    arr[j][N-1-i] = tmp;
                    tmp = newTmpVal;
                    //Reset new values of i,j to rotate the next number
                    int tmpIdx = j;
                    j = N - i -1;
                    i = tmpIdx;
                }
            }
        }
        return arr;
    }
}
