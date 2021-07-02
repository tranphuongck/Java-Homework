package de.uni_hannover.hci.id98c_41u.objects;

public class Entity {
	protected String tree = "O ";
	protected String clover = "+ ";
	
	/**
	 * Constructor method for the class.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * */
	public Entity() {
	}
	
	/**
	 * Return the object as String.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @return	Tree in String format.
	 * */
	protected String strTree() {
		return this.tree;
	}
	
	/**
	 * Return the object as String.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @return	Clover in String format.
	 * */
	protected String strClover() {
		return this.clover;
	}
}
