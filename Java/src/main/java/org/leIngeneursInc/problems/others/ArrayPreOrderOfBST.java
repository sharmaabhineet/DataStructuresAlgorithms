package org.leIngeneursInc.problems.others;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Prints 1 if a given array can be a Preorder traversal of a BST
 */
public class ArrayPreOrderOfBST {
   public static boolean isPreOrderOfBST(int[] arr) {
       Validate.isTrue(arr != null && arr.length > 0);

       Stack<Integer> stack = new Stack<>();
       int root = Integer.MIN_VALUE;

       for (int num : arr) {
           if (num < root) {
               return false;
           }

           while (!stack.isEmpty() && stack.peek() < num) {
               root = stack.pop();
           }

           stack.push(num);
       }
       return true;
   }
}
