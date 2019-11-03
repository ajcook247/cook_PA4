package cook_p2;

import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException
	{
		String dataFile = "problem2.txt";
		String outputFile = "unique_words_counts.txt";
		
		// Creates a DuplicateRemover object.
		DuplicateCounter dc = new DuplicateCounter();
		
		// Using dc, count all words from dataFile and print them to outputFile.
		dc.count(dataFile);
		dc.write(outputFile);
	}
}
