package de.uni_hannover.hci.hoang_tran.task2.movie;

import de.uni_hannover.hci.hoang_tran.task2.Item;

public class Movie extends Item {
	public String imdb;

	public Movie(String title, String identifier) {
		super(title, identifier);
		this.imdb = identifier;
	}

}
