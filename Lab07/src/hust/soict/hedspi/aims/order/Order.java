package hust.soict.hedspi.aims.order;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {

	public static final int MAX_NUMBERS_ORDERED = 10;
	
	private ArrayList<Media> itemsOrdered = new ArrayList<>();
	
	private MyDate dateOrdered;
	
	private static int nbOrders = 0;
	
	public static int getNbOrders() {
		return nbOrders;
	}
	
	private int id;

	public int getId() {
		return id;
	}

	public static final int MAX_LIMITTED_ORDERS = 5;
	
	public Order() throws Exception {
		if (nbOrders >= MAX_LIMITTED_ORDERS) {
			System.out.println("Error!!! The list of orders if full.");
			throw new Exception("Order initialization failed!!! - The number of orders has reached the limit.");
		}else {
			dateOrdered = new MyDate();
			System.out.println(dateOrdered.print());
			nbOrders++;
			System.out.println("Success!!! Order has been created.");
		}
	}
	
	public void addMedia(Media media) {
		if (itemsOrdered.size() >=10) {
			System.out.println("Error!!! The order list is full");
		}else {
			itemsOrdered.add(media);
			System.out.println("Success! "+media.getTitle()+" is added to the order list.");
		}
	}
	
	public void addMedia(Media ...medias) {
		if (medias == null) {
			System.out.println("Error!!! There is no media to add.");
		}else if (itemsOrdered.size() >= 10) {
			System.out.println("Error!!! The order list is full");
		}else {
			int n = medias.length;
			if (itemsOrdered.size() + n > 10) {
				System.out.println("There is not enough slot left for these items.");
			}else {
				for (int i = 0; i < medias.length; i++) {
					itemsOrdered.add(medias[i]);
					System.out.println("Success! "+medias[i].getTitle()+" is added to the order list.");
				}
			}
		}
	}

	public void addMedia(Media media1, Media media2) {
		if (itemsOrdered.size() >= 10) {
			System.out.println("There is not enough slot left for these items.");
			System.out.println("The dvd "+media1.getTitle()+" could not be added");
			System.out.println("The dvd "+media2.getTitle()+" could not be added");
		}else {
			if (itemsOrdered.size() >= 9) {
				itemsOrdered.add(media1);
				System.out.println("The dvd "+media1.getTitle()+" is added.");
				System.out.println("The dvd "+media2.getTitle()+" could not be added");
			}else {
				itemsOrdered.add(media1);
				System.out.println("The dvd "+media1.getTitle()+" is added.");
				itemsOrdered.add(media2);
				System.out.println("The dvd "+media2.getTitle()+" is added.");
			}
		}
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.size() <= 0) {
			System.out.println("Error! The Order list is empty.");
		}else {
			if(itemsOrdered.remove(media)) {
				System.out.println("Success! "+media.getTitle()+" is removed from order list.");
			}else {
				System.out.println("Error! No item named "+media.getTitle()+" in order list.");
			}
		}
	}
	
	public Media searchById(int id) {
		Media media =  this.itemsOrdered.stream().filter(o->o.getId()==id).findFirst().orElse(null);
        return media;
	}
	
	public float totalCost() {
		float sum = 0f;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			sum = sum + itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	public void print() {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.print(itemsOrdered.get(i).getTitle()+": ");
			System.out.println(itemsOrdered.get(i).getCost());
		}
	}
	
	public void printDetails() {
		System.out.println("******************Order******************");
		System.out.print("Date: ");
		System.out.println(dateOrdered.print());
		System.out.println("Ordered items:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println("\t"+itemsOrdered.get(i).getTitle()+" "+itemsOrdered.get(i).getCategory()+" "+": "+itemsOrdered.get(i).getCost()+"$");
		}
		System.out.println("Total cost: "+totalCost());
	}
	
//	public Media getALuckyItem() {
//		if (itemsOrdered.size() < 1) {
//			return null;
//		}else {
//			int index = (int)(Math.random()*itemsOrdered.size());
//			itemsOrdered.get(index).setCost(0);
//			return itemsOrdered.get(index);
//		}
//	}
	
}
