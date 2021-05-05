package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	
	private ArrayList<Track> tracks = new ArrayList<>();

	public CompactDisc() {
		super();
	}
	
	public CompactDisc(int id, String title, String category, float cost, String artist) {
		super(title, category, id);
		this.cost = cost;
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("Error!!! Track "+ track.getTitle() +" already exists.");
		}else {
			tracks.add(track);
			System.out.println("Success! "+track.getTitle()+" is added to the CD.");
		}
	}
	
	public void removeTrack(Track track) {
		if (!tracks.contains(track)) {
			System.out.println("Error!!! The CD doesn't contain track "+track.getTitle());
		}else {
			tracks.remove(track);
			System.out.println("Success! \"+track.getTitle()+\" is removed from the CD.");
		}
	}
	
	public int getLength() {
		int sum = 0;
		if (tracks.size() <= 0) {
			System.out.println("Error!!! The CD has no tracks.");
		}else {
			for (Track track : tracks) {
				sum += track.getLength();
			}
		}
		return sum;
	}
	
	public int getNumberOfTrack() {
		return tracks.size();
	}
	
	public void play() {
		System.out.println("This CD has "+tracks.size()+" disk");
		System.out.println("The length of this CD is: "+getLength());
		for (Track track : tracks) {
			track.play();
		}
	}
	
	public String playGUI() {
		String s = "";
		s += "This CD has "+tracks.size()+" disk"+"\n";
		s += "The length of this CD is: "+getLength()+"\n";
		for (Track track : tracks) {
			s += track.playGUI();
		}
		return s;
	}
	
	@Override
	public int compareTo(Media obj) {
		CompactDisc CD = (CompactDisc) obj;
		if (CD instanceof CompactDisc) {
			if (this.getNumberOfTrack() > CD.getNumberOfTrack()) {
				return 1;
			}else if (this.getNumberOfTrack() < CD.getNumberOfTrack()) {
				return -1;
			}else {
				if (this.getLength() > CD.getLength()) {
					return 1;
				}else if (this.getLength() < CD.getLength()) {
					return -1;
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
