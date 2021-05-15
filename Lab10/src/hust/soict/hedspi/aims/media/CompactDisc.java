package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

import javax.naming.directory.InvalidAttributesException;

import hust.soict.hedspi.aims.PlayerException;

public class CompactDisc extends Disc implements Playable {

	private String artist;

	private ArrayList<Track> tracks = new ArrayList<>();

	public CompactDisc() {
		super();
	}

	public CompactDisc(int id, String title, String category, float cost, String artist)
			throws InvalidAttributesException {
		super(title, category, id);
		if (cost >= 0) {
			this.cost = cost;
		} else {
			throw new InvalidAttributesException("Cost must be positive!!!");
		}
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	public void addTrack(Track track) throws Exception {
		if (tracks.contains(track)) {
			System.out.println("Error!!! Track " + track.getTitle() + " already exists.");
			throw new Exception("Error!!! Track " + track.getTitle() + " already exists.");
		} else {
			tracks.add(track);
			System.out.println("Success! " + track.getTitle() + " is added to the CD.");
		}
	}

	public void removeTrack(Track track) throws Exception {
		if (!tracks.contains(track)) {
			System.out.println("Error!!! The CD doesn't contain track " + track.getTitle());
			throw new Exception("Error!!! The CD doesn't contain track " + track.getTitle());
		} else {
			tracks.remove(track);
			System.out.println("Success! \"+track.getTitle()+\" is removed from the CD.");
		}
	}

	public int getLength() {
		int sum = 0;
		if (tracks.size() <= 0) {
			System.out.println("Error!!! The CD has no tracks.");
		} else {
			for (Track track : tracks) {
				sum += track.getLength();
			}
		}
		return sum;
	}

	public int getNumberOfTrack() {
		return tracks.size();
	}

	public void play() throws PlayerException{
		if (this.getLength() <= 0) {
			System.err.println("Length must be greater than 0!!!");
			throw new PlayerException("ERR: CD length is non-positive!");
		} else {
			System.out.println("This CD has " + tracks.size() + " disk");
			System.out.println("The length of this CD is: " + getLength());
			for (Track track : tracks) {
				try {
					track.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
		}
	}

	public String playGUI() throws PlayerException {
		String s = "";
		if (this.getLength() <= 0) {
			System.err.println("Length must be greater than 0!!!");
			throw new PlayerException("ERR: CD length is non-positive!");
		} else {
			s += "This CD has " + tracks.size() + " disk" + "\n";
			s += "The length of this CD is: " + getLength() + "\n";
			for (Track track : tracks) {
				try {
					s += track.playGUI();
				} catch (PlayerException e) {
					throw e;
				}
			}
		}
		return s;
	}

	@Override
	public int compareTo(Object obj) {
		CompactDisc CD = (CompactDisc) obj;
		if (CD instanceof CompactDisc) {
			if (this.getNumberOfTrack() > CD.getNumberOfTrack()) {
				return 1;
			} else if (this.getNumberOfTrack() < CD.getNumberOfTrack()) {
				return -1;
			} else {
				if (this.getLength() > CD.getLength()) {
					return 1;
				} else if (this.getLength() < CD.getLength()) {
					return -1;
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
