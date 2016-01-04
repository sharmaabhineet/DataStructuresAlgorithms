/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.trees;

import java.util.Comparator;

/**
 * Class Represents a binary search tree and provides all the required operations. The convention followed here is 
 * all the elements less than x.key go to the left subtree and all the elements greater than or EQUAL TO x.key go 
 * to the right subtree.
 * @author Abhineet ( sharma.abhineet31@gmail.com )
 *
 */
/**
 * @author blackshadow
 *
 * @param <T>
 */
public class BinarySearchTree<T> {

	private BinaryTreeNode<T> root;
	private Comparator<T> comp;
	
	/**
	 * @return the root
	 */
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	/**
	 * @return the comp
	 */
	public Comparator<T> getComp() {
		return comp;
	}

	/**
	 * @param comp the comp to set
	 */
	public void setComp(Comparator<T> comp) {
		this.comp = comp;
	}

	/**
	 * Default constructor
	 */
	public BinarySearchTree(){
		this.root = null;
	}
	
	/**
	 * Initializes tree with the given root node
	 * @param root the root node of the tree
	 */
	public BinarySearchTree(BinaryTreeNode<T> root){
		this.root = root;
	}
	
	/**
	 * Initializes tree with the given root node and an implicit comparator object
	 * @param root the root of the tree
	 * @param comp the comparator used to make all the comparisons 
	 */
	public BinarySearchTree(BinaryTreeNode<T> root, Comparator<T> comp){
		this.root = root;
		this.comp = comp;
	}
	
	/**
	 * @return a boolean value indicating whether or not the tree is empty.
	 */
	public boolean isEmpty(){
		return this.root == null;
	}
	
	/**
	 * Returns the node containing the given value. Expects comparator object to be set already. If not 
	 * throws an IllegalStateException
	 * @param val the value that needs to be searched 
	 * @return the first node encountered containing that value
	 */
	public BinaryTreeNode<T> find(T val){
		if(root == null || val == null){
			return null;
		}else if (this.comp == null){
			throw new IllegalStateException("Need to set comparator object before calling this method");
		}else{
			//do nothing here. go ahead
		}
		return find(val, this.comp);
	}
	
	/**
	 * Returns the node containing the given value.
	 * @param val the value that needs to be searched
	 * @param comp a comparator object to compare the values. Can not be null. Throws IllegalArgumentException if comp is null.
	 * @return the first node encountered containing that value
	 */
	public BinaryTreeNode<T> find(T val, Comparator<T> comp){
		if(root == null || val == null){
			return null;
		}else if (comp == null){
			throw new IllegalArgumentException("Compartor object can not be null");
		}else{
			//do nothing here. go ahead
		}
		BinaryTreeNode<T> searchNode = root;
		while(searchNode != null){
			if(searchNode.getVal().equals(val)){
				return searchNode;
			}else{
				int comparisonVal =comp.compare(val, root.getVal()); 
				if( comparisonVal < 0 ){
					searchNode = searchNode.getLeft();
				}else{
					searchNode = searchNode.getRight();
				}
			}
		}
		return null;
	}
	
	/**
	 * Returns the node containing the given value.
	 * @param val the value that needs to be searched.
	 * @return the first node encountered containing that value
	 */
	public BinaryTreeNode<T> find(Comparable<T> val){
		if(root == null || val == null){
			return null;
		}else{
			//do nothing here. go ahead
		}
		BinaryTreeNode<T> searchNode = root;
		while(searchNode != null){
			if(searchNode.getVal().equals(val)){
				return searchNode;
			}else{
				int comparisonVal = val.compareTo(root.getVal()); 
				if( comparisonVal < 0 ){
					searchNode = searchNode.getLeft();
				}else{
					searchNode = searchNode.getRight();
				}
			}
		}
		return null;
	}
	
	/**
	 * Find the node containing the minimum value in the binary search tree
	 * @return the node containing the minimum value in the binary search tree
	 */
	public BinaryTreeNode<T> findMin(){
		if(root == null){
			return null;
		}else{
			//do nothing here. go ahead
		}
		if(root.getLeft() == null){
			return root;
		}else{
			BinaryTreeNode<T> searchNode = root.getLeft();
			while(searchNode.getLeft() != null){
				searchNode = searchNode.getLeft();
			}
			return searchNode;
		}
	}
	
	/**
	 * Find the node containing the maximum value in the binary search tree
	 * @return the node containing the maximum value in the binary search tree
	 */
	public BinaryTreeNode<T> findMax(){
		if(root == null){
			return null;
		}else{
			//do nothing here. go ahead
		}
		if(root.getRight() == null){
			return root;
		}else{
			BinaryTreeNode<T> searchNode = root.getRight();
			while(searchNode.getRight() != null){
				searchNode = searchNode.getRight();
			}
			return searchNode;
		}
	}
	
