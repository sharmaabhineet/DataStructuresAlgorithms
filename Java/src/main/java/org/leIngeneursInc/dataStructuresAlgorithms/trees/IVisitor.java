/**
 * 
 */
package org.leIngeneursInc.dataStructuresAlgorithms.trees;

/**
 * Interface for implementation of Visitor pattern. Lets user specify the 
 * operation needs to be performed on the data by providing implementation to the 
 * visit operation of this interface.
 * @author Abhineet (sharma.abhineet31@gmail.com)
 */
public interface IVisitor<T> {
	public void visit(BinaryTreeNode<T> node);
}
