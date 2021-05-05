package hust.soict.hedspi.aims.media;

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
		// TODO Auto-generated constructor stub
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	public String playGUI() {
		String s = "";
		s += "Playing DVD: " + this.getTitle()+"\n";
		s += "DVD length: " + this.getLength()+"\n";
		return s;
	}

	@Override
	public int compareTo(Object o) {
		Track track = (Track) o;
		if (track instanceof Track) {
			if (track.length > this.length) {
				return -1;
			}else if (track.length < this.length) {
				return 1;
			}else {
				return 0;
			}
		}else {
			return 1000;
		}
	}

}