	/**
	 * Inserts a value in the tree and returns the reference to the node. Throws an IllegalStateException if the 
	 * implicit comparator object is not set
	 * @param val the value to be inserted. Cannot be null. Throws IllegalArgumentException if value is null.
	 * @return the reference to the node that was added in the tree
	 */
	public BinaryTreeNode<T> insert(T val){
		if(val == null){
			throw new IllegalArgumentException("Value can not be null");
		}else if (comp == null){
			throw new IllegalStateException("Must set the comparator object before calling this method");
		}else{
			//do nothing here. go ahead
		}
		return insert(val, this.comp);
	}
	
	
	/**
	 * Inserts a value in the tree and returns the reference to the node. 
	 * @param val the value to be inserted. Cannot be null. Throws IllegalArgumentException if value is null.
	 * @param comp the comparator object. Cannot be null. Throws IllegalArgumentException if value is null.
	 * @return the reference to the node that was added in the tree
	 */
	public BinaryTreeNode<T> insert(T val, Comparator<T> comp){
		if(val == null){
			throw new IllegalArgumentException("Value can not be null");
		}else if (comp == null){
			throw new IllegalArgumentException("Comparator object can not be null");
		}else{
			//do nothing here. go ahead
		}
		if(root == null){
			root = new BinaryTreeNode<T>(val);
			return root;
		}else{
			//find the correct location for the node
			BinaryTreeNode<T> searchNode = root;
			while(true){
				int compareVal = comp.compare(val, searchNode.getVal());
				if(compareVal < 0){
					if(searchNode.getLeft() == null){
						break;
					} else{
						searchNode = searchNode.getLeft();
					}
				}else{
					if(searchNode.getRight() == null){
						break;
					} else {
						searchNode = searchNode.getRight();
					}
				}
			}
			BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(val, searchNode);
			if(comp.compare(val, searchNode.getVal()) < 0){
				searchNode.setLeft(newNode);
			}else{
				searchNode.setRight(newNode);
			}
			return newNode;
		}
	}
	
	/**
	 * Finds the next inorder successor of the first node encountered in the tree containing this value
	 * @param val the value whose inorder successor needs to be found. 
	 * @return the node containting the in order successor of the first node in the tree containing  this value. Returns null if the value is not found
	 */
	public BinaryTreeNode<T> findSuccessor(T val){
		if(val == null){
			throw new IllegalArgumentException("Value can not be null");
		} else if (this.comp == null){
			throw new IllegalStateException("Need to set implicit comparator object before calling this method");
		} else{
			//do nothing here. go ahead
		}
		return findSuccessor(val, this.comp);
	}
	
	/**
	 * Finds the next inorder successor of the first node encountered in the tree containing this value
	 * @param val the value whose inorder successor needs to be found. 
	 * @param comp the comparator object needed to make comparisons
	 * @return the node containting the in order successor of the first node in the tree containing  this value. Returns null if the value is not found
	 */
	public BinaryTreeNode<T> findSuccessor(T val, Comparator<T> comp){
		if(val == null){
			throw new IllegalArgumentException("Value can not be null");
		} else if (comp == null){
			throw new IllegalArgumentException("Comparator object can not be null");
		} else{
			//do nothing here. go ahead
		}
		BinaryTreeNode<T> node = find(val, comp);
		if(node == null){
			return null;
		}else{
			return findSuccessor(node);
		}
	}
	
	/**
	 * Finds the next inorder successor of the the given node
	 * @param node the node whose inorder successor has to be found
	 * @return the node containting the in order successor of the given node. Returns null if there is no successor for this node.
	 */
	public BinaryTreeNode<T> findSuccessor(BinaryTreeNode<T> node){
		if(node == null){
			throw new IllegalArgumentException("Node can not be null");
		} else if (this.comp == null){
			throw new IllegalStateException("Need to set implicit comparator object before calling this method");
		} else{
			//do nothing here. go ahead
		}
		
		return findSuccessor(node, this.comp);
	}
	
	/**
	 * Finds the next inorder successor of the the given node. If no right subtree, then there is none. Otherwise, the left most child of the 
	 * right subtree node is the successor. If there is no leftmost child, then it is the right subtree.
	 * @param node the node whose inorder successor has to be found
	 * @param comp the comparator object needed to make comparisons
	 * @return the node containting the in order successor of the given node. Returns null if there is no successor for this node.
	 */
	public BinaryTreeNode<T> findSuccessor(BinaryTreeNode<T> node, Comparator<T> comp){
		if(node == null){
			throw new IllegalArgumentException("Node can not be null");
		} else if (comp == null){
			throw new IllegalArgumentException("Comparator object can not be null");
		} else{
			//do nothing here. go ahead
		}
		
		if(node.getRight() == null){
			return null;
		}else{
			BinaryTreeNode<T> retNode = node.getRight();
			while(retNode.getLeft() != null){
				retNode = retNode.getLeft();
			}
			return retNode;
		}
	}
	
	/**
	 * Find the inorder predecessor of the given node. If there is no left subtree, then null. If yes, then  
	 * @param node the node whose in order predecessor needs to be found
	 * @param comp the comparator object needed to make comparisons
	 * @return
	 */
	public BinaryTreeNode<T> findPredecessor(BinaryTreeNode<T> node, Comparator<T> comp){
		if(node == null){
			throw new IllegalArgumentException("Node can not be null");
		} else if (comp == null){
			throw new IllegalArgumentException("Comparator object can not be null");
		} else {
			//do nothign here. go ahead
		}
		return null;
	}

}
