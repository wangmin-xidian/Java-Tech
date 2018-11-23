package com.min.algorithm.avltree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Title: AvlTreeInteger.java
 * @Package com.min.algorithm.avltree
 * @Description: 平衡二叉树 ： insert，remove
 * @author Min.WM.Wang
 * @date 2018年11月23日 上午10:47:15
 * 
 */
public class AvlTreeInteger {

	/**
	 * 前序遍历
	 */
	public static final int PRE_ORDER = 1;

	/**
	 * 中序遍历
	 */
	public static final int IN_ORDER = 2;

	/**
	 * 后序遍历
	 */
	public static final int POST_ORDER = 3;

	/**
	 * 广度-层级遍历
	 */
	public static final int BREADTH_ORDER = 4;

	private AvlNodeInteger root;

	private int size;

	/**
	 * 
	 */
	public AvlTreeInteger() {

	}

	/**
	 * @param root
	 */
	public AvlTreeInteger(AvlNodeInteger root) {
		this.root = root;
	}

	private void initRoot(Integer val) {
		AvlNodeInteger avlNodeInteger = new AvlNodeInteger(val);
		this.root = avlNodeInteger;
		System.out.println(this.root.getValue());
	}

	/**
	 * @param val
	 * @throws Exception
	 */
	public void insert(Integer val) throws Exception {
		if (null == root) {
			initRoot(val);
			size++;
			return;
		}
		if (contains(val)) {
			throw new Exception("This value is already exist! : " + val); //$NON-NLS-1$
		}
		// 更新tree root
		root = insertNode(root, val);
		size++;
	}

	/**
	 * @param val
	 * @return true if contains, else return false
	 */
	public boolean contains(Integer val) {
		AvlNodeInteger curNode = root;
		if (null == curNode) {
			return false;
		}

		while (null != curNode) {
			if (val > curNode.getValue()) {
				curNode = curNode.getRight();
			} else if (val < curNode.getValue()) {
				curNode = curNode.getLeft();
			} else {
				return true;
			}
		}

		return false;
	}

	private AvlNodeInteger createSingleNode(Integer val) {
		return new AvlNodeInteger(val);
	}

	/**
	 * 递归插入
	 * 
	 * @param parent
	 * @param val
	 * @return
	 */
	private AvlNodeInteger insertNode(AvlNodeInteger parent, Integer val) {
		if (parent == null) {
			return createSingleNode(val);
		}
		// 插入判断，小于父节点，插入到左边大于父节点，插入到右边	
		if (val < parent.getValue()) {
			parent.setLeft(insertNode(parent.getLeft(), val));										
		} else {
			parent.setRight(insertNode(parent.getRight(), val));
		}
		
		parent.setBalance(calBalance(parent));
		// 左子树，是L型 
		if (parent.getBalance() >=2) {
			// 根据insert的值来判断是LL型，还是LR型
			Integer leftChildValue = parent.getLeft().getValue();
			if (val < leftChildValue) {
				parent = leftLeftRotate(parent);
			} else {
				parent = leftRightRotate(parent);
			}
		}
		// 右子树，是R型
		if (parent.getBalance() <= -2) {
			// 根据insert的值来判断是RR型，还是RL型
			Integer rightChild = parent.getRight().getValue();
			if (val > rightChild) {
				parent = rightRightRotate(parent);
			} else {
				parent = rightLeftRotate(parent);
			}
		}
		
		parent.setDepth(calDepth(parent));
		return parent;
	}
	
	/**
	 * 计算平衡因子，左子树的深度-右子树的深度
	 * @param node
	 * @return 平衡因子
	 */
	private Integer calBalance (AvlNodeInteger node) {
		int leftDepth = 0;
		int rightDepth = 0;
		if (node.getLeft() != null) {
			leftDepth = node.getLeft().getDepth();
		} else {
			leftDepth = 0;
		}
		
		if (node.getRight() != null) {
			rightDepth = node.getRight().getDepth();
		} else {
			rightDepth = 0;
		}
		return leftDepth - rightDepth;
	}
	
	/**
	 * 计算节点的深度
	 * @param node
	 * @return 节点的深度
	 */
	private Integer calDepth (AvlNodeInteger node) {
		int depth = 0;
		if (node.getLeft() != null) {
			depth = node.getLeft().getDepth();
		}
		
		if (node.getRight() != null && depth < node.getRight().getDepth()) {
			depth = node.getRight().getDepth();
		}
		depth++;
		return depth;
	}
	

