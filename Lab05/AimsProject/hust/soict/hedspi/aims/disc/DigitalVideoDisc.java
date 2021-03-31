package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {

	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	
	public DigitalVideoDisc(String title, String category) {
		super();
		this.title = title;
		this.category = category;
	}

	public DigitalVideoDisc(String title, String category, String director) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
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

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
}
