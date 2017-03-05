package org.leIngenursInc;

public class Main {

    private static void staircase(int n) {
        for(int rowIndex =0; rowIndex < n; rowIndex++){
            for(int colIndex =0; colIndex < n; colIndex++) {
                if(colIndex < n - rowIndex - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println("");
        }
    }

    private static int findIndex(int[] arr) {
        int sum = 0;
        for(int ele : arr) {
            sum += ele;
        }
        int leftSum = 0;
        for(int i = 1; i < arr.length; i++) {
            leftSum += arr[i-1];
            int rightSum = sum - arr[i] - leftSum;
            if(leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("INDEX: " +findIndex(new int[]{1,2,1}));
    }
}
