/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.trees;

/**
 * Java bean serves as a node for Binary Tree Node 
 * @author Abhineet (sharma.abhineet31@gmail.com)
 */
public class BinaryTreeNode<T> {

	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private BinaryTreeNode<T> parent;
	private T val;
	
	
	/**
	 * Node creates an orphan node ( or a root ) with given value
	 * @param val the value of this node. Can not be null. Throws an IllegalArgumentException if this value is null.
	 */
	public BinaryTreeNode(T val){
		this(val, null, null, null);
	}
	
	/**
	 * Creates a node with given value with a specific parent
	 * @param val the value of this node. Can not be null. Throws an IllegalArgumentException if this value is null.
	 * @param parent the parent of  this node
	 */
	public BinaryTreeNode(T val, BinaryTreeNode<T> parent){
		this(val, parent, null, null);
	}
	
	/**
	 * Creates a node with given value and a parent. Also its left and right subtree can be specified
	 * @param val the value of this node. Can not be null. Throws an IllegalArgumentException if this value is null.
	 * @param parent
	 * @param left
	 * @param right
	 */
	public BinaryTreeNode(T val, BinaryTreeNode<T> parent, BinaryTreeNode<T> left, BinaryTreeNode<T> right){
		if(val == null){
			throw new IllegalArgumentException("Value of this node can not be null");
		}else{
			//do nothing here. go ahead.
		}
		this.val = val;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}

	/**
	 * @return the left subtree
	 */
	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	/**
	 * @param left the binary tree node for the left child
	 */
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	/**
	 * @return the right subtree
	 */
	public BinaryTreeNode<T> getRight() {
		return right;
	}

	/**
	 * @param right binary tree node for the right child
	 */
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	/**
	 * @return the parent of this node
	 */
	public BinaryTreeNode<T> getParent() {
		return parent;
	}

	/**
	 * @param parent the parent of this node
	 */
	public void setParent(BinaryTreeNode<T> parent) {
		this.parent = parent;
	}

	/**
	 * @return the value of this node
	 */
	public T getVal() {
		return val;
	}

	/**
	 * @param val the value of this node
	 */
	public void setVal(T val) {
		this.val = val;
	}
	
	@Override
	public String toString(){
		return  "Node Val : " +this.val +"\n\tisRoot ? " +(this.parent == null)
				+"\n\tisLeaf ? " +(this.left == null && this.right == null);
	}
}