	/**
	 * 左左旋转模型：左子为父，父为右子，左孙变右孙
	 * 
	 * @param parentNode 旋转之前的parent node 节点
	 * @return 旋转之后的parent node节点
	 */
	private AvlNodeInteger leftLeftRotate(AvlNodeInteger parentNode) {
		AvlNodeInteger leftChild = parentNode.getLeft();
		// 左孙变右孙
		parentNode.setLeft(leftChild.getRight());
		// 父为右子
		leftChild.setRight(parentNode);
		parentNode.setDepth(calDepth(parentNode));
		parentNode.setBalance(calBalance(parentNode));
			
		// 左子为父
		leftChild.setDepth(calDepth(leftChild));
		leftChild.setBalance(calBalance(leftChild));
		return leftChild;
	}

	/**
	 * 右右旋转模型: 右子作父，父为左子，左孙变右孙
	 * 
	 * @param parentNode
	 * @return 父节点
	 */
	private AvlNodeInteger rightRightRotate(AvlNodeInteger parentNode) {
		AvlNodeInteger rightChild = parentNode.getRight();
		// 左孙变右孙
		parentNode.setRight(rightChild.getLeft());
		
		// 父为左子
		rightChild.setLeft(parentNode);
		parentNode.setDepth(calDepth(parentNode));
		parentNode.setBalance(calBalance(parentNode));

		// 右子作父
		rightChild.setDepth(calDepth(rightChild));
		rightChild.setBalance(calBalance(rightChild));
		return rightChild;
	}

	/**
	 * 左右模型，先右右，再左左
	 * 
	 * @param node
	 * @return
	 */
	private AvlNodeInteger leftRightRotate(AvlNodeInteger node) {
		// 左孩子按右右型旋转，转换成左左型
		node.setLeft(rightRightRotate(node.getLeft()));
		return leftLeftRotate(node);
	}

	/**
	 * 右左模型，先左左，再右右
	 * 
	 * @param node
	 * @return
	 */
	private AvlNodeInteger rightLeftRotate(AvlNodeInteger node) {
		// 右孩子按左左型旋转，转换成右右型
		node.setRight(leftLeftRotate(node.getRight()));
		return rightRightRotate(node);
	}


	/**
	 * @param val
	 */
	public void remove(Integer val) {
		if (null == val || null == root) {
			return;
		}

		if (!contains(val)) {
			System.out.println("This tree not contain value : " + val); //$NON-NLS-1$
			return;
		}

		root = remove(root, val);
	}
	
	private AvlNodeInteger remove(AvlNodeInteger parent, Integer val) {
		// 左子树递归查询
		if (val < parent.getValue()) {
			// 递归删除，返回替换的新节点
			AvlNodeInteger newLeft = remove(parent.getLeft(), val);
			parent.setLeft(newLeft);
			
			parent.setDepth(calDepth(parent));
			parent.setBalance(calBalance(parent));
			
			// 检查是否平衡，删除的左边，则是R- 型
			if (parent.getBalance() <= -2) {
				AvlNodeInteger tempNode = parent.getRight();
				tempNode.setDepth(calDepth(tempNode));
				tempNode.setBalance(calBalance(tempNode));				
				if (tempNode.getBalance() > 0) {
					parent = rightLeftRotate(parent);
				} else {
					parent = rightRightRotate(parent);
				}
			} 
		// 右子树递归查找
		} else if (val > parent.getValue()) {
			AvlNodeInteger newRight = remove(parent.getRight(), val);
			parent.setRight(newRight);
			
			parent.setDepth(calDepth(parent));
			parent.setBalance(calBalance(parent));
			
			// 检查是否平衡，删除的右边，则是L- 型， 并做调整
			if (parent.getBalance() >=2) {
				AvlNodeInteger tempNode = parent.getLeft();
				tempNode.setDepth(calDepth(tempNode));
				tempNode.setBalance(calBalance(tempNode));	
				if (tempNode.getBalance() > 0) {
					parent = leftLeftRotate(parent);
				} else {
					parent = leftRightRotate(parent);
				}
			}						
		// 相等，执行删除
		} else {
			if (parent.getLeft() == null || parent.getRight() == null) {
				AvlNodeInteger temp = null ;
				if (temp == parent.getLeft()) {
					temp = parent.getRight();
				} else {
					temp = parent.getLeft();
				}
				
				if (temp == null) {
					parent = null;
				} else {
					temp.setDepth(calDepth(temp));
					temp.setBalance(calBalance(temp));
					parent = temp;
				}								
			} else {
				parent.setBalance(calBalance(parent));
				// 判断高度，高的一方，拿到最大(左)，最小(右)的节点，作为替换节点。
				// 删除原来匹配节点，左边更高，获取到左边最大的节点
				if (parent.getBalance() > 0) {
					AvlNodeInteger leftMax = getMax(parent.getLeft());
					parent.setLeft(remove(parent.getLeft(), leftMax.getValue()));
					leftMax.setLeft(parent.getLeft());
					leftMax.setRight(parent.getRight());
					leftMax.setDepth(calDepth(leftMax));
					leftMax.setBalance(calBalance(leftMax));
					parent = leftMax;
				} else {
					AvlNodeInteger rightMin = getMin(parent.getRight());
					parent.setRight(remove(parent.getRight(), rightMin.getValue()));
					rightMin.setLeft(parent.getLeft());
					rightMin.setRight(parent.getRight());
					rightMin.setDepth(calDepth(rightMin));
					rightMin.setBalance(calBalance(rightMin));
					parent = rightMin;
				} 				
			}		
		}
		return parent;
	}
	
	
	/**
	 * 删除时用到，获取当前节点最大值子节点
	 * @param currentRoot
	 * @return
	 */
	private AvlNodeInteger getMax(AvlNodeInteger currentRoot) {
		if (currentRoot.getRight() != null) {
			currentRoot = getMax(currentRoot.getRight());
		}
		return currentRoot;
	}
	
