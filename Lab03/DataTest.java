package lab03;

public class DataTest {
	
	public static void main(String[] args) {
		
		MyDate date = new MyDate();
		//MyDate date = new MyDate("10 Jan 2000"); // format dd MMM uuuu
		date.print();
		
		testgetDay(17, date);
		testgetMonth(3, date);
		testgetYear(2021, date);
		
		testsetYear(2000, date, 1);
		testsetYear(-1000, date, 0);
		
		testsetMonth(2, date, 1);
		testsetMonth(15, date, 0);
		
		testsetDay(29, date, 1);
		testsetDay(40, date, 0);
		
		date.print();
		
	}
	public static void testgetDay(int day, MyDate date) {
		assert day == date.getDay() : "Method getDay error";
		System.out.println("Method getDay is working");
	}
	public static void testgetMonth(int month, MyDate date) {
		assert month == date.getMonth() : "Method getMonth error";
		System.out.println("Method getMonth is working");
	}
	public static void testgetYear(int year, MyDate date) {
		assert year == date.getYear() : "Method getYear error";
		System.out.println("Method getYear is working");
	}
	public static void testsetYear(int year, MyDate date, int type) { // type = 1 - year is valid: type =0 year is invalid
		switch (type) {
		case 0:
			try {
				date.setYear(year);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assert year != date.getYear() : "Method setYear error";
			System.out.println("Method setYear is working");
			break;
		case 1:
			try {
				date.setYear(year);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assert year == date.getYear() : "Method setYear error";
			System.out.println("Method setYear is working");
		default:
			break;
		}
	}
	public static void testsetMonth(int month, MyDate date, int type) { // type = 1 - year is valid: type =0 year is invalid
		switch (type) {
		case 0:
			try {
				date.setMonth(month);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assert month != date.getMonth() : "Method setMonth error";
			System.out.println("Method setMonth is working");
			break;
		case 1:
			try {
				date.setMonth(month);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assert month == date.getMonth() : "Method setMonth error";
			System.out.println("Method setMonth is working");
		default:
			break;
		}
	}
	public static void testsetDay(int day, MyDate date, int type) { // type = 1 - year is valid: type =0 year is invalid
		switch (type) {
		case 0:
			try {
				date.setDay(day);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assert day != date.getDay() : "Method setDay error";
			System.out.println("Method setDay is working");
			break;
		case 1:
			try {
				date.setDay(day);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assert day == date.getDay() : "Method setDay error";
			System.out.println("Method setDay is working");
		default:
			break;
		}
	}
}
