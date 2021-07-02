package de.uni_hannover.hci.hoang_tran.task2.movie;

public class DigitalMovie extends Movie {

	public DigitalMovie(String title, String identifier) {
		super(title, identifier);
		super.price = 12.99;
		super.title += " Digital Edition";
	}

}
