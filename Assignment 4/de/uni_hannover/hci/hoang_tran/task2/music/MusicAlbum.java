package de.uni_hannover.hci.hoang_tran.task2.music;
import de.uni_hannover.hci.hoang_tran.task2.Item;

public class MusicAlbum extends Item {
	public String artist;
	public String mbid;

	public MusicAlbum(String title, String identifier, String artist) {
		super(title, identifier);
		this.mbid = super.identifier;
		this.artist = artist;
	}
	
}
