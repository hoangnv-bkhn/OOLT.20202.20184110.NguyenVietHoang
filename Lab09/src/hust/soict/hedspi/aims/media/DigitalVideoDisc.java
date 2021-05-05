package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

	public DigitalVideoDisc() {}
	
	public DigitalVideoDisc(String title, int id) {
		super(title, id);
	}
	
	public DigitalVideoDisc(String title, String category, int id) {
		super(title, category, id);
	}

	public DigitalVideoDisc(String title, String category, String director, int id) {
		super(title, category,director, id);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost, int id) {
		super(title, category, director, length,cost, id);
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
	
	public void play() {
		System.out.println("Playing DVD: "+ this.getTitle());
		System.out.println("DVD length: "+ this.getLength());
	}
	
	public String playGUI() {
		String s = "";
		s += "Playing DVD: "+ this.getTitle()+"\n";
		s += "DVD length: "+ this.getLength()+"\n";
		return s;
	}
	
	@Override
	public int compareTo(Media obj) {
		DigitalVideoDisc DVD = (DigitalVideoDisc) obj;
		if (DVD instanceof DigitalVideoDisc) {
			if (this.getCost() < DVD.getCost()) {
				return -1;
			}else if (this.getCost() > DVD.getCost()) {
				return 1;
			}else {
				if (this.getLength() < DVD.getLength()) {
					return -1;
				}else if (this.getLength() > DVD.getLength()) {
					return 1;
				}else {
					return super.compareTo(obj);
				}
			}
		}else {
			new Exception("Error");
			return 1000;
		}
	}

}
