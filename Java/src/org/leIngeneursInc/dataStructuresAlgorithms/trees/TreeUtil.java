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
	 * Returns the lowest common ancestor of two given nodes from the root node. This method ensures that the given nodes have root as their ancestor
	 * @param root the root of the tree
	 * @param node1 first node
	 * @param node2 second node
	 * @param comp comparator object
	 * @return the lowest common ancestor of the tree
	 */
	public static<T> BinaryTreeNode<T> lowestCommonAncestor(BinaryTreeNode<T> root, BinaryTreeNode<T> node1, BinaryTreeNode<T> node2, Comparator<T> comp){
		if(comp == null){
			throw new IllegalArgumentException("Comparator can not be null");
		}else{
			//do nothing here. go ahead
		}
		if(root == null || !isAncestor(node1, root) || !isAncestor(node2, root)){
			return null;
		}else{
			// the nodes exist in tree. Need to find their common ancestor
		}
		
		if(root == node1 || root == node2){
			return root;
		}else{
			//do nothing here. go ahead
		}
		
		int compVal1 = comp.compare(root.getVal(), node1.getVal());
		int compVal2 = comp.compare(root.getVal(), node2.getVal());
		if( ( compVal1 < 0 && compVal2 > 0 )
				|| (compVal1 > 0 && compVal2 < 0) ){
			return root;
		}else{
			if( compVal1 < 0 && compVal2 < 0 ){
				return lowestCommonAncestor(root.getRight(), node1, node2, comp);
			}else{
				return lowestCommonAncestor(root.getLeft(), node1, node2, comp);
			}
		}
		
	}
	
	/**
	 * Checks if a given node is ancestor to a particular node
	 * @param node the node whose hierarchy must be checked
	 * @param ancestor the node which has to be evaluated as a potential ancestor
	 * @return boolean value indicating whether or not ancestor is actually an ancestor to node
	 */
	public static<T> boolean isAncestor(BinaryTreeNode<T> node, BinaryTreeNode<T> ancestor ){
		if (node == ancestor){
			return true;
		}else if(node == null || ancestor == null){
			return false;
		}else{
			while(node.getParent() != null){
				if( node.getParent() == ancestor){
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * Finds a particular node in the tree by comparing its reference for equality and using its value for traversal. Check if a particular node exists in the tree
	 * This algorithm works when we are not having parents as references.
	 * @param root the root of the tree
	 * @param node the node that needs to be located
	 * @param comp comparator
	 * @return
	 */
	public static<T> BinaryTreeNode<T> findByComparingRef(BinaryTreeNode<T> root, BinaryTreeNode<T> node , Comparator<T> comp){
		if(root == null || root == node){
			return root;
		}else{
			if(comp == null){
				throw new IllegalArgumentException("Comparator can not be null");
			}else{
				//do nothing here.
			}
			
			
			while(root != null){
				int compVal = comp.compare(root.getVal(), node.getVal());
				if(compVal < 0){
					root = root.getRight();
				}else if ( compVal > 0){
					root = root.getLeft();
				}else{
					if(root == node){
						return root;
					}else{
						//continue
					}
				}
			}
			return root;
		}
	}
	
	/**
	 * Inverts the tree in place. Left child of each node becomes right and vice versa
	 * @param root the root node of the tree that has to be inverted
	 */
	public static<T> void invertTree(BinaryTreeNode<T> root){
		if(root == null){
			return ;
		}else{
			BinaryTreeNode<T> temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);
			invertTree(root.getLeft());
			invertTree(root.getRight());
			return;
		}
	}
	
	
	/**
	 * Returns boolean value indicating whether or not the tree is balanced
	 * @param root the root node of the tree
	 * @return boolean value indicating whether or not the tree is balanced
	 */
	public static<T> boolean isBalanced(BinaryTreeNode<T> root){
		if(root == null ){
			return true;
		}else{
			return height(root.getLeft()) == height(root.getRight()) && isBalanced(root.getLeft()) && isBalanced(root.getRight());
		}
	}
	
	
	/**
	 * Returns the height of tree starting from the root node
	 * @param root the node whose height has to be calculated
	 * @return the height of the tree
	 */
	public static<T> int height(BinaryTreeNode<T> root){
		if(root == null){
			return 0;
		}else{
			return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
		}
	}

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
				if(root.getLeft() != null && comp.compare(root.getVal(), root.getLeft().getVal()) < 0 ){
					return false;
				}else{
					//do nothign here. go ahead
				}
				
				if ( root.getRight() != null && comp.compare(root.getVal(), root.getRight().getVal()) > 0){
					return false;
				}else{
					//do nothing here. go ahead.
				}
				
				return isValidBST(root.getLeft(), comp) && isValidBST(root.getRight(), comp);
			}
		}
	}
}
