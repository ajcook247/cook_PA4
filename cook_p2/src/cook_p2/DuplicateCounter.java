package cook_p2;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCounter {

	private HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();
	
	// Takes in a string representing a input file path, reads in text from that file, and adds each word as a key
	// in a map called wordCounter, with each value representing the number of times that key has occurred in 
	// the input file.
	public void count(String dataFile)
	{
		try
		{
			FileInputStream fis = null;
			Scanner inScan = null;
			String currentWord;
			
			fis = new FileInputStream(dataFile);
			inScan = new Scanner(fis);
	
			// While there is text remaining, scan in each word from dataFile. If the word is not in the map, add it
			// with value 1; otherwise, do not add it, but increment its value.
			while (inScan.hasNext())
			{
				currentWord = inScan.next();
				
				if (!wordCounter.containsKey(currentWord))
				{
					wordCounter.put(currentWord, 1);
				}
				else
				{
					wordCounter.put(currentWord, wordCounter.get(currentWord) + 1);
				}
			}
			
			// Close the scanners and input stream
			inScan.close();
			fis.close();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		
	}

	// Takes in a string representing a output file path, and prints each value from map wordCounter to that file.
	public void write(String outputFile)
	{
		try
		{
			FileOutputStream fos = null;
			PrintWriter pw = null;
			
			fos = new FileOutputStream(outputFile);
			pw = new PrintWriter(fos);
			
			// Iterates through each string in the keySet of uniqueWords, appending each corresponding value to outputFile.
			for (String key : wordCounter.keySet())
			{
				pw.println(key + ": " + wordCounter.get(key));
			}
			
			// Close the writers and input stream
			pw.flush();
			fos.close();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
