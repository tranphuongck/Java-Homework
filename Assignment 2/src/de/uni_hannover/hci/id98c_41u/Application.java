//Main class
package de.uni_hannover.hci.id98c_41u;
import de.uni_hannover.hci.id98c_41u.objects.*;

public class Application {

	public static void main(String[] args) {
		Ladybug bug = new Ladybug(1);
		Clover clov = new Clover(0);
		Tree tree = new Tree(0);
		bug.printLadybug(bug.getDirection());
		bug.setDirection("D");
		bug.printLadybug(bug.getDirection());
		bug.setDirection("S");
		bug.printLadybug(bug.getDirection());
		bug.setDirection("A");
		bug.printLadybug(bug.getDirection());
		tree.printTree();
		clov.printClover();
		clov.setScore(10);
		System.out.print(clov.getScore());
	}

}
