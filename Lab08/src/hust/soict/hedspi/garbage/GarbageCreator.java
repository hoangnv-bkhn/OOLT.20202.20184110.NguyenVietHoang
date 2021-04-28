package hust.soict.hedspi.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GarbageCreator {

	public static void main(String[] args) {

		File f = new File("D:\\Code\\Eclipse_Workspace\\Lab01\\src\\hust\\soict\\hedspi\\garbage\\text.txt");
		long start = System.currentTimeMillis();

		try {
			Scanner scanner = new Scanner(f);
			String string = "";
			while (scanner.hasNextLine()) {
				string += scanner.nextLine();
			}
			System.out.println(System.currentTimeMillis() - start);
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
