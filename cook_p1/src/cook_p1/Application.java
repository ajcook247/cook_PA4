package cook_p1;

import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException
	{
		String dataFile = "problem1.txt";
		String outputFile = "unique_words.txt";
		
		// Creates a DuplicateRemover object.
		DuplicateRemover dr = new DuplicateRemover();
		
		// Using dr, remove all duplicate words from dataFile and print them to outputFile.
		dr.remove(dataFile);
		dr.write(outputFile);
	}
}
