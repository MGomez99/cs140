package lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class ScanEx {
	public static void main(String[] args) {
		new ScanEx().experiment(new File(args[0]));
	}

	private void experiment(File file) {
		try (Scanner input = new Scanner(new FileReader(file))) {
			int sum = 0;
			while (input.hasNext()) {
				if (input.hasNextInt()) {
					int i = input.nextInt();
					sum += i;
					System.out.println(i + " -> " + sum);
				} else System.out.println("Clearing line: " + input.next());
			}
		} catch (InputMismatchException ex) {
			System.out.println(ex + "--not a number from nextInt()");

		} catch (NoSuchElementException ex) {
			System.out.println(ex);
			System.out.println(ex.getMessage());
			System.out.println(ex + "--nothing left in file");
		} catch (FileNotFoundException ex) {
			System.out.println("File" + file.getName() + " is not found");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
