/**
 * An application capable of performing the following tasks.
 * 	a.Read the contents of one of the files (that you would like) into anArrayList. 
 * 	b.The user should be able to enter a boy/girl’s name as input and
 * 	c.The application will display messages indicating whether the name was among the most popular. 
 * 	d.It also displays if the name is contained in (substring) any of the most popular names.
 * 
 * @author TaJah Reynolds
 */
package cse201lab1;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class driver {
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * Reads the contents of a file into an ArrayList 
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
