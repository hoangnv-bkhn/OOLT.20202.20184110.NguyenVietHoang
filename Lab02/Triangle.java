package Lab02;

import java.util.Iterator;
import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the height of star: ");
		int n = scanner.nextInt();
		
		for (int i = 0; i < n; i++) {
			
			for (int j = n-i-1; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		scanner.close();
	}
}