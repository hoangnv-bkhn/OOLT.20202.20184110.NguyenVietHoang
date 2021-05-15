package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class DiskTest {

	public static void testDiscSearch(DigitalVideoDisc d1, String title, int type) {
		if (type == 1) {
			assert d1.search(title) : "Search Method error!!!";
			System.out.println("Search method works well!");
		}else {
			assert !d1.search(title) : "Search Method error!!!";
			System.out.println("Search method works well!");
		}
	}
	
//	public static void testGetALuckyItem(Order aOrder) {
//		DigitalVideoDisc disc = (DigitalVideoDisc) aOrder.getALuckyItem();
//		assert disc.getCost() == 0 : "getALuckyItem error!!!";
//		System.out.println("Method getALuckyItem works well!");
//	}
}
