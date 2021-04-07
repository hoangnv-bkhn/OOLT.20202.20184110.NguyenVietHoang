package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

	private List<String> authors = new ArrayList<>();
	
	public Book() {};
	public Book(int id, String title) {
		super(title, id);
	}
	
	public Book(String title, String category, int id) {
		super(title, category, id);
	}
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public Book(String title,float cost, String category, List<String> authors, int id) {
		super(id, title, category,cost);
		if (authors.size() != 0) {
			this.authors = authors;
		}else {
			System.out.println("Authors list is empty!");
		}
	}

	public int addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("Add author failed!!!");
			return 0;
		}else {
			authors.add(authorName);
			System.out.println("Successfully added author!");
			return 1;
		}
	}
	public int removeAuthor(String authorName) {
		if (authors.size() == 0) {
			System.out.println("Remove author failed!!!");
			return 0;
		}else if (!authors.contains(authorName)) {
			System.out.println("Remove author failed!!!");
			return 0;
		}else {
			authors.remove(authorName);
			return 1;
		}
	}
}
