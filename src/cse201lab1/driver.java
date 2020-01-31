/**
 * An application capable of performing the following tasks.
 * 	a.Read the contents of one of the files (that you would like) into anArrayList. 
 * 	b.The user should be able to enter a boy/girl’s name as input and
 * 	c.The application will display messages indicating whether the name was among the most popular. 
 * 	d.It also displays if the name is contained in (substring) any of the most popular names.
 * 
 * @author TaJah Reynolds
 * @author Ryan Dockman
 */
package cse201lab1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class driver {

	public static void main(String[] args) {
		ArrayList<String> namesList = new ArrayList<String>();
		String gender = "non-binary";
		Scanner in = new Scanner(System.in);
		boolean exit = false, valid = false;

		// TODO: read files from local directory instead of user specific (my) directory
		File boyNames = new File("C:\\Users\\tjrey\\OneDrive\\Documents\\dev\\cse201\\cse201lab1\\src\\BoyNames.txt");
		File girlNames = new File("C:\\Users\\tjrey\\OneDrive\\Documents\\dev\\cse201\\cse201lab1\\src\\GirlNames.txt");

		// User Interaction
		while (!exit) {

			// Load BoyNames.txt or GirlNames.txt based on user input
			while (!valid) {
				System.out.print("Enter 1 to load boy names, or enter 2 to load girl names: ");
				try {
					switch (in.nextInt()) {
					case 1:
						namesList = readFile(boyNames);
						gender = "boy";
						valid = true;
						break;

					case 2:
						namesList = readFile(girlNames);
						gender = "girl";
						valid = true;
						break;
					default:
						System.out.println("The entry was not recognized. Please try again.");
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid entry. The program will now exit.");
					in.close();
					System.exit(1);
				}
			}

			// Search for the name that the user enters
			System.out.print("Please enter a " + gender + " name: ");
			String nameInput = in.next();
			search(namesList, nameInput);
			exit = true;
		}

	}

	/**
	 * Searches for a string in an ArrayList<String>
	 * 
	 * @param list The ArrayList<String> to be searched
	 * @param str  The string to be searched for in the list.
	 */
	private static void search(ArrayList<String> list, String str) {
		String modStr = str.substring(0, 1).toUpperCase() + str.substring(1);
		boolean found = false;
		for (String s : list) {
			if (s.equalsIgnoreCase(str)) {
				System.out.println("The name " + s + " is one of the most popular names.");
				return;
			}
			if (s.contains(str) || s.contains(modStr)) {
				System.out.println("The name " + str + " is contained in one of the most popular names, " + s + ".");
				found = true;
			}
		}
		if (!found) {
			System.out.println("The name " + str + " was not found.");
		}
	}

	/**
	 * Reads the contents of a file into an ArrayList
	 * 
	 * @param file The file to read into the ArrayList
	 */
	private static ArrayList<String> readFile(File file) {
		Scanner sc = null;

		ArrayList<String> namesList = new ArrayList<String>();
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
			e.printStackTrace();
		} finally {
			while (sc.hasNextLine())
				namesList.add(sc.nextLine());
		}

		return namesList;
	}

}
