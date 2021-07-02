package de.uni_hannover.hci.id98c_41u.objects;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * The Game class of Ladybug game, responsible for creating game field, tracks game status
 * and control the player character object (Ladybug).
 *
 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
 * @version	2021/5/3
 */
public class Game {
	/**Row and col of the playing field, with objects on the field*/
	public int row;
	public int col;
	private Ladybug bug = new Ladybug();
	private Entity entity = new Entity();
	private int[] clovX = new int[10];
	private int[] clovY = new int[10];
	private int clovCount = 0;
	private int currClov = 0;
	private String[][] field;
	
	/**
	 * Constructor method for the class.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param length	Length of the field
	 * @param width		Width of the field
	 * */
	public Game (int length, int width) {
		this.row = length;
		this.col = width;
		this.field = new String[this.row][this.col + 1];
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.col + 1; j++) {
				if (j < this.col) this.field[i][j] = "  ";
				else this.field[i][j] ="\n";
			}
		}
	}
	
	/**
	 * This method print out the created playing field Array as a String.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	field	Playing field.
	 * */
	private void printField(String[][] field) {
		for (String[] row: field) {
			System.out.print(Arrays.toString(row).replace(", ", "").replace("[", "").replace("]", ""));
		}
	}
	
	/**
	 * This method searchs for a String in coordinate in the field and replace it with another String.
	 * 
	 * @param	x	Coordinate on x-Axis.
	 * @param	y	Coordinate on y-Axis.
	 * @param	str		Replacement string.
	 * */
	private void cordReplace(int x, int y, String str) {
		int row = this.field.length;
		int col = this.field[0].length;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == x && j == y) this.field[i][j] = str;
			}
		}
	}
	
	/**
	 * This method surrounds the edges of the field with Tree objects.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * */
	private void Border() {
		int row = this.field.length;
		int col = this.field[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col - 1; j++) {
				if (i == 0 || i == row - 1) this.field[i][j] = entity.strTree();
				else if (j == 0 || j == col - 2) this.field[i][j] = entity.strTree();
			}
		}
		cordReplace(0, 1, bug.strLadybug());
		cordReplace(row - 1, col - 3, entity.strClover());
	}
	
	
	/**
	 * This method finds the int value of x-Axis coordinate of Ladybug.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @return	x	Ladybug coordinate on x-Axis.
	 * */
	private int findBugX() {
		int x = 0;
		for (int i = 0; i < this.field.length; i++) {
			for (int j = 0; j < this.field[0].length; j++) {
				if (this.field[i][j].equals("^ ") || this.field[i][j].equals("< ") || this.field[i][j].equals("> ") || this.field[i][j].equals("v ")) x = i;
			}
		}
		return x;
	}
	
	/**
	 * This method finds the int value of y-Axis coordinate of Ladybug.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @return	y	Ladybug coordinate on y-Axis.
	 * */
	private int findBugY() {
		int y = 0;
		for (int i = 0; i < this.field.length; i++) {
			for (int j = 0; j < this.field[0].length; j++) {
				if (this.field[i][j].equals("^ ") || this.field[i][j].equals("< ") || this.field[i][j].equals("> ") || this.field[i][j].equals("v ")) y = j;
			}
		}
		return y;
	}
	
	/**
	 * This method checks the right of Ladybug and determines if there is a valid road.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @return	state	True if there is an available road on right side, false if there is none.
	 * */
	@SuppressWarnings("unused")
	private boolean checkRight() {
		int x = findBugX();
		int y = findBugY();
		boolean state = true;
		if (bug.drt == Ladybug.Direction.NORTH) {
			if (this.field[x][y + 1].equals(entity.strTree())) state = false;
		}
		else if (bug.drt == Ladybug.Direction.EAST) {
			if (this.field[x + 1][y].equals(entity.strTree())) state = false;
		}
		else if (bug.drt == Ladybug.Direction.SOUTH) {
			if (this.field[x][y - 1].equals(entity.strTree())) state = false;
		}
		else {
			if (this.field[x - 1][y].equals(entity.strTree())) state = false;
		}
		return state;
	}
	
	/**
	 * This method checks forward of Ladybug and determines if there is a valid road.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	object	Object that needs to be checked
	 * @return	state	True if there is an available road forward, false if there is none.
	 * */
	public boolean checkForward(String object) {
		int x = findBugX();
		int y = findBugY();
		boolean state = true;
		if (bug.getDirection() == Ladybug.Direction.NORTH) {
			if (x == 0 || this.field[x - 1][y].equals(object)) state = false; 
		}
		else if (bug.getDirection() == Ladybug.Direction.EAST) {
			if (y + 1 == this.field[0].length || this.field[x][y + 1].equals(object)) state = false;
		}
		else if (bug.getDirection() == Ladybug.Direction.SOUTH) {
			if (x + 1 == this.field.length || this.field[x + 1][y].equals(object)) state = false;
		}
		else if (bug.getDirection() == Ladybug.Direction.WEST) {
			if (y == 0 || this.field[x][y - 1].equals(object)) state = false;
		}
		return state;
	}
	
	private boolean onClover() {
		int x = findBugX();
		int y = findBugY();
		boolean state = false;
		for (int i = 0; i < this.clovX.length; i++) {
			if (this.clovX[i] == x && this.clovY[i] == y) {
				state = true;
				this.currClov = i;
			}
		}
		return state;
	}
	
	/**
	 * This method helps the Ladybug moves forward.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * */
	private void moveForward() {
		int x = findBugX();
		int y = findBugY();
		if (onClover()) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("Pick up Clover? Y/N");
			char yesno = sc.next().charAt(0);
			
			if (bug.getDirection() == Ladybug.Direction.NORTH) {
				if (checkForward(entity.strTree())) {
					if (onClover()) {
						if (yesno == 'Y') {
							this.field[x - 1][y] = bug.strLadybug();
							this.field[x][y] = "  "; 
							bug.clover[this.clovCount] = new Clover(5);
							clovCount += 1;
							this.clovX[this.currClov] = 0;
							this.clovY[this.currClov] = 0;
						}
						else if (yesno == 'N') {
							this.field[x - 1][y] = bug.strLadybug();
							this.field[x][y] = entity.strClover();
						}
						else System.out.println("Invalid move.");
					}
				}
				else System.out.println("Invalid move.");
			}
			else if (bug.getDirection() == Ladybug.Direction.EAST) {
				if (checkForward(entity.strTree())) {
					if (onClover()) {
						if (yesno == 'Y') {
							this.field[x][y + 1] = bug.strLadybug();
							this.field[x][y] = "  "; 
							bug.clover[this.clovCount] = new Clover(5);
							clovCount += 1;
							this.clovX[this.currClov] = 0;
							this.clovY[this.currClov] = 0;
						}
						else if (yesno == 'N') {
							this.field[x][y + 1] = bug.strLadybug();
							this.field[x][y] = entity.strClover();
						}
						else System.out.println("Invalid move.");
					}
				}
				else System.out.println("Invalid move.");
			}
			else if (bug.getDirection() == Ladybug.Direction.SOUTH) {
				if (checkForward(entity.strTree())) {
					if (onClover()) {
						if (yesno == 'Y') {
							this.field[x + 1][y] = bug.strLadybug();
							this.field[x][y] = "  "; 
							bug.clover[this.clovCount] = new Clover(5);
							clovCount += 1;
							this.clovX[this.currClov] = 0;
							this.clovY[this.currClov] = 0;
						}
						else if (yesno == 'N') {
							this.field[x + 1][y] = bug.strLadybug();
							this.field[x][y] = entity.strClover();
						}
						else System.out.println("Invalid move.");
					}
				}
				else System.out.println("Invalid move.");
			}
			else {
				if (checkForward(entity.strTree())) {
					if (onClover()) {
						if (yesno == 'Y') {
							this.field[x][y - 1] = bug.strLadybug();
							this.field[x][y] = "  "; 
							bug.clover[this.clovCount] = new Clover(5);
							clovCount += 1;
							this.clovX[this.currClov] = 0;
							this.clovY[this.currClov] = 0;
						}
						else if (yesno == 'N') {
							this.field[x][y - 1] = bug.strLadybug();
							this.field[x][y] = entity.strClover();
						}
						else System.out.println("Invalid move.");
					}
				}
				else System.out.println("Invalid move.");
			}
		}
		
		//Not on the same coordinate as clover
		else {
			if (bug.getDirection() == Ladybug.Direction.NORTH) {
				if (checkForward(entity.strTree())) {
					this.field[x - 1][y] = bug.strLadybug();
					this.field[x][y] = "  ";
				}
				else System.out.println("Invalid move.");
			}
			else if (bug.getDirection() == Ladybug.Direction.EAST) {
				if (checkForward(entity.strTree())) {
					this.field[x][y + 1] = bug.strLadybug();
					this.field[x][y] = "  ";
				}
				else System.out.println("Invalid move.");
			}
			else if (bug.getDirection() == Ladybug.Direction.SOUTH) {
				if (checkForward(entity.strTree())) {
					this.field[x + 1][y] = bug.strLadybug();
					this.field[x][y] = "  ";
				}
				else System.out.println("Invalid move.");
			}
			else {
				if (checkForward(entity.strTree())) {
					this.field[x][y - 1] = bug.strLadybug();
					this.field[x][y] = "  ";
				}
				else System.out.println("Invalid move.");
			}
		}
	}
	
	/**
	 * This method helps the Ladybug turn to the direction of input.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * */
	private void Turn() {
		cordReplace(findBugX(), findBugY(), bug.strLadybug());
	}
	
	/**
	 * This method reads the user input and control Ladybug according to it.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * */
	private void Control() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		char input = sc.next().charAt(0);	
		
		if(bug.getDirection() == Ladybug.Direction.NORTH) {
			if (input == 'W') moveForward();
			else if (input == 'A' || input == 'S' || input == 'D') {
				bug.setDirection(input);
				Turn();
			}
			else if (input == 'Q') {
				System.out.println("Terminating game....");
				System.exit(1);
			}
			else System.out.println("Invalid input.");
		}
		else if(bug.getDirection() == Ladybug.Direction.EAST) {
			if (input == 'D') moveForward();
			else if (input == 'A' || input == 'S' || input == 'W') {
				bug.setDirection(input);
				Turn();
			}
			else if (input == 'Q') {
				System.out.println("Terminating game....");
				System.exit(1);
			}
			else System.out.println("Invalid input.");
		}
		else if(bug.getDirection() == Ladybug.Direction.SOUTH) {
			if (input == 'S') moveForward();
			else if (input == 'A' || input == 'D' || input == 'W') {
				bug.setDirection(input);
				Turn();
			}
			else if (input == 'Q') {
				System.out.println("Terminating game....");
				System.exit(1);
			}
			else System.out.println("Invalid input.");
		}
		else {
			if (input == 'A') moveForward();
			else if (input == 'D' || input == 'S' || input == 'W') {
				bug.setDirection(input);
				Turn();
			}
			else if (input == 'Q') {
				System.out.println("Terminating game....");
				System.exit(1);
			}
			else System.out.println("Invalid input.");
		}
	}
	
	
	/**
	 * This method check the state of the playing field and determines if the game has finished.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * 
	 * @return	state	True if the game has finished, false if not.
	 * */
	private boolean gameFinished() {
		boolean state = true;
		for (int i = 0; i < this.field.length; i++) {
			for (int j = 0; j < this.field[0].length; j++) {
				if (this.field[i][j].equals("# ")) state = false;
			}
		}
		return state;
	}
	
	/**
	 * This method outputs the collected clovers and player score.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * */
	public void checkClover () {
		int clover = 0;
		for (int i = 0; i < bug.clover.length; i++) {
			if (bug.clover[i] == null) clover += 0;
			else clover++;
		}
		System.out.printf("Number of obtained clover: %d \n", clover);
		System.out.printf("Score: %d \n", bug.getClover());
	}
	
	
	/**
	 * This method generates the playing field to the console.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * */
	private void generateField() {
		bug.drt = Ladybug.Direction.SOUTH;
		Border();
		cordReplace(1, 1, "* ");
		cordReplace(2, 1, "* ");
		cordReplace(3, 1, "* ");
		cordReplace(4, 1, "* ");
		cordReplace(5, 1, "* ");
		cordReplace(6, 1, "* ");
		cordReplace(7, 1, "* ");
		cordReplace(8, 1, "* ");
		cordReplace(8, 2, "* ");
		cordReplace(8, 3, "* ");
		cordReplace(7, 3, "* ");
		cordReplace(6, 3, "* ");
		cordReplace(6, 4, "* ");
		cordReplace(6, 5, "* ");
		cordReplace(6, 6, "* ");
		cordReplace(5, 6, "* ");
		cordReplace(4, 6, "* ");
		cordReplace(3, 6, "* ");
		cordReplace(3, 7, "* ");
		cordReplace(3, 8, "* ");
		cordReplace(3, 9, "* ");
		cordReplace(3, 10, "* ");
		cordReplace(3, 11, "* ");
		cordReplace(3, 12, "* ");
		cordReplace(3, 13, "* ");
		cordReplace(4, 13, "* ");
		cordReplace(5, 13, "* ");
		cordReplace(6, 13, "* ");
		cordReplace(7, 13, "* ");
		cordReplace(8, 13, "* ");
		cordReplace(8, 10, "* ");
		Random random = new Random();
		/*
		for (int i = 1; i < field.length - 1; i++) {
			for (int j = 1; j < field[0].length - 2; j++) {
				int rand = random.nextInt(4);
				if (field[i][j] != "* ") {
					if (rand == 0) field[i][j] = "  ";
					else field[i][j] = tree.strTree();
				}
			}
		}
		*/
		for (int i = 1; i < this.field.length - 1; i++) {
			for (int j = 1; j < this.field[0].length - 2; j++) {
				if (!this.field[i][j].equals("* ")) this.field[i][j] = entity.strTree();
			}
		}
		cordReplace(8, 4, "  ");
		cordReplace(1, 2, "  ");
		cordReplace(1, 3, "  ");
		cordReplace(2, 3, "  ");
		cordReplace(3, 3, "  ");
		cordReplace(5, 3, "  ");
		cordReplace(7, 12, "* ");
		cordReplace(7, 11, "* ");
		cordReplace(7, 10, "* ");
		cordReplace(7, 9, "* ");
		for (int i = 1; i < this.field.length - 1; i++) {
			for (int j = 1; j < this.field[0].length - 2; j++) {
				if (this.field[i][j] == "* ") this.field[i][j] = "  ";
			}
		}
		int k = 0;
		for (int i = 1; i < this.field.length - 1; i++) {
			for (int j = 1; j < this.field[0].length - 2; j++) {
				int rand = random.nextInt(3);
				if (this.field[i][j].equals("  ") && k < 10 && rand == 0) {
					this.field[i][j] = entity.strClover();
					k++;
				}
			}
		}
		int x = 0;
		int y = 0;
		for (int i = 1; i < this.field.length - 1; i++) {
			for (int j = 1; j < this.field[0].length - 2; j++) {
				if (this.field[i][j].equals(entity.strClover())) {
					clovX[x] = i;
					clovY[y] = j;
					x++;
					y++;
				}
			}
		}	
		cordReplace(9, 13, "# ");
	}
	
	/**
	 * This method prints out instruction and check the state of the game on each step.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * */
	public void play() {
		generateField();
		System.out.println("Use W, A, S, D to move the Ladybug, game is finished when the Ladybug reaches the finish line (#)");
		printField(field);
		while (true) {
			System.out.printf("\n \n");
			System.out.print("Control input: ");
			Control();
			System.out.print("Able to move forward: ");
			System.out.println(checkForward(entity.strTree()));
			checkClover();
			printField(this.field);
			if (gameFinished()) {
				System.out.println("Victory!");
				checkClover();
				System.exit(1);
			}
		}
	}
}