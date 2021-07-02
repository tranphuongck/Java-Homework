package de.uni_hannover.hci.hoang_tran.task2.music;

public class DigitalAlbum extends MusicAlbum {

	public DigitalAlbum(String title, String identifier, String artist) {
		super(title, identifier, artist);
		super.price = 12.99;
		super.title += " Digital Edition";
	}

}
