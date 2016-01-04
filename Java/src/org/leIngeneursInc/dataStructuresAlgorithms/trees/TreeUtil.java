/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Provides utility methods for trees
 * @author Abhineet (sharma.abhineet31@gmail.com)
 */
public class TreeUtil {

	/**
	 * Performs an inorder walk on a tree given its root node.
	 * @param root the root node of the tree
	 * @param visitor the visitor object specifying the operation to do on visting a certain node
	 */
	public static<T> void inOrderTraversal(BinaryTreeNode<T> root, IVisitor<T> visitor){
		if(visitor == null){
			throw new IllegalArgumentException("Visitor object can not be null");
		}else if ( root == null){
			return;
		}else{
			//do nothing here. go ahead
		}
		if(root.getLeft() != null){
			inOrderTraversal(root.getLeft(), visitor);
		}
		visitor.visit(root);
		if(root.getRight() != null){
			inOrderTraversal(root.getRight(), visitor);
		}
	}
	
	/**
	 * Performs inorder walk of a tree given its root node and returns a list of values 
	 * in the order visited
	 * @param root the root node of the tree
	 * @return list of values in the order visited
	 */
	public static<T> List<T> inOrderTraversal(BinaryTreeNode<T> root){
		if(root == null){
			return Collections.emptyList();
		}else{
			//do nothing here. go ahead
		}
		List<T> retList = new ArrayList<T>();
		if(root.getLeft() != null){
			retList.addAll(inOrderTraversal(root.getLeft()));
		}
		retList.add(root.getVal());
		if(root.getRight() !=  null){
			retList.addAll(inOrderTraversal(root.getRight()));
		}
		return retList;
	}
	
	/**
	 * Performs a preorder walk in a tree given its root node.
	 * @param root the root node of the tree
	 * @param visitor visitor object specifying the operation needs to be performed when any node is visited
	 */
	public static<T> void preOrderTraversal(BinaryTreeNode<T> root, IVisitor<T> visitor){
		if(visitor == null){
			throw new IllegalArgumentException("Visitor object can not be null");
		}else if ( root == null){
			return;
		}else{
			//do nothing here. go ahead
		}
		visitor.visit(root);
		if(root.getLeft() != null){
			preOrderTraversal(root.getLeft(), visitor);
		}
		
		if(root.getRight() != null){
			preOrderTraversal(root.getRight(), visitor);
		}
	}
	
	/**
	 * Performs a preorder walk in a tree given the root node and returns a list of values in the order visited
	 * @param root the root of the subtree
	 * @return the list of values in the order visited
	 */
	public static<T> List<T> preOrderTraversal(BinaryTreeNode<T> root){
		if(root == null){
			return Collections.emptyList();
		}else{
			//do nothing here. go ahead
		}
		List<T> retList = new ArrayList<T>();
		retList.add(root.getVal());
		if(root.getLeft() != null){
			retList.addAll(preOrderTraversal(root.getLeft()));
		}
		
		if(root.getRight() !=  null){
			retList.addAll(preOrderTraversal(root.getRight()));
		}
		return retList;
	}
	
	/**
	 * Performs a postorder walk in a tree given its root node.
	 * @param root the root node of the tree
	 * @param visitor visitor object specifying the operation needs to be performed when any node is visited
	 */
	public static<T> void postOrderTraversal(BinaryTreeNode<T> root, IVisitor<T> visitor){
		if(visitor == null){
			throw new IllegalArgumentException("Visitor object can not be null");
		}else if ( root == null){
			return;
		}else{
			//do nothing here. go ahead
		}
		if(root.getLeft() != null){
			postOrderTraversal(root.getLeft(), visitor);
		}
		
		if(root.getRight() != null){
			postOrderTraversal(root.getRight(), visitor);
		}
		visitor.visit(root);
	}
	
	/**
	 * Performs a postorder walk in a tree given the root node and returns a list of values in the order visited
	 * @param root the root of the subtree
	 * @return the list of values in the order visited
	 */
	public static<T> List<T> postOrderTraversal(BinaryTreeNode<T> root){
		if(root == null){
			return Collections.emptyList();
		}else{
			//do nothing here. go ahead
		}
		List<T> retList = new ArrayList<T>();
		if(root.getLeft() != null){
			retList.addAll(postOrderTraversal(root.getLeft()));
		}
		
		if(root.getRight() !=  null){
			retList.addAll(postOrderTraversal(root.getRight()));
		}
		retList.add(root.getVal());
		return retList;
	}
	
	/**
	 * Find the node containing the minimum value in the binary search tree
	 * @param root the root of the tree from where to begin the search
	 * @return the node containing the minimum value in the binary search tree
	 */
	public static<T> BinaryTreeNode<T> findMin(BinaryTreeNode<T> root){
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
	 * @param root the root of the tree from where to begin the search
	 * @return the node containing the maximum value in the binary search tree
	 */
	public static<T> BinaryTreeNode<T> findMax(BinaryTreeNode<T> root){
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
	 * checks if given tree is a valid binary search tree
	 * @param root the root of the tree
	 * @param comp the comparator object needed to compare the valuse
	 * @return boolean value indicating whether or not the given tree is a binary search tree
	 */
	public static<T> boolean isValidBST(BinaryTreeNode<T> root, Comparator<T> comp){
		if(comp == null){
			throw new IllegalArgumentException("Comparator object must not be null");
		}else{
			//do nothign here.
		}
		
		if(root == null){
			return true;
		} else {
			if(root.getLeft() == null && root.getRight() == null){
				return true;
			}else{
				if(root.getLeft() != null && comp.compare(root.getVal(), root.getLeft().getVal()) > 0 ){
					return false;
				}else{
					//do nothign here. go ahead
				}
				
				if ( root.getRight() != null && comp.compare(root.getVal(), root.getRight().getVal()) <0){
					return false;
				}else{
					//do nothing here. go ahead.
				}
				
				return isValidBST(root.getLeft(), comp) && isValidBST(root.getRight(), comp);
			}
		}
	}
}
