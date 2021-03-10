package Lab02;

import java.util.Scanner;

public class DaysOfMonth {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int year, t = -1 , c;
		String month;
		
		String[] m1 = {"January", "February", "March", "April", "May","June","July", "August", "September", "October", "November", "December"};
		String[] m2 = {"Jan.", "Feb.", "Mar.", "Apr.", "May","June","July", "Aug.", "Sept.", "Oct.", "Nov.", "Dec."};
		String[] m3 = {"Jan", "Feb", "Mar", "Apr", "May","Jun","Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
		String[] m4 = {"1", "2", "3", "4", "5","6","7", "8", "9", "10", "11", "12"};
		
 		do {
		System.out.print("Year: ");
		while(!scanner.hasNextInt()) {
			String input = scanner.next();
            System.out.printf("\"%s\" is not a valid number.\n", input);
            System.out.print("Year must be greater than 0: ");
		}
		year = scanner.nextInt();
		if (year <= 0) {
			System.out.println("Year is invalid. Please enter again!");
		}
		}while(year <= 0);
		
		do {
			System.out.print("Month: ");
			month = scanner.next();
			c = 0;
			for (int i = 0; i < m1.length; i++) {
				if (m1[i].equals(month)) {
					c = 1;
					t = i;
				}
			}
			if (c == 0) {
				for (int i = 0; i < m2.length; i++) {
					if (m2[i].equals(month)) {
						c = 1;
						t = i;
					}
				}
			}
			if (c == 0) {
				for (int i = 0; i < m3.length; i++) {
					if (m3[i].equals(month)) {
						c = 1;
						t = i;
					}
				}
			}
			if (c == 0) {
				for (int i = 0; i < m4.length; i++) {
					if (m4[i].equals(month)) {
						c = 1;
						t = i;
					}
				}
			}
			if (c == 0) {
				System.out.println("Month is invalid. Please enter again!");
			}
		} while (c == 0);
		
		switch (t) {
		case 0:
		case 2:
		case 4:
		case 6:
		case 7:
		case 9:
		case 11:
			System.out.println("Number of days: 31");
			break;
		case 3:
		case 5:
		case 8:
		case 10:
			System.out.println("Number of days: 30");
			break;
		case 1:
			if (year%4 == 0) {
				if (year % 100 == 0) {
					if (year%400 == 0) {
						System.out.println("Number of days: 29");
					}else {
						System.out.println("Number of days: 28");
					}
				}else {
					System.out.println("Number of days: 29");
				}
			}else {
				System.out.println("Number of days: 28");
			}
			break;
		default:
			break;
		}
		
		scanner.close();
	}
}
