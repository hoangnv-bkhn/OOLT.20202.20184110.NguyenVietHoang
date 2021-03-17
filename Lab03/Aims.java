package lab03;

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
		
		System.out.print("Total Cost is: ");
		System.out.println(anOrder.totalCost());
		
		anOrder.print();
		
		anOrder.removeDigitalVideoDisc(dvd4);
		
		anOrder.print();
		
		assert anOrder.getQtyOrdered()==3: "Quantity Ordered isn't correct"; // check quantity after remove
		assert anOrder.getItemsOrdered()[2].getTitle().equals("The Lion King"); // check if the first element named "The Lion King" is removed
		
	}

}
