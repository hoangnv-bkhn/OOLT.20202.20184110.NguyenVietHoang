package hust.soict.hedspi.test.utils;

import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;

public class DateTest {
	
	public static void main(String[] args) throws Exception {
		
		MyDate date = new MyDate();
		//MyDate date = new MyDate("10 Jan 2000"); // format dd MMM uuuu
		System.out.println(date.print());
		
		testgetDay(18, date);
		testgetMonth(3, date);
		testgetYear(2021, date);
		
		testsetYear(2000, date, 1);
		testsetYear(-1000, date, 0);
		
		testsetMonth(2, date, 1);
		testsetMonth(15, date, 0);
		
		testsetDay(29, date, 1);
		testsetDay(40, date, 0);
		
		System.out.println(date.print());
		System.out.println(date.print_Format(1));
		System.out.println(date.print_Format(2));
		System.out.println(date.print_Format(3));
		System.out.println(date.print_Format(4));
		System.out.println(date.print_Format(5));
		
		MyDate date2 = new MyDate("fifteen", "Apr.", "twenty hundred");
		
		testConstructor(date2, 15, 4, 2000);
		
		// test print method
		testPrintMethod(date2, "April 15th 2000");
		
		// test print with chosen format
		testPrintinFormatMethod(date2, 1, "2000-04-15");
		testPrintinFormatMethod(date2, 2, "15/4/2000");
		testPrintinFormatMethod(date2, 3, "15-Apr-2000");
		testPrintinFormatMethod(date2, 4, "Apr 15 2000");
		testPrintinFormatMethod(date2, 5, "04-15-2000");
		
		// test more for constructor
		MyDate date3 = new MyDate("twenty-fifth", "December", "fifteen thirty-eight");
		testConstructor(date3, 25, 12, 1538);
		
		MyDate date4 = new MyDate("twenty-eighth", "January", "eighteen fourteen");
		testConstructor(date4, 28, 1, 1840);
		
		//test compare method and sort method
		MyDate[] arrayDates = new MyDate[6];
		arrayDates[0] = new MyDate(31, 12, 2020);
		arrayDates[1] = new MyDate(1, 1, 2021);
		arrayDates[2] = new MyDate(3, 4, 2021);
		arrayDates[3] = new MyDate(1, 4, 2020);
		arrayDates[4] = new MyDate(5, 4, 2022);
		arrayDates[5] = new MyDate(1, 4, 2020);
		
		testCompare(arrayDates[0], arrayDates[1], -1);
		testCompare(arrayDates[2], arrayDates[1], 1);
		testCompare(arrayDates[3], arrayDates[5], 0);
		
		testSort(arrayDates);
		
		
	}
	
	public static void testSort(MyDate[] arrayDates) throws Exception {
		DateUtils.sortDate(arrayDates);
		for (int i = 0; i < arrayDates.length; i++) {
			assert DateUtils.compare(arrayDates[i], arrayDates[i+1]) == -1 : "Sort method error!!!";
		}
		System.out.println("Sort method works well!");
	}
	
	public static void testCompare(MyDate d1, MyDate d2, int result) {
		assert DateUtils.compare(d1, d2) == result : "Compare method error!!!";
		System.out.println("Compare method works well!");
	}
	
	public static void testPrintinFormatMethod(MyDate d1, int format, String string) {
		assert d1.print_Format(format).equals(string) : "Print with chosen format error!!!";
		System.out.println("Print with chosen format works well");
	}
	
	public static void testPrintMethod(MyDate d1, String string) {
		assert d1.print().equals(string) : "Print Method error!!!";
		System.out.println("Print Method works well");
	}
	
	public static void testConstructor(MyDate d1, int d, int m, int y) {
		assert d1.getDay() == d && d1.getMonth() == m && d1.getYear() == y : "Constructor error!!!";
		System.out.println("Contructor works well!");
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
