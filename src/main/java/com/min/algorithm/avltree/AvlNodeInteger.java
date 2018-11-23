package com.min.algorithm.avltree;

/**
 *
 * @Title: AvlNodeInteger.java
 * @Package com.min.algorithm.avltree
 * @Description: AvlNodeInteger
 * @author Min.WM.Wang
 * @date 2018年11月21日 上午9:44:57
 * 
 */
public class AvlNodeInteger {
	
	private Integer value;
	
	private Integer depth;
	
	private AvlNodeInteger left;
	
	private AvlNodeInteger right;
	
	private Integer balance = 0;
	
	
	/**
	 * @param t
	 */
	public AvlNodeInteger (int t) {
		initNode(t, null, null, 1);
	}
	
	/**
	 * @param t
	 * @param left
	 * @param right
	 */
	public AvlNodeInteger (int t, AvlNodeInteger left, AvlNodeInteger right) {
		initNode(t, left, right, null);
	}
	
	private void initNode(int t, AvlNodeInteger left, AvlNodeInteger right, Integer depth) {
		this.setValue(t);
		this.left = left;
		this.right = right;
		this.depth = depth;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	/**
	 * @return the depth
	 */
	public Integer getDepth() {		
		return depth;
	}

	/**
	 * @param depth the depth to set
	 */
	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	/**
	 * @return the balance
	 */
	public Integer getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	/**
	 * @return the left
	 */
	public AvlNodeInteger getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(AvlNodeInteger left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public AvlNodeInteger getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(AvlNodeInteger right) {
		this.right = right;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AvlNodeInteger [value=" + value + ", depth=" + depth  //$NON-NLS-1$ //$NON-NLS-2$
				+ ", balance=" + balance //$NON-NLS-1$
				+ ", left=" + left + ", right=" + right  + "]";  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
	
	
	

}
