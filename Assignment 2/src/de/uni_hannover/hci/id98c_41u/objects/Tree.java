//Inaccessible object
package de.uni_hannover.hci.id98c_41u.objects;

public class Tree {
	int treeAmount;
	
	public Tree (int treeAmount) {
		this.treeAmount = treeAmount;
	}
	
	public int getTreeAmount() {
		return treeAmount;
	}
	
	public void setTreeAmount(int treeAmount) {
		this.treeAmount = treeAmount;
	}
	
	public void printTree() {
		System.out.println("O");
	}
}
