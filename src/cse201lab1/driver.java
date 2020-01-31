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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class driver {

	public static void main(String[] args) {
		ArrayList<String> namesList;
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
			}
			
			// Search for the name that the user enters
			System.out.print("Please enter a " + gender + " name: ");
			String nameInput = in.next();
			
		}

	}
	
	/**
	 * Searches for a string in the first ten entries of an ArrayList<String>
	 * 
	 * @param list The ArrayList<String> to be searched
	 * @param str The string to be searched for in the list.
	 */
	private static void searchTop(ArrayList<String> list, String str) {
		// TODO
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
