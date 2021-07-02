//Collectible object
package de.uni_hannover.hci.id98c_41u.objects;

/**
 * The Tree class of Ladybug game, represents the finish line and collectible object in the game.
 *
 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
 * @version	2021/5/3
 */
public class Clover {
	private int score;
	
	/**
	 * Constructor method for the class.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	point	Collected clover.
	 * */
	public Clover (int point) {
		this.score = point;
	}
	
	/**
	 * Getter for the score.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @return	Collected clover.
	 * */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * Setter for the score.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	Collected clover.
	 * */
	public void setScore(int point) {
		score = point;
	}

	/**
	 * Return the object as String.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @return	Clover in String format.
	 * */
	public String strClover() {
		return "+ ";
	}
}
