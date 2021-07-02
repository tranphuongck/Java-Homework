//Main class
package de.uni_hannover.hci.id98c_41u;
import de.uni_hannover.hci.id98c_41u.objects.*;

/**
 * The main class of Ladybug game.
 *
 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
 * @version	2021/5/3
 */
public class Application {

	public static void main(String[] args) {	
		
		/**Create and play the game*/
		Game game = new Game(10,15);
		game.play();
	}

}
