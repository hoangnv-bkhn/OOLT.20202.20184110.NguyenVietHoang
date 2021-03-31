package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {

	public static final int MAX_NUMBERS_ORDERED = 10;
	
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0;
	
	private MyDate dateOrdered;
	
	private static int nbOrders = 0;
	
	public static int getNbOrders() {
		return nbOrders;
	}

	public static final int MAX_LIMITTED_ORDERS = 5;
	
	public Order() throws Exception {
		if (nbOrders >= MAX_LIMITTED_ORDERS) {
			System.out.println("Error!!! The list of orders if full.");
			throw new Exception("Order initialization failed!!! - The number of orders has reached the limit.");
		}else {
			dateOrdered = new MyDate();
			dateOrdered.print();
			nbOrders++;
			System.out.println("Success!!! Order has been created.");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered >= 10) {
			System.out.println("Error!!! The order list is full");
		}else {
			itemsOrdered[qtyOrdered] = disc;
			System.out.println("Success! "+disc.getTitle()+"is added to the order list.");
			qtyOrdered++;
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		if (qtyOrdered >= 10) {
			System.out.println("Error!!! The order list is full");
		}else {
			int n = dvdList.length;
			if (qtyOrdered + n > 10) {
				System.out.println("There is not enough slot left for these items.");
			}else {
				for (int i = 0; i < dvdList.length; i++) {
					itemsOrdered[qtyOrdered] = dvdList[i];
					System.out.println("Success! "+dvdList[i].getTitle()+" is added to the order list.");
					qtyOrdered++;
				}
			}
		}
	}
	/*
	public void addDigitalVideoDisc(DigitalVideoDisc ...arr) {
		if (arr == null) {
			System.out.println("Error!!! There is no disc to add.");
		}else if (qtyOrdered >= 10) {
			System.out.println("Error!!! The order list is full");
		}else {
			int n = arr.length;
			if (qtyOrdered + n > 10) {
				System.out.println("There is not enough slot left for these items.");
			}else {
				for (int i = 0; i < arr.length; i++) {
					itemsOrdered[qtyOrdered] = arr[i];
					System.out.println("Success! "+arr[i].getTitle()+" is added to the order list.");
					qtyOrdered++;
				}
			}
		}
	}
	*/
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered >= 10) {
			System.out.println("There is not enough slot left for these items.");
			System.out.println("The dvd "+dvd1.getTitle()+" could not be added");
			System.out.println("The dvd "+dvd2.getTitle()+" could not be added");
		}else {
			if (qtyOrdered>=9) {
				itemsOrdered[qtyOrdered] = dvd1;
				qtyOrdered++;
				System.out.println("The dvd "+dvd1.getTitle()+" is added.");
				System.out.println("The dvd "+dvd2.getTitle()+" could not be added");
			}else {
				itemsOrdered[qtyOrdered] = dvd1;
				qtyOrdered++;
				System.out.println("The dvd "+dvd1.getTitle()+" is added.");
				itemsOrdered[qtyOrdered] = dvd2;
				qtyOrdered++;
				System.out.println("The dvd "+dvd2.getTitle()+" is added.");
			}
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (itemsOrdered == null) {
			System.out.println("Error! The Order list is empty.");
		}else {
			int k = 0;
			for (int i = 0; i < itemsOrdered.length; i++) {
				if (itemsOrdered[i].getTitle().equals(disc.getTitle())) {
					System.out.println("Success! "+itemsOrdered[i].getTitle()+" is removed from order list.");
					System.arraycopy(itemsOrdered, i+1, itemsOrdered, i, itemsOrdered.length - i - 1);
					qtyOrdered--;
					k = 1;
					break;
				}
			}
			if (k == 0) {
				System.out.println("Error! No item named "+disc.getTitle()+" in order list.");
			}
		}
	}
	
	public float totalCost() {
		float sum = 0f;
		for (int i = 0; i < qtyOrdered; i++) {
			sum = sum + itemsOrdered[i].getCost();
		}
		return sum;
	}
	public void print() {
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.print(itemsOrdered[i].getTitle()+": ");
			System.out.println(itemsOrdered[i].getCost());
		}
	}
	public DigitalVideoDisc[] getItemsOrdered() {
		return itemsOrdered;
	}
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	
	public void printDetails() {
		System.out.println("******************Order******************");
		System.out.print("Date: ");
		dateOrdered.print();
		System.out.println("Ordered items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println("DVD - "+itemsOrdered[i].getTitle()+" "+itemsOrdered[i].getCategory()+" "+itemsOrdered[i].getDirector()+" "+
					itemsOrdered[i].getLength()+": "+itemsOrdered[i].getCost()+"$");
		}
		System.out.println("Total cost: "+totalCost());
	}
	
	public DigitalVideoDisc getALuckyItem() {
		if (qtyOrdered < 1) {
			return null;
		}else {
			int index = (int)(Math.random()*qtyOrdered);
			itemsOrdered[index].setCost(0);
			return itemsOrdered[index];
		}
	}
	
}
