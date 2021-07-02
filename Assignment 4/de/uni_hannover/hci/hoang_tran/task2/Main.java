package de.uni_hannover.hci.hoang_tran.task2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.print("Enter command: ");
		Scanner sc = new Scanner(System.in).useDelimiter("\\s");
		String str1 = sc.next();
		String str2 = sc.next();
		String[] validItem = new String[] {"CDAlbum", "DigitalAlbum", "BlurayMovie", "DVDMovie", "DigitalMovie"};
		int itemIndex = 0;
		Item[] list = new Item[0];
		
		if (!str1.equals("add")) {
			System.err.println("Invalid input format.");
			System.exit(2);
		}
		int err = 0;
		for (int i = 0; i < validItem.length; i++) {
			if (str2.equals(validItem[i])) itemIndex = i;
			else err += 1;
		}
		if (err == validItem.length) {
			System.err.println("Invalid input format.");
			System.exit(2);
		}
		int input = 0;
		while (true) {
			
		}
	}

}
