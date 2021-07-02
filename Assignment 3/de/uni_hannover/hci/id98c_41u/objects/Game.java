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
	public Ladybug bug = new Ladybug();
	public Clover clov = new Clover(5);
	public Tree tree = new Tree();
	
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
	}
	
	/**
	 * This method returns the playing field in the format of a 2-d String Array.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @return	field	Playing field.
	 * */
	public String[][] Field() {
		String[][] field = new String[row][col + 1];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col + 1; j++) {
				if (j < col) field[i][j] = "  ";
				else field[i][j] ="\n";
			}
		}
		return field;
	}
	
	/**
	 * This method print out the created playing field Array as a String.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	field	Playing field.
	 * */
	public void printField(String[][] field) {
		for (String[] row: field) {
			System.out.print(Arrays.toString(row).replace(", ", "").replace("[", "").replace("]", ""));
		}
	}
	
	/**
	 * This method searchs for a String in coordinate in the field and replace it with another String.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	field	Playing field.
	 * @param	x	Coordinate on x-Axis.
	 * @param	y	Coordinate on y-Axis.
	 * @param	str		Replacement string.
	 * @return	field	Playing field after replacing.
	 * */
	public String[][] cordReplace(String[][] field, int x, int y, String str) {
		int row = field.length;
		int col = field[0].length;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == x && j == y) field[i][j] = str;
			}
		}
		return field;
	}
	
	/**
	 * This method surrounds the edges of the field with Tree objects.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	field	Playing field.
	 * @return	field	Playing field with border.
	 * */
	public String[][] Border(String[][] field) {
		int row = field.length;
		int col = field[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col - 1; j++) {
				if (i == 0 || i == row - 1) field[i][j] = tree.strTree();
				else if (j == 0 || j == col - 2) field[i][j] = tree.strTree();
			}
		}
		cordReplace(field, 0, 1, bug.strLadybug());
		cordReplace(field, row - 1, col - 3, clov.strClover());
		return field;
	}
	
	
	/**
	 * This method finds the int value of x-Axis coordinate of Ladybug.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	field	Playing field.
	 * @return	x	Ladybug coordinate on x-Axis.
	 * */
	public int findBugX(String[][] field) {
		int x = 0;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				if (field[i][j].equals("^ ") || field[i][j].equals("< ") || field[i][j].equals("> ") || field[i][j].equals("v ")) x = i;
			}
		}
		return x;
	}
	
	/**
	 * This method finds the int value of y-Axis coordinate of Ladybug.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	field	Playing field.
	 * @return	y	Ladybug coordinate on y-Axis.
	 * */
	public int findBugY(String[][] field) {
		int y = 0;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				if (field[i][j].equals("^ ") || field[i][j].equals("< ") || field[i][j].equals("> ") || field[i][j].equals("v ")) y = j;
			}
		}
		return y;
	}
	
	/**
	 * This method checks the right of Ladybug and determines if there is a valid road.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	field	Playing field.
	 * @return	state	True if there is an available road on right side, false if there is none.
	 * */
	public boolean checkRight(String[][] field) {
		int x = findBugX(field);
		int y = findBugY(field);
		boolean state = true;
		if (bug.drt == Ladybug.Direction.NORTH) {
			if (field[x][y + 1].equals(tree.strTree())) state = false;
		}
		else if (bug.drt == Ladybug.Direction.EAST) {
			if (field[x + 1][y].equals(tree.strTree())) state = false;
		}
		else if (bug.drt == Ladybug.Direction.SOUTH) {
			if (field[x][y - 1].equals(tree.strTree())) state = false;
		}
		else {
			if (field[x - 1][y].equals(tree.strTree())) state = false;
		}
		return state;
	}
	
	/**
	 * This method checks forward of Ladybug and determines if there is a valid road.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	field	Playing field.
	 * @return	state	True if there is an available road forward, false if there is none.
	 * */
	public boolean checkForward(String[][] field) {
		int x = findBugX(field);
		int y = findBugY(field);
		boolean state = true;
		if (bug.getDirection() == Ladybug.Direction.NORTH) {
			if (x == 0 || field[x - 1][y].equals(tree.strTree())) state = false; 
		}
		else if (bug.getDirection() == Ladybug.Direction.EAST) {
			if (y + 1 == field[0].length || field[x][y + 1].equals(tree.strTree())) state = false;
		}
		else if (bug.getDirection() == Ladybug.Direction.SOUTH) {
			if (x + 1 == field.length || field[x + 1][y].equals(tree.strTree())) state = false;
		}
		else if (bug.getDirection() == Ladybug.Direction.WEST) {
			if (y == 0 || field[x][y - 1].equals(tree.strTree())) state = false;
		}
		return state;
	}
	
	/**
	 * This method helps the Ladybug moves forward.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	field	Playing field.
	 * @return	field	Playing field after object has moved.
	 * */
	public String[][] moveForward(String[][] field) {
		int x = findBugX(field);
		int y = findBugY(field);
		
		if (bug.getDirection() == Ladybug.Direction.NORTH) {
			if (checkForward(field)) {
				field[x - 1][y] = bug.strLadybug();
				field[x][y] = "  ";
			}
			else System.out.println("Invalid move.");
		}
		else if (bug.getDirection() == Ladybug.Direction.EAST) {
			if (checkForward(field)) {
				field[x][y + 1] = bug.strLadybug();
				field[x][y] = "  ";
			}
			else System.out.println("Invalid move.");
		}
		else if (bug.getDirection() == Ladybug.Direction.SOUTH) {
			if (checkForward(field)) {
				field[x + 1][y] = bug.strLadybug();
				field[x][y] = "  ";
			}
			else System.out.println("Invalid move.");
		}
		else {
			if (checkForward(field)) {
				field[x][y - 1] = bug.strLadybug();
				field[x][y] = "  ";
			}
			else System.out.println("Invalid move.");
		}
		return field;
	}
	
	/**
	 * This method helps the Ladybug turn to the direction of input.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	field	Playing field.
	 * @return	field	Playing field after object has turned.
	 * */
	public String[][] Turn(String[][] field) {
		cordReplace(field, findBugX(field), findBugY(field), bug.strLadybug());
		return field;
	}
	
	/**
	 * This method reads the user input and control Ladybug according to it.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	field	Playing field.
	 * @return	field	Playing field after control.
	 * */
	public String[][] Control(String[][] field) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		char input = sc.next().charAt(0);
		
		if(bug.getDirection() == Ladybug.Direction.NORTH) {
			if (input == 'W') moveForward(field);
			else if (input == 'A' || input == 'S' || input == 'D') {
				bug.setDirection(input);
				Turn(field);
			}
			else System.out.println("Invalid input.");
		}
		else if(bug.getDirection() == Ladybug.Direction.EAST) {
			if (input == 'D') moveForward(field);
			else if (input == 'A' || input == 'S' || input == 'W') {
				bug.setDirection(input);
				Turn(field);
			}
			else System.out.println("Invalid input.");
		}
		else if(bug.getDirection() == Ladybug.Direction.SOUTH) {
			if (input == 'S') moveForward(field);
			else if (input == 'A' || input == 'D' || input == 'W') {
				bug.setDirection(input);
				Turn(field);
			}
			else System.out.println("Invalid input.");
		}
		else {
			if (input == 'A') moveForward(field);
			else if (input == 'D' || input == 'S' || input == 'W') {
				bug.setDirection(input);
				Turn(field);
			}
			else System.out.println("Invalid input.");
		}
		return field;
	}
	
	
	/**
	 * This method check the state of the playing field and determines if the game has finished.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @param	field	Playing field.
	 * @return	state	True if the game has finished, false if not.
	 * */
	public boolean gameFinished(String[][] field) {
		boolean state = true;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				if (field[i][j].equals("# ")) state = false;
			}
		}
		return state;
	}
	
	
	/**
	 * This method generates the playing field to the console.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * @return	field	Generated playing field.
	 * */
	public String[][] generateField() {
		String[][] field = Field();
		bug.drt = Ladybug.Direction.SOUTH;
		Border(field);
		cordReplace(field, 1, 1, "* ");
		cordReplace(field, 2, 1, "* ");
		cordReplace(field, 3, 1, "* ");
		cordReplace(field, 4, 1, "* ");
		cordReplace(field, 5, 1, "* ");
		cordReplace(field, 6, 1, "* ");
		cordReplace(field, 7, 1, "* ");
		cordReplace(field, 8, 1, "* ");
		cordReplace(field, 8, 2, "* ");
		cordReplace(field, 8, 3, "* ");
		cordReplace(field, 7, 3, "* ");
		cordReplace(field, 6, 3, "* ");
		cordReplace(field, 6, 4, "* ");
		cordReplace(field, 6, 5, "* ");
		cordReplace(field, 6, 6, "* ");
		cordReplace(field, 5, 6, "* ");
		cordReplace(field, 4, 6, "* ");
		cordReplace(field, 3, 6, "* ");
		cordReplace(field, 3, 7, "* ");
		cordReplace(field, 3, 8, "* ");
		cordReplace(field, 3, 9, "* ");
		cordReplace(field, 3, 10, "* ");
		cordReplace(field, 3, 11, "* ");
		cordReplace(field, 3, 12, "* ");
		cordReplace(field, 3, 13, "* ");
		cordReplace(field, 4, 13, "* ");
		cordReplace(field, 5, 13, "* ");
		cordReplace(field, 6, 13, "* ");
		cordReplace(field, 7, 13, "* ");
		cordReplace(field, 8, 13, "* ");
		cordReplace(field, 8, 10, "* ");
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
		for (int i = 1; i < field.length - 1; i++) {
			for (int j = 1; j < field[0].length - 2; j++) {
				if (!field[i][j].equals("* ")) field[i][j] = tree.strTree();
			}
		}
		cordReplace(field, 8, 4, "  ");
		cordReplace(field, 1, 2, "  ");
		cordReplace(field, 1, 3, "  ");
		cordReplace(field, 2, 3, "  ");
		cordReplace(field, 3, 3, "  ");
		cordReplace(field, 5, 3, "  ");
		cordReplace(field, 7, 12, "* ");
		cordReplace(field, 7, 11, "* ");
		cordReplace(field, 7, 10, "* ");
		cordReplace(field, 7, 9, "* ");
		for (int i = 1; i < field.length - 1; i++) {
			for (int j = 1; j < field[0].length - 2; j++) {
				if (field[i][j] == "* ") field[i][j] = "  ";
			}
		}
		int k = 0;
		for (int i = 1; i < field.length - 1; i++) {
			for (int j = 1; j < field[0].length - 2; j++) {
				int rand = random.nextInt(3);
				if (field[i][j].equals("  ") && k < 10 && rand == 0) {
					field[i][j] = clov.strClover();
					k++;
				}
			}
		}
		cordReplace(field, 9, 13, "# ");
		return field;
	}
	
	/**
	 * This method prints out instruction and check the state of the game on each step.
	 * 
	 * @author	Hoang Phuong Tran <tranphuongck@gmail.com>
	 * */
	public void play() {
		String[][] field = generateField();
		System.out.println("Use W, A, S, D to move the Ladybug, game is finished when the Ladybug reaches the finish line (#)");
		printField(field);
		while (true) {
			System.out.printf("\n \n");
			System.out.print("Control input: ");
			Control(field);
			System.out.printf("Coordinate: %d %d \n", findBugX(field), findBugY(field));
			System.out.print("Able to move forward: ");
			System.out.println(checkForward(field));
			printField(field);
			if (gameFinished(field)) {
				System.out.println("Victory!");
				System.exit(1);
			}
		}
	}
}