package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.PlayerException;

public interface Playable {

	public void play() throws PlayerException;
	public String playGUI() throws PlayerException;
}
