package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media{

	private String director;
	private int length;
	
	public DigitalVideoDisc() {}
	
	public DigitalVideoDisc(String title, int id) {
		super(title, id);
	}
	
	public DigitalVideoDisc(String title, String category, int id) {
		super(title, category, id);
	}

	public DigitalVideoDisc(String title, String category, String director, int id) {
		super(title, category, id);
		this.director = director;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost, int id) {
		super(title, category, id);
		this.director = director;
		this.length = length;
		this.cost = cost;
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

	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	
}
