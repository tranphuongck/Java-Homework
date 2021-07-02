//Player character object
package de.uni_hannover.hci.id98c_41u.objects;

public class Ladybug {
	public int direction;
	private Clover[] clover;
	
	public Ladybug (int direction) {
		this.direction = direction;
		this.clover = new Clover[10];
	}
	
	public Ladybug() {
		this(0);
	}
	
	public void setDirection(String input) {
		switch (input) {
		case "W":
			direction = 1;
			break;
		case "D":
			direction = 2;
			break;
		case "S":
			direction = 3;
			break;
		case "A":
			direction = 4;
			break;
		}
	}
	
	public int getDirection() {
		return this.direction;
	}
	
    public void turnRight() {
        this.direction = (this.direction + 1) % 4;
    }

    public void turnLeft() {
        this.direction = (this.direction + 3) % 4;
    }


	public int getClover() {
        int result = 0;
        for (int i = 0; i < this.clover.length; ++i) {
            result += this.clover[i].getScore();
        }
        return result;
	}
	
	public void printLadybug(int direction) {
		switch (this.direction) {
		case 1:
			System.out.println("^");
			break;
		case 2:
			System.out.println(">");
			break;
		case 3:
			System.out.println("v");
			break;
		case 4:
			System.out.println("<");
			break;
		}
	}
	
}
