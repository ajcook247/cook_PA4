package cook_p1;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class DuplicateRemover {

	private static HashSet<String> uniqueWords = new HashSet<String>();
	
	// Takes in a string representing a input file path, reads in text from that file, and adds each word to
	// a set called uniqueWords, while preventing duplicate words from being added.
	public static void remove(String dataFile) throws IOException
	{
		FileInputStream fis = null;
		Scanner inScan = null;
		
		fis = new FileInputStream(dataFile);
		inScan = new Scanner(fis);

		// While there is text remaining, add non-duplicate words to uniqueWords
		while(inScan.hasNext())
		{
			uniqueWords.add(inScan.next());
		}
		
		// Close the scanners and input stream
		inScan.close();
		fis.close();
		
	}
	
	// Takes in a string representing a output file path, and prints each element from set UniqueWords to that file.
	public static void write(String outputFile) throws IOException
	{
		FileOutputStream fos = null;
		PrintWriter pw = null;

		fos = new FileOutputStream(outputFile);
		pw = new PrintWriter(fos);
		
		// Iterates through each string in uniqueWords, appending each to outputFile
		for (String s : uniqueWords)
		{
			pw.println(s);
		}
		
		// Close the writers and input stream
		pw.flush();
		fos.close();
	}
}
