/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Provides utility methods for trees
 * @author Abhineet (sharma.abhineet31@gmail.com)
 */
public class TreeUtil {
	
	/**
	 * Depth first search for a given value in the tree
	 * @param root the root node of the tree
	 * @param val the value that needs to be searched
	 * @param comp comparator object
	 * @return the first node encountered ( depth first )  containing the value. Null, Otherwise. 
	 */
	public static<T> BinaryTreeNode<T> dfs(BinaryTreeNode<T> root, T val, Comparator<T> comp){
		if(comp == null){
			throw new IllegalArgumentException("Comparator object must not be null");
		}else if (root == null || val == null){
			throw new IllegalArgumentException("Root or value must not be null");
		}else{
			//do nothing
		}
		
		Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>(); 
		stack.push(root);
		while(!stack.isEmpty()){
			BinaryTreeNode<T> node = stack.pop();
			if(comp.compare(node.getVal(), val) == 0){
				return node;
			}else{
				if(node.getRight() != null){
					stack.push(node.getRight());
				}else{
					//do nothing here
				}
				
				if(node.getLeft() != null){
					stack.push(node.getLeft());
				}else{
					//do nothing here.
				}
			}
		}
		return null;
	}
	
	/**
	 * Breadth First search in a tree starting frmo the value
	 * @param root the root of the tree
	 * @param val the value that needs to be searched for.
	 * @param comp Comparator object to compare the values
	 * @return the node containing the specified value in the tree. Null, Otherwise
	 */
	public static<T> BinaryTreeNode<T> bfs(BinaryTreeNode<T> root, T val, Comparator<T> comp){
		if(comp == null){
			throw new IllegalArgumentException("Comparator object must not be null");
		}else if (root == null || val == null){
			throw new IllegalArgumentException("Root or value must not be null");
		}else{
			//do nothing
		}
		Queue<BinaryTreeNode<T>> q = new LinkedList<BinaryTreeNode<T>>();
		q.add(root);
		while(!q.isEmpty()){
			BinaryTreeNode<T> node = q.poll();
			if(comp.compare(node.getVal(), val) == 0){
				return node;
			}else{
				if(node.getLeft() != null){
					q.add(node.getLeft());
				}else{
					//do nothign here
				}
				
				if(node.getRight() != null){
					q.add(node.getRight());
				}else{
					//do nothing here.
				}
			}
		}
		return null;
	}
	
	/**
	 * Returns the minimum depth of the binary tree
	 * @param root the root node of the binary tree
	 * @return the minimum depth of the tree
	 */
	public static<T> int minDepth(BinaryTreeNode<T> root){
		if(root == null){
			return 0;
		} else if ( root.getLeft() == null){
			return minDepth(root.getRight()) + 1;
		} else if ( root.getRight() == null){
			return minDepth(root.getLeft()) + 1;
		} else{
			return Math.min(minDepth(root.getLeft()), minDepth(root.getRight()) + 1);
		}
	}
	
	/**
	 * Level Order Traversal of a binary tree starting from the given node as root 
	 * @param root the root node of the tree
	 * @return the list of list of values where the list at a particular level contains the values at that level in the tree
	 */
	public static<T> List<List<T>> levelOrderTraversal(BinaryTreeNode<T> root){
		if(root == null){
			return Collections.emptyList();
		}else{
			//do nothing here.
		}
		int level = 0;
		List<List<T>> retList = new ArrayList<List<T>>();
		List<BinaryTreeNode<T>> parentList = new ArrayList<BinaryTreeNode<T>>();
		parentList.add(root);
		while(!parentList.isEmpty()){
			retList.add(new ArrayList<T>());
			//Get all children for parents
			List<BinaryTreeNode<T>> childList = new ArrayList<BinaryTreeNode<T>>();
			for(BinaryTreeNode<T> parent : parentList){
				retList.get(level).add(parent.getVal());
				if(parent.getLeft() != null){
					childList.add(parent.getLeft());
				}else{
					//do nothing here. 
				}
				
				if(parent.getRight() != null){
					childList.add(parent.getRight());
				}else{
					//do nothing here.
				}
			}
			parentList = childList;
			level++;
		}
		return retList;
	}
	
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
