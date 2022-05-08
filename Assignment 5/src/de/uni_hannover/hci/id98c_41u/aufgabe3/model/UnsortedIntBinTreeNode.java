package de.uni_hannover.hci.id98c_41u.aufgabe3.model;

import java.util.Random;

//Inserts randomly left or right. Needs to search through both subtrees, as
//there is no way of knowing where the node containing i might be.
public class UnsortedIntBinTreeNode extends IntBinTreeNode {
	private static Random rand;
	
	
	public UnsortedIntBinTreeNode(int content, IntBinTreeNode left, IntBinTreeNode right) {//class lacks a constructor method
		super(content, left, right);
		UnsortedIntBinTreeNode.rand = new Random();
	}

  /**
   * Randomly inserts to left or right.
   * If left/right is not null, call insert on that child node.
   * 
   * @param i Integer to insert.
   */
  @Override
  public void insert(int i) {
    if (UnsortedIntBinTreeNode.rand.nextBoolean()) {
      if (super.left_ == null) 
        super.left_ = new UnsortedIntBinTreeNode(i, null, null);
      else
        super.left_.insert(i);
    } else {
      if (super.right_ == null) 
        super.right_ = new UnsortedIntBinTreeNode(i, null, null);
      else
        super.right_.insert(i);
    }
  }

  /**
   * Looks if integer is in tree.
   * Looks through both subtrees, as they are not sorted.
   * 
   * @param i Integer to search for.
   * @return  True if integer is in tree.
   */
  @Override
  public boolean contains(int i) {
    return super.content_ == i || (super.left_ != null && super.left_.contains(i)) || (super.right_ != null && super.right_.contains(i));
  }
}