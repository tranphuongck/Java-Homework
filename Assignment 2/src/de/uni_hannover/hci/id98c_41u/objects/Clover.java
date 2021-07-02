//Collectible object
package de.uni_hannover.hci.id98c_41u.objects;

public class Clover {
	private int score;
	
	public Clover (int point) {
		this.score = point;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int point) {
		score = point;
	}
	
	public void printClover() {
		System.out.println("+");
	}
}
