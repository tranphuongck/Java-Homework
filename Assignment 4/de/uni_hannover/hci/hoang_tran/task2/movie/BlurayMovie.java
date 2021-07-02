package de.uni_hannover.hci.hoang_tran.task2.movie;

public class BlurayMovie extends Movie {

	public BlurayMovie(String title, String identifier) {
		super(title, identifier);
		super.price = 16.99;
		super.title += " BD Edition";
	}
	
}
