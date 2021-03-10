package Lab02;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NumericArray {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int[] A = new int[1000];
		
		for (int i = 0; i < A.length; i++) {
			A[i] = ((int) (Math.random()*(10000 - 0))) + 0;
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(A[i]);
		}

		int sum = 0, n;

		do {
		System.out.print("Enter number elements of array: ");
		while(!scanner.hasNextInt()) {
			String input = scanner.next();
            System.out.printf("\"%s\" is not a valid number.\n", input);
            System.out.print("Number elements of array must be greater than or equal to 0 and less than 1000: ");
		}
		n = scanner.nextInt();
		
		if(n < 0 || n >= 1000) {
            System.out.print("Number elements of array must be greater than or equal to 0 and less than 1000\n");
		}
		}while(n < 0 || n >= 1000);

		Integer[] m = new Integer[n];
		
		System.out.println("Enter elements: ");
		for (int i = 0; i < m.length; i++) {
			if(!scanner.hasNextInt()) {
				String input = scanner.next();
				if (input.equals("$")) {
					m[i] = A[i];
				}
			}else {
			m[i] = scanner.nextInt();
			}
		}
		
		int choice = 0;
		do {
			System.out.println("==============================");
			System.out.println("Type sort: ");
			System.out.println("\t1. Ascending");
			System.out.println("\t2. Descending");
			System.out.print(" Your choice: ");
			while(!scanner.hasNextInt()) {
				String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
                System.out.print("Your choice must be greater than 1 and less than 2: ");
			}
			choice = scanner.nextInt();
			
			if(choice < 1 || choice > 2) {
                System.out.print("Your choice must be greater than 1 and less than 2\n");
			}
		} while (choice < 1 || choice > 2);
		
		switch (choice) {
		case 1:
			Arrays.sort(m);
			System.out.printf("Array after sort: %s\n", Arrays.toString(m));
			break;
		case 2:
			Arrays.sort(m, Collections.reverseOrder());
			System.out.printf("Array after sort: %s\n", Arrays.toString(m));
		default:
			break;
		}

		for (int i : m) {
			sum += i;
		}

		double avg = (double) sum / n;

		System.out.println("Sum of array elements: " + sum);
		System.out.println("Average of array elements: " + avg);

	}
}
