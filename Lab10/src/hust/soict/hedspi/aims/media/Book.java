package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.naming.directory.InvalidAttributesException;

public class Book extends Media{

	private List<String> authors = new ArrayList<>();
	
	private String content;
	public List<String> contentTokens = new ArrayList<>();
	public Map<String, Integer> wordFrequency = new TreeMap<>();
	
	public Book() {};
	public Book(int id, String title) {
		super(title, id);
	}
	
	public Book(String title, String category, int id) {
		super(title, category, id);
	}
	public Book(int id, String title, String category, float cost) throws InvalidAttributesException {
		super(id, title, category, cost);
	}
	
	public Book(String title,float cost, String category, List<String> authors, int id) throws Exception {
		super(id, title, category,cost);
		if (authors.size() != 0) {
			this.authors = authors;
		}else {
			System.out.println("Authors list is empty!");
			throw new Exception("Authors list is empty!");
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
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void processContent() {
		this.contentTokens.addAll(Arrays.asList(this.content.split("[\\p{Punct}\\s]+")));
		Collections.sort(contentTokens);
		
		Iterator<String> iterator = contentTokens.iterator();
		while (iterator.hasNext()) {
			String string = iterator.next();
			if (wordFrequency.containsKey(string) == false) {
				wordFrequency.put(string, 1);
			}else {
				int count = wordFrequency.get(string);
				count++;
				wordFrequency.put(string, count);
			}
		}
	}
	
	@Override
	public String toString() {
		
		String string = "";
		string += "ID: "+this.id+"\n";
		string += "TITLE: "+this.title+"\n";
		string += "AUTHORS: ";
		for (String author : this.authors) {
			string += author + ", ";
		}
		string += "\n";
		string += "COST: "+this.cost+"$\n";
		string += "NUMBER OF TOKENS: " + contentTokens.size() + "\n";
		for (Map.Entry<String, Integer> c : this.wordFrequency.entrySet()) {
			string += c.getKey() + " : "+ c.getValue() + "\n";
		}
		
		return string;
	}
}