	/**
	 * 删除时用到，获取当前节点最小值子节点
	 * @param currentRoot
	 * @return
	 */
	private AvlNodeInteger getMin(AvlNodeInteger currentRoot) {
		if (currentRoot.getLeft() != null) {
			currentRoot = getMin(currentRoot.getLeft());
		}
		return currentRoot;
	}
	
	/**
	 * find max node
	 * @return AvlNodeInteger
	 */
	public AvlNodeInteger findMax() {
		if (null == root) {
			return null;
		}
		
		AvlNodeInteger temp = root;
		while( null != temp.getRight()) {
			temp = temp.getRight();
		}
		return temp;
	}
	
	/**
	 * get min root
	 * @return AvlNodeInteger
	 */
	public AvlNodeInteger findMin() {
		if (null == root) {
			return null;
		}
		
		AvlNodeInteger temp = root;
		while (null != temp.getLeft()) {
			temp = temp.getLeft();
		}
		return temp;
	}
	
	/**
	 * @return size
	 */
	public int getNodeSize() {
		return size;
	}
	
	
	/**
	 * print tree by different style 
	 * style 1 : preOrder
	 * style 2 : inOrder 
	 * style 3 : postOrder 
	 * style 4 : breadthOrder
	 * default : preOrder
	 * @param style
	 */
	public void printTree(int style) {
		if (root == null) {
			return;
		}
		
		switch(style) {
			case 1: 
				preOrder(root);
				break;
			case 2 :
				inOrder(root);
				break;
			case 3:
				postOrder(root);
				break;
			case 4: 
				List<AvlNodeInteger> a = new ArrayList<>();
				a.add(root);
				breadthOrder(a);
				break;
			default:
				preOrder(root);
				break;		
		}
	}
	
	private void preOrder(AvlNodeInteger parent) {
		System.out.println(parent.getValue());
		if (null != parent.getLeft()) {
			preOrder(parent.getLeft());
		}
		if (null != parent.getRight()) {
			preOrder(parent.getRight());
		}
	}
	
	private void inOrder(AvlNodeInteger parent) {
		if (null != parent.getLeft()) {
			inOrder(parent.getLeft());
		}		
		System.out.println(parent.getValue());		
		if (null != parent.getRight()) {
			inOrder(parent.getRight());
		}		
	}
	
	private void postOrder(AvlNodeInteger parent) {
		if (null != parent.getLeft()) {
			postOrder(parent.getLeft());
		}		
		if (null != parent.getRight()) {
			postOrder(parent.getRight());
		}
		System.out.println(parent.getValue());		
	}
	
	private void breadthOrder(List<AvlNodeInteger> parent) {
		if (null == parent || parent.isEmpty()) {
			return;
		}
		
		List<AvlNodeInteger> avlNodeIntegerList = new ArrayList<>();
		for (int i = 0; i < parent.size(); i++) {
			AvlNodeInteger currentNode = parent.get(i);
			System.out.print(currentNode.getValue() + ","); //$NON-NLS-1$
			
			if (null != currentNode.getLeft()) {
				avlNodeIntegerList.add(currentNode.getLeft());
			}
			
			if (null != currentNode.getRight()) {
				avlNodeIntegerList.add(currentNode.getRight());
			}
			
		}
		System.out.println();
		breadthOrder(avlNodeIntegerList);
	}
	
}
