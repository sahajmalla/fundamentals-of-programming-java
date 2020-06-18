package assessment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author 77227213-Sahaj-Bikram-Malla
 *
 */
public class C77227213 {
	public static void main(String[] args) {
		// displaying what this program will do
		System.out.println("This program will try to read data from a text file");
		System.out.println("Enter the name of file: ");

		Scanner scan = new Scanner(System.in);

		String filename = scan.nextLine();
		Scanner fileReader = null;
		String line;
		String[] split = new String[6];
		String[] authorNames = new String[100]; // stores author names
		double price = 0.00;
		int pages = 0, index = 0, count = 0, fileLine = 0;
		boolean bookFound = false; // error is not found

		try { // try if file is present
			File file = new File(filename);
			fileReader = new Scanner(file);

			while (fileReader.hasNext()) {
				// Reading each line
				line = fileReader.nextLine();

				// Splitting the delimiter and store in array split
				split = line.split("-");
				// if array length is 6

				if (split.length == 6) {

					// Removing white space
					split[0] = split[0].trim(); // title
					split[1] = split[1].trim(); // author
					split[2] = split[2].trim(); // publisher
					split[3] = split[3].trim(); // price
					split[4] = split[4].trim(); // pages
					split[5] = split[5].trim(); // ISBN

					if (split[0].equals("")) {
						System.out.println("\nTitle: missing"); // if title is missing
						count++;

					} else {
						System.out.println("\nTitle: " + split[0]); // else print title
					}
					if (split[1].equals("")) {
						System.out.println("Author: missing");// if author is missing
						count++;

					} else {
						System.out.println("Author: " + split[1]);// else print author
					}
					if (split[2].equals("")) {
						System.out.println("Publisher: missing ");// if publisher is missing
						count++;

					} else {
						System.out.println("Publisher: " + split[2]);// else print publisher
					}
					if (split[3].equals("")) {
						System.out.println("Price: missing ");// if price is missing
						count++;
					} else {
						try {
							price = Double.parseDouble(split[3]); // checking valid double using parseDouble()

						} catch (NumberFormatException e) {
							System.out.println("Price: not numeric");// else print not numeric
							count++;

						}
					}
					if (split[4].equals("")) {
						System.out.println("Pages: missing ");// if page is missing
						count++;
					} else {
						try {
							pages = Integer.parseInt(split[4]); // checking valid integer using parseInt() method
							System.out.println("Pages: " + split[4]); // if valid print pages
						} catch (NumberFormatException e) {
							System.out.println("Pages: not numeric");// else print not numeric
							count++;

						}
					}

					if (split[5].equals("")) {
						System.out.println("ISBN: missing");// if ISBN is missing
						count++;

					} else {
						System.out.println("ISBN: " +split[5]);// else print ISBN
					}
					System.out.println("----------------------------------------------------");
				} else {
					System.out.println("\nWrong delimiter used\n");
					System.out.println("----------------------------------------------------");
					count++;
				}

			}

			// reading errors
			System.out.println("~~~~~~~~~~~~~");
			System.out.println("ERRORS:");
			System.out.println("~~~~~~~~~~~~~");
			fileReader = null; // reinitializing file reader
			fileReader = new Scanner(file);

			while (fileReader.hasNext()) {
				// Reading each line
				line = fileReader.nextLine();

				// Splitting the delimiter and store in array split
				split = line.split("-");
				// if array length is 6

				if (split.length == 6) {

					// Removing white space
					split[0] = split[0].trim(); // title
					split[1] = split[1].trim(); // author
					split[2] = split[2].trim(); // publisher
					split[3] = split[3].trim(); // price
					split[4] = split[4].trim(); // pages
					split[5] = split[5].trim(); // ISBN

					fileLine++; // counts the line of the file

					if (split[0].equals("")) {

						System.out.println("Book title may be missing at line " + fileLine); // if title is missing

					}
					if (split[1].equals("")) {
						System.out.println("Book author may be missing at line " + fileLine);// if author is missing

					}
					if (split[2].equals("")) {
						System.out.println("Book publisher may be missing at line " + fileLine);// if publisher is missing

					}
					if (split[3].equals("")) {
						System.out.println("Price may be missing at line " + fileLine);// if price is missing
					} else {
						try {
							price = Double.parseDouble(split[3]); // checking valid double using parseDouble()

						} catch (NumberFormatException e) {
							System.out.println("Book price may not be a numeric value at line " + fileLine);// else not
																											// numeric
						}
					}
					if (split[4].contentEquals("")) {
						System.out.println("Pages may be missing at line " + fileLine);
					} else {
						try {
							pages = Integer.parseInt(split[4]); // checking valid integer using parseInt() method

						} catch (NumberFormatException e) {
							System.out.println("Book number of pages may not be a numeric value at line " + fileLine);// else
																														// not
																														// numeric
						}
					}

					if (split[5].equals("")) {
						System.out.println("Book ISBN may be missing at line " + fileLine);// if ISBN is missing

					}
				} else {
					fileLine++;
					System.out.println(
							"The field delimiter may be missing or wrong field delimiter is used at line " + fileLine);

				}

			}

			System.out.println("\nThere are " + count
					+ " number of invalid data of books in the file.\nCheck for missing data or incorrect format.");
			System.out.println("---------------------------------");

			// finding book details by author name
			fileReader = null; // reinitializing file reader
			fileReader = new Scanner(file);

			System.out.println("\n\nWhich author's book details do you want? "); // asking user for book name
			String bookAuthor = scan.nextLine();

			while (fileReader.hasNext()) {

				line = fileReader.nextLine();
				split = line.split("-");
				if (split.length == 6) {
					// Removing white space
					split[0] = split[0].trim(); // title
					split[1] = split[1].trim(); // author
					split[2] = split[2].trim(); // publisher
					split[3] = split[3].trim(); // price
					split[4] = split[4].trim(); // pages
					split[5] = split[5].trim(); // ISBN

					authorNames[index] = split[1]; // store author name in array
					if (authorNames[index].equals("")) {
						authorNames[index] = "Error missing author"; // if stored name is a white space then error
																		// missing author will be stored
					}

					if (authorNames[index].equals(bookAuthor)) {
						if (split[0].equals("")) {
							System.out.println("\nTitle: missing"); // if title is missing

						} else {
							System.out.println("\nTitle: " + String.format("%s ", split[0])); // else print title
						}

						System.out.println("Author: " + String.format("%s ", split[1])); // print author

						if (split[2].equals("")) {
							System.out.println("Publisher: missing ");// if publisher is missing

						} else {
							System.out.println("Publisher: " + String.format("%s ", split[2]));// else print publisher
						}
						if (split[3].equals("")) {
							System.out.println("Price: missing");
						} else {
							try {
								price = Double.parseDouble(split[3]); // checking valid double using parseDouble()
								System.out.println("Price: " + String.format("%s ", split[3])); // if valid print price
							} catch (NumberFormatException e) {
								System.out.println("Price: not numeric");// else print not numeric

							}
						}
						if (split[4].equals("")) {
							System.out.println("Pages: missing");
						} else {
							try {
								pages = Integer.parseInt(split[4]); // checking valid integer using parseInt() method
								System.out.println("Pages: " + String.format("%s ", split[4])); // if valid print pages
							} catch (NumberFormatException e) {
								System.out.println("Pages: not numeric");// else print not numeric

							}
						}
						if (split[5].equals("")) {
							System.out.println("ISBN: missing");// if ISBN is missing

						} else {
							System.out.println("ISBN: " + String.format("%s ", split[5]));// else print ISBN
						}
						System.out.println("----------------------------------------------------");

						bookFound = true;

					}
					index++;

				} else {
					authorNames[index] = "Error missing author";// if delimiter is not matched then error missing author
																// will be stored
					index++;
				}

			}
			// if book not found

			if (bookFound == false) {
				System.out.println("Book not found of author name " + bookAuthor);
			}

		} catch (FileNotFoundException e) { // file not found
			System.out.println("File not found");
		}
	}

}
