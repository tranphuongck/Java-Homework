//Player character object
package de.uni_hannover.hci.id98c_41u.objects;

/**
 * The Ladybug class of Ladybug game, represents the Ladybug and player character object in the game.
 *
 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
 * @version	2021/5/3
 */
public class Ladybug {
	/**Array of collected clover and the direction of the bug*/
	private Clover[] clover;
	public Direction drt = Direction.NORTH;
	
	/**
	 * Constructor method for the class.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * */
	public Ladybug () {
		this.drt = Direction.NORTH;
		this.clover = new Clover[10];
	}
	
	/**
	 * Setter for the direction.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	input	User input.
	 * */
	public void setDirection(char input) {
		switch (input) {
		case 'W':
			this.drt = Direction.NORTH;
			break;
		case 'D':
			this.drt = Direction.EAST;
			break;
		case 'S':
			this.drt = Direction.SOUTH;
			break;
		case 'A':
			this.drt = Direction.WEST;
			break;
		}
	}
	
	/**
	 * Getter for the direction.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @return	Bug direction.
	 * */
	public Direction getDirection() {
		return this.drt;
	}
	
	/**
	 * Getter for the clover array.
	 * 
	 * @return	Collected clover
	 * */
	public int getClover() {
        int result = 0;
        for (int i = 0; i < this.clover.length; ++i) {
            result += this.clover[i].getScore();
        }
        return result;
	}
	
	/**
	 * Return the object as String.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @return	Bug in String format.
	 * */
	public String strLadybug() {
		if (this.drt == Direction.NORTH) return "^ ";
		else if (this.drt == Direction.EAST) return "> ";
		else if (this.drt == Direction.SOUTH) return "v ";
		else return "< ";
	}
	
	/**Bug direction enum*/
	public enum Direction {
		NORTH,
		EAST,
		SOUTH,
		WEST
	}
	
}
