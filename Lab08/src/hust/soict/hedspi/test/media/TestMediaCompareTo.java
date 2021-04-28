package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;

public class TestMediaCompareTo {

	public static void main(String[] args) {
	// test compareTo for DVD, CD, Book (they extent title from Media)
		System.out.println("TEST FOR DVD, CD, BOOK");
		List<Media> collection = new ArrayList<>();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Star Wars", 1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion King", 2);
		Book book1 = new Book(3, "Aladdin");
		CompactDisc cd1 = new CompactDisc(4, "Puss in Boots", "Fairy Tale", 10, "Folk");
		CompactDisc cd2 = new CompactDisc(4, "Rumpelstiltskin", "Fairy Tale", 10, "Folk");

		
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(book1);
		collection.add(cd1);
		collection.add(cd2);
		
		Iterator<Media> iterator = collection.iterator();
		
		System.out.println("\tBefore sort:");
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
		System.out.println(10);
		Collections.sort(collection);
		
		iterator = collection.iterator();
		
		System.out.println("--------------------------");
		System.out.println("\tAfter sort:");
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
		
	// test sort Track
		System.out.println("***************************");
		System.out.println("TEST FOR TRACK");
		List<Track> collection2 = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			Track track = new Track("Track no."+i, 10*(int)Math.floor(Math.random()*(10-1+1)+1));
			collection2.add(track);
		}
		
		Iterator<Track> iterator1 = collection2.iterator();
		
		System.out.println("\tBefore sort:");
		
		while (iterator1.hasNext()) {
			Track a = iterator1.next();
			System.out.println(a.getTitle() +" - Length:"+ a.getLength());
		}
		
		Collections.sort((List<Track>)collection2);
		
		iterator1 = collection2.iterator();
		
		System.out.println("--------------------------");
		System.out.println("\tAfter sort:");
		while (iterator1.hasNext()) {
			Track a = iterator1.next();
			System.out.println(a.getTitle() +" - Length:"+ a.getLength());
		}
	}

}
