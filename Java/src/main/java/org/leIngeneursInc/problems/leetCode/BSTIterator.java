package org.leIngeneursInc.problems.leetCode;

import java.util.Stack;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

public class BSTIterator {

	Stack<TreeNode> objStack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		while (root != null) {
			objStack.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !objStack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		if (objStack.isEmpty()) {
			throw new IllegalStateException("No more numbers");
		} else {
			// do nothign here.
		}

		TreeNode node = objStack.pop();
		TreeNode parent = objStack.isEmpty() ? null : objStack.peek();
		if (node.right != null) {
			//System.out.println("Pushing : " + node.val);
			objStack.push(node);
			objStack.push(node.right);
			//System.out.println("Pushing : " + node.right.val);
			TreeNode tempNode = node.right.left;
			while (tempNode != null) {
				objStack.push(tempNode);
				//System.out.println("Pushing : " + tempNode.val);
				tempNode = tempNode.left;
			}
		} else if (parent != null && parent.right == node) {
			TreeNode tempNode = null;
			do {
				tempNode = objStack.pop();
				parent = objStack.isEmpty() ? null : objStack.peek();
			} while (parent != null && parent.right == tempNode);
		} else {
			// do nothing
		}

		return node.val;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		
		{
			TreeNode tempNode = root.left;
			tempNode.left = new TreeNode(1);
			tempNode.right = new TreeNode(4);
			tempNode = tempNode.right;
			tempNode.left = new TreeNode(3);
		}
		
		{
			TreeNode tempNode = root.right;
			tempNode.left = new TreeNode(6);
			tempNode.right = new TreeNode(9);
		}
		
		
		BSTIterator iter = new BSTIterator(root);
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}