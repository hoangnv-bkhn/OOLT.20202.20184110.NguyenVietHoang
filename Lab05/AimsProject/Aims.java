package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class Aims {

	public static void main(String[] args) throws Exception {

		Order anOrder = new Order();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		
		anOrder.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King");
		dvd4.setCategory("Animation");
		dvd4.setCost(12.99f);
		dvd4.setDirector("John Musker");
		dvd4.setLength(90);
		
		anOrder.addDigitalVideoDisc(dvd4);
		
		anOrder.removeDigitalVideoDisc(dvd4);
		
		assert anOrder.getQtyOrdered()==3: "Quantity Ordered isn't correct"; // check quantity after remove
		assert anOrder.getItemsOrdered()[2].getTitle().equals("The Lion King"); // check if the first element named "The Lion King" is removed
		
		Order order2 = new Order();
		order2.addDigitalVideoDisc(dvd1);
		Order order3 = new Order();
		order3.addDigitalVideoDisc(dvd2);
		
		anOrder.printDetails();
		order2.printDetails();
		order3.printDetails();
		
		System.out.println("----------------------------------------");
		
		// test add array disc
		testAddArrayDisc(anOrder, 20, 0);
		testAddArrayDisc(anOrder, 6, 1);
		
		// test add two disc
		testAddTwoObject(anOrder, 0);
		testAddTwoObject(anOrder, 1);
		testAddTwoObject(anOrder, 2);
		
		// test add order
		testAddOrder(1, 1);
		testAddOrder(4, 0);
		
		// test search title method
		DiskTest.testDiscSearch(dvd1, "The king", 1);
		DiskTest.testDiscSearch(dvd2, "stars", 0);
		
		// test getALuckyItem method
		DiskTest.testGetALuckyItem(anOrder);
		
		
	}
	
	public static void testAddArrayDisc(Order anOrder, int qty, int type) { // type = 0 - can't add to Order && type = 1 can add 
		DigitalVideoDisc[] listDiscs = new DigitalVideoDisc[qty];
		int curQty = anOrder.getQtyOrdered();
		for (int i = 0; i < qty; i++) {
			listDiscs[i] = new DigitalVideoDisc("Title: "+i);
		}
		anOrder.addDigitalVideoDisc(listDiscs);
		switch (type) {
		case 1:
			assert anOrder.getQtyOrdered() == curQty + qty : "Method addDigitalVideoDisc with array error!!!";
			System.out.println("Method addDigitalVideoDisc with array work fine!\n");
			break;
		case 0:
			assert anOrder.getQtyOrdered() == curQty : "Method addDigitalVideoDisc with array error!!!";
			System.out.println("Method addDigitalVideoDisc with array work fine!\n");
			break;
		default:
			break;
		}
	}
	
	public static void testAddTwoObject(Order anOrder, int type) { // type = 0 - can't add any items, type = 1 can add only 1 items, type = 2 can add two items.
		DigitalVideoDisc d1 = new DigitalVideoDisc("<1>");
		DigitalVideoDisc d2 = new DigitalVideoDisc("<2>");
		int curQty = anOrder.getQtyOrdered();
		anOrder.addDigitalVideoDisc(d1, d2);
		switch (type) {
		case 0:
			assert anOrder.getQtyOrdered() == curQty : "Method addDigitalVideoDisc with two object error!!!";
			System.out.println("Method addDigitalVideoDisc with two object work fine!\n");
			break;
		case 1:
			assert anOrder.getQtyOrdered() == curQty + 1 : "Method addDigitalVideoDisc with two object error!!!";
			System.out.println("Method addDigitalVideoDisc with two object work fine!\n");
			break;
		case 2:
			assert anOrder.getQtyOrdered() == curQty + 2 : "Method addDigitalVideoDisc with two object error!!!";
			System.out.println("Method addDigitalVideoDisc with two object work fine!\n");
			break;
		default:
			break;
		}
	}
	public static void testAddOrder(int numOrder, int type) {
		int curNumOrder = Order.getNbOrders();
		switch (type) {
		case 0:
			try {
				for (int i = 0; i < numOrder; i++) {
					Order order = new Order();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			assert Order.getNbOrders() == Order.MAX_LIMITTED_ORDERS : "The constructor error!!!";
			System.out.println("The constructor works well");
			break;
		case 1:
			try {
				for (int i = 0; i < numOrder; i++) {
					Order order = new Order();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			assert Order.getNbOrders() == curNumOrder + numOrder : "The constructor error!!!";
			System.out.println("The constructor works well");
			break;
		default:
			break;
		}
		
	}
	

}
