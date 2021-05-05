package hust.soict.hedspi.aims;

import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;

public class Aims {

	public static void main(String[] args) throws Exception{
		int choice;
		Scanner scanner = new Scanner(System.in);
		Order anOrder = null;
		do {
			showMenu();
			choice = scanner.nextInt();
			switch (choice) {
			case 0:
				scanner.close();
				System.out.println("The program ends!");
				break;
			case 1:
				anOrder = new Order();
				System.out.println("Created an Order!");
				break;
			case 2:
				if (anOrder == null) {
					System.out.println("Order has not been created");
					break;
				}
				
				System.out.println("Please choose type of item");
				System.out.println("1. Book");
				System.out.println("2. Digital Video Disc");
				System.out.println("3. CompactDisc");
				System.out.println("0. Cancel");
				System.out.println("--------------------------------");
				System.out.println("Please choose a number: 0-1-2-3");
				int type = scanner.nextInt();
				
				switch (type) {
				case 0:
					System.out.println("Exit select type to add.");
					break;
				case 1:
					addBook(anOrder, scanner);
					break;
				case 2:
					addDisc(anOrder, scanner);
					break;
				case 3:
					addCompactDisc(anOrder, scanner);
					break;
				default:
					System.out.println("Exit select type to add.");
					break;
				}
				break;
			case 3:
				if (anOrder == null) {
					System.out.println("Order has not been created");
					break;
				}
				System.out.println("Enter ID to remove: ");
				int id = scanner.nextInt();
				if (anOrder.searchById(id)==null) {
					System.out.println("Does not exist this product.");
				}else {
					anOrder.removeMedia(anOrder.searchById(id));
					System.out.println("Item has been deleted!");
				}
				break;
			case 4:
				if (anOrder == null) {
					System.out.println("Order has not been created");
					break;
				}
				anOrder.printDetails();
				break;
			default:
				System.out.println("Error!!! Please enter again.");
				break;
			}
		} while (true);
	}
	
	public static void showMenu(){
		System.out.println();
        System.out.println("\tOrder Management Application");
        System.out.println("_____________________");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("_____________________");
        System.out.println("Please choose a number: 0-1-2-3-4");

    }
	
	private static void addDisc(Order anOrder, Scanner scanner) {
		int id;
		do {
			System.out.println("Enter ID: ");
			id = scanner.nextInt();
			if (anOrder.searchById(id) != null) {
				System.out.println("Item already exists. Please enter ID again.");
			}
		} while (anOrder.searchById(id)!=null);
		System.out.println("Enter title: ");
		String title = scanner.next();
		System.out.println("Enter category: ");
		String category = scanner.next();
		System.out.println("Enter cost: ");
		float cost = scanner.nextFloat();
		System.out.println("Enter director: ");
		String director = scanner.next();
		System.out.println("Enter length: ");
		int length = scanner.nextInt();
		
		DigitalVideoDisc disc = new DigitalVideoDisc(title, category, director, length, cost, id);
		anOrder.addMedia(disc);
		
		playOrNot();
		int p = scanner.nextInt();
		switch (p) {
		case 1:
			disc.play();
			break;
		case 2:
			break;
		default:
			break;
		}
	}
	
	private static void addBook(Order anOrder, Scanner scanner) {
		int id;
		do {
			System.out.println("Enter ID: ");
			id = scanner.nextInt();
			if (anOrder.searchById(id) != null) {
				System.out.println("Item already exists. Please enter ID again.");
			}
		} while (anOrder.searchById(id)!=null);
		
		System.out.println("Enter title: ");
		String title = scanner.next();
		System.out.println("Enter category: ");
		String category = scanner.next();
		System.out.println("Enter cost: ");
		float cost = scanner.nextFloat();
		
		Book book = new Book(id, title, category, cost);
		int numOfAuthors = 0;
		do {
			System.out.println("Enter number of authors: ");
			numOfAuthors = scanner.nextInt();
			if (numOfAuthors <= 0) {
				System.out.println("Number of authors is invalid. Enter again");
			}
		} while (numOfAuthors <= 0);
		for (int i = 0; i < numOfAuthors; i++) {
			System.out.println("Enter author's name: ");
			String author = scanner.next();
			book.addAuthor(author);
		}
		anOrder.addMedia(book);
	}
	
	private static void addCompactDisc(Order anOrder, Scanner scanner) {
		int id;
		do {
			System.out.println("Enter ID: ");
			id = scanner.nextInt();
			if (anOrder.searchById(id) != null) {
				System.out.println("Item already exists. Please enter ID again.");
			}
		} while (anOrder.searchById(id)!=null);
		System.out.println("Enter title: ");
		String title = scanner.next();
		System.out.println("Enter category: ");
		String category = scanner.next();
		System.out.println("Enter cost: ");
		float cost = scanner.nextFloat();
		System.out.println("Enter artist: ");
		String artist = scanner.next();
		
		
		CompactDisc cd = new CompactDisc(id, title, category, cost, artist);
		
		System.out.println("Enter the number of tracks you want to add (>0):");
		int nbOfTrack = scanner.nextInt();
		
		for (int i = 0; i < nbOfTrack; i++) {
			System.out.println("Enter track's title: ");
			String titleString = scanner.next();
			System.out.println("Enter track's length: ");
			int length = scanner.nextInt();
			cd.addTrack(new Track(titleString, length));
		}
		
		anOrder.addMedia(cd);
		
		playOrNot();
		int p = scanner.nextInt();
		switch (p) {
		case 1:
			cd.play();
			break;
		case 2:
			break;
		default:
			break;
		}
	}
	
	public static void playOrNot() {
		System.out.println("Do you want to play CD/DVD?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		System.out.println("Please choose a number: 1-2");
	}

}
