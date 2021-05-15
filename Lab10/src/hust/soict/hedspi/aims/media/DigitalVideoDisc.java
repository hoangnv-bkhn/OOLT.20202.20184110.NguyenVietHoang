package hust.soict.hedspi.aims.media;

import javax.naming.directory.InvalidAttributesException;

import hust.soict.hedspi.aims.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

	public DigitalVideoDisc() {
	}

	public DigitalVideoDisc(String title, int id) {
		super(title, id);
	}

	public DigitalVideoDisc(String title, String category, int id) {
		super(title, category, id);
	}

	public DigitalVideoDisc(String title, String category, String director, int id) {
		super(title, category, director, id);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost, int id)
			throws InvalidAttributesException {
		super(title, category, director, length, cost, id);
	}

	public boolean search(String title) {
		String[] token = title.toLowerCase().split("\\s");
		String discTitle = getTitle();
		int check = 0;
		String[] tokenSearch = discTitle.toLowerCase().split("\\s");
		for (String string : token) {
			for (String string2 : tokenSearch) {
				if (string.equals(string2) == true) {
					check++;
					if (check == token.length) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void play() throws PlayerException { // In command line program
		if (this.getLength() <= 0)
			try {
				{
					System.err.println("Length must be greater than 0!!!");
					throw new PlayerException("ERR: DVD length is non-positive!");
				}
			} catch (PlayerException e) {
				e.printStackTrace();
			}
		else {
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
	public int compareTo(Object obj) {
		DigitalVideoDisc DVD = (DigitalVideoDisc) obj;
		if (DVD instanceof DigitalVideoDisc) {
			if (this.getCost() < DVD.getCost()) {
				return -1;
			} else if (this.getCost() > DVD.getCost()) {
				return 1;
			} else {
				if (this.getLength() < DVD.getLength()) {
					return -1;
				} else if (this.getLength() > DVD.getLength()) {
					return 1;
				} else {
					return super.compareTo(obj);
				}
			}
		} else {
			new Exception("Error");
			return 1000;
		}
	}

}
