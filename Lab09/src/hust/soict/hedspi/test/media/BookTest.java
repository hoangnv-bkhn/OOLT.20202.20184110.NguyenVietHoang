package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		Book book = new Book(1, "Hello", "fairy tale", 20f);
		book.setContent("The plan would direct an additional $62 billion to improving"
				+ " graduation rates at colleges that serve low-income students, and $39"
				+ " billion for two tuition-free years for low- and middle-income students"
				+ " at historically Black, tribal and other minority-serving colleges.");
		
		System.out.println(book.toString());
	}
}