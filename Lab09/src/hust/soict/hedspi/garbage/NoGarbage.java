package hust.soict.hedspi.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NoGarbage {

	public static void main(String[] args) {

		File f = new File("D:\\Code\\Eclipse_Workspace\\Lab01\\src\\hust\\soict\\hedspi\\garbage\\text.txt");
		long start = System.currentTimeMillis();
		StringBuilder string = new StringBuilder();

		try {
			Scanner scanner = new Scanner(f);
			while (scanner.hasNextLine()) {
				string.append(scanner.nextLine());
			}
			System.out.println(System.currentTimeMillis() - start);
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
