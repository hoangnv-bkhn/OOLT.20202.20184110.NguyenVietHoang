package hust.soict.hedspi.aims.media;

import javax.naming.directory.InvalidAttributesException;

public class Disc extends Media {
	
	private int length;
	private String director;

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public Disc() {}
	
	public Disc(String title, int id) {
		super(title, id);
	}
	
	public Disc(String title, String category, int id) {
		super(title, category, id);
	}
	
	public Disc(String title, String category, String director, int id) {
		super(category, title, id);
		this.director = director;
	}
	
	public Disc(String title, String category, String director, int length, float cost, int id) throws InvalidAttributesException {
		super(id, title, category, cost);
		this.director = director;
		this.length = length;
	}

}
