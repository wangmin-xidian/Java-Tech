package com.min.algorithm.avltree;

/**
 * 
 *
 * @Title: AppTest.java
 * @Package com.min.algorithm.avltree
 * @Description: Test AVL tree ： insert，remove
 * @author Min.WM.Wang
 * @date 2018年11月23日 下午5:26:12
 *
 */
public class AppTest {
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {		
		insertLLTree();
		insertRRTree();
		insertLRTree();
		insertRLTree();	
		removeTree();
	}
	
	private static void insertLLTree() throws Exception {
		AvlTreeInteger leftLeftTree = new AvlTreeInteger(new AvlNodeInteger(5));		
		leftLeftTree.insert(3);
		leftLeftTree.insert(6);
		leftLeftTree.insert(4);
		leftLeftTree.insert(2);		
		leftLeftTree.insert(1);	
		
		leftLeftTree.printTree(4);
		System.out.println("****************************"); //$NON-NLS-1$
	}
	
	private static void insertRRTree() throws Exception {	
		AvlTreeInteger rightRightTree = new AvlTreeInteger(new AvlNodeInteger(2));		
		rightRightTree.insert(1);
		rightRightTree.insert(4);
		rightRightTree.insert(3);
		rightRightTree.insert(5);
		
		rightRightTree.insert(6);
		rightRightTree.printTree(4);
		System.out.println("****************************"); //$NON-NLS-1$
	}
	
	private static void insertLRTree() throws Exception {
		AvlTreeInteger leftRightTree = new AvlTreeInteger(new AvlNodeInteger(5));
		leftRightTree.insert(2);
		leftRightTree.insert(6);
		leftRightTree.insert(1);
		leftRightTree.insert(3);
		
		leftRightTree.insert(4);
		leftRightTree.printTree(4);
		System.out.println("****************************"); //$NON-NLS-1$
	}
	
	private static void insertRLTree() throws Exception {
		AvlTreeInteger rightLeftTree = new AvlTreeInteger(new AvlNodeInteger(2));
		rightLeftTree.insert(1);
		rightLeftTree.insert(5);
		rightLeftTree.insert(4);
		rightLeftTree.insert(6);
		
		rightLeftTree.insert(3);
		rightLeftTree.printTree(4);
		System.out.println("****************************"); //$NON-NLS-1$
	}
	
	private static void removeTree() throws Exception {
		AvlTreeInteger tree = new AvlTreeInteger(new AvlNodeInteger(50));
		tree.insert(25);
		tree.insert(75);
		tree.insert(10);
		tree.insert(30);
		tree.insert(60);
		tree.insert(80);
		tree.insert(5);
		tree.insert(15);
		tree.insert(27);
		tree.insert(55);
		tree.insert(1);
		
		tree.printTree(4);
		System.out.println("****************************"); //$NON-NLS-1$
		
		tree.remove(80);
		tree.printTree(4);
		System.out.println("****************************"); //$NON-NLS-1$
		
	}

}
