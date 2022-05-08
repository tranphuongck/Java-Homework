package de.uni_hannover.hci.id98c_41u.aufgabe3;
import de.uni_hannover.hci.id98c_41u.aufgabe3.model.*;


public class Debug {
  public static void main(String[] args) {
    
    IntBinTreeNode treeSorted = new SortedIntBinTreeNode(1, null, null);
    IntBinTreeNode treeUnsorted = new UnsortedIntBinTreeNode(1, null, null);
    int[] toInsert = { 4, 2, 6, 8, 0, 2, 1, 5, 1 };
    // for each i in toInsert
    for (int i : toInsert) {
      treeSorted.insert(i);
      treeUnsorted.insert(i);
    }
    System.out.println(treeSorted);
    System.out.println(treeUnsorted);
  }
}
/*
 * Line 9: The constructor UnsortedIntBinTreeNode(int, null, null) is undefined
 * */