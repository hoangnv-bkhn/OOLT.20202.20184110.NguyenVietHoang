package lab03;

public class Order {

	public static final int MAX_NUMBERS_ORDERED = 10;
	
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered >= 10) {
			System.out.println("Error!!! The order list is full");
		}else {
			itemsOrdered[qtyOrdered] = disc;
			System.out.println("Success! "+disc.getTitle()+"is added to the order list.");
			qtyOrdered++;
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (itemsOrdered == null) {
			System.out.println("Error! The Order list is empty.");
		}else {
			int k = 0;
			for (int i = 0; i < itemsOrdered.length; i++) {
				if (itemsOrdered[i].getTitle() == disc.getTitle()) {
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
	
	
}
