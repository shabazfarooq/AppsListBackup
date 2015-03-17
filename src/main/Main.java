package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {

		/***********************************************************/
		/*    Load excluded apps list                              */
		/***********************************************************/

		// Initialize an arraylist to store excluded apps into
		ArrayList<String> excludeList = new ArrayList<String>();
		
		// Load the list of excluded apps from the ExcludedApps.txt file
		// and store into the arraylist.
		File file = new File("./ExcludedApps.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		
		while ((line = br.readLine()) != null) {
		   excludeList.add(line);
		}
		
		br.close();
		
		
		/***********************************************************/
		/*  Load installed applications from /Applications folder  */
		/***********************************************************/
		
		// Load the names of the entire directory contents into an array
		File folder = new File("/Applications/");
		File[] listOfFiles = folder.listFiles();
		
		// Create a file to begin writing apps list to
		BufferedWriter out = null;
	    FileWriter fstream = new FileWriter("./AppsList.txt", false);
	    out = new BufferedWriter(fstream);
	    
	    // Begin writing to file the apps that are in the Applications folder
	    // and not excluded.
		for (File file2 : listOfFiles) {
			
			if (!excludeList.contains(file2.getName()) ) {
				// Write to backup file
			    out.write(file2.getName() + "\n");
		        
			}
			
		}
		
		
		out.close();
		
		
		
		// Print success to console!
		System.out.println("******************************************************************");
		System.out.println("**   Application names have successfully been backuped up to:   **");
		System.out.println("**   AppsList.txt                                               **");
		System.out.println("******************************************************************");


	}

	
}
