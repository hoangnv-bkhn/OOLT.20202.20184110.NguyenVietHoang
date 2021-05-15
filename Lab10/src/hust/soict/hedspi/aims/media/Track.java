package hust.soict.hedspi.aims.media;

import javax.naming.directory.InvalidAttributesException;

import hust.soict.hedspi.aims.PlayerException;

public class Track implements Playable, Comparable<Object> {

	@Override
	public boolean equals(Object obj) {
		Track track = (Track) obj;
		if (track instanceof Track) {
			if (track.getTitle().equals(this.getTitle()) && track.getLength() == this.getLength()) {
				return true;
			}
		}
		return false;
	}

	private String title;
	private int length;

	public Track() {
	}

	public Track(String title, int length) throws InvalidAttributesException {
		this.title = title;
		if (length > 0) {
			this.length = length;
		} else {
			throw new InvalidAttributesException("Length must be greater than 0!!!");
		}
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public void play() throws PlayerException { // In command line program
		if (this.getLength() <= 0) {
			System.err.println("Length must be greater than 0!!!");
			throw new PlayerException("ERR: DVD length is non-positive!");
		} else {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}
	}

	public String playGUI() throws PlayerException { // In GUI program
		String s = "";
		if (this.getLength() <= 0) {
			System.err.println("Length must be greater than 0!!!");
			throw new PlayerException("ERR: DVD length is non-positive!");
		} else {
			s += "Playing DVD: " + this.getTitle() + "\n";
			s += "DVD length: " + this.getLength() + "\n";
			return s;
		}
	}

	@Override
	public int compareTo(Object o) {
		Track track = (Track) o;
		if (track instanceof Track) {
			if (track.length > this.length) {
				return -1;
			} else if (track.length < this.length) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 1000;
		}
	}

}
