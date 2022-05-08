package de.uni_hannover.hci.id98c_41u.aufgabe3.model;

//Inserts integers in a sorted way. Only needs to search in one subtree as a
//result.
public class SortedIntBinTreeNode extends IntBinTreeNode {
  
  public SortedIntBinTreeNode(int content, SortedIntBinTreeNode left, SortedIntBinTreeNode right) {
    super(content, left, right);
    if ((left != null && left.content_ >= content) || (right != null && right.content_ <= content)) {
      System.err.println("Trying to create invalid sorted tree.");
      System.exit(2);
    }
  }

  	/**
  	 * Inserts integer into the sorted tree.
  	 * Smaller Integers will be placed into the left subtree, larger ones into
  	 * the right subtree. Equal ones will be ignored
  	 * 
  	 * @param i Integer to insert.
  	 */
  	@Override
  	public void insert(int i) {
  		if (i > super.content_) {
  			if (super.left_ == null) 
  				super.left_ = new SortedIntBinTreeNode(i, null, null);
  			else
  				super.left_.insert(i);
  		} else if (i < super.content_) {
  			if (super.right_ == null) 
  				super.right_ = new SortedIntBinTreeNode(i, null, null);
  			else
  				super.right_.insert(i);
  			}
  	}

  	@Override
	public boolean contains(int i) {//needs to have a method that inherit super class abstract method
  		return super.content_ == i || (super.left_ != null && super.left_.contains(i)) || (super.right_ != null && super.right_.contains(i));
  	}
}
/*
 * Line 7: Implicit super constructor IntBinTreeNode() is undefined for default constructor. Must define an explicit constructor
 * 
 */