package cook_p3;
import java.util.Scanner;

public class UserRating {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String[] topics = {"Ice Cream", "Video Games", "Petitioners", "Sleeping", "Programming"};
		int[][] responses = new int[5][10];
		int i, j, userInput, count = 0;
		int total = 0, maxTotal = 0, maxIndex = 0, minTotal = 0, minIndex = 0;
		char repeat = 'y';
		double average = 0.0;
		
		System.out.println("Welcome to the survey!");
		System.out.println("Please answer with your feelings rated from 1 to 10 (1 = strongly like, 10 = strongly dislike) on each topic.");
		
		// Fills the 2D array with placeholder values.
		for (i = 0; i < 5; i++)
		{
			for (j = 0; j < 10; j++)
				responses[i][j] = 0;
		}
		
		// Runs through the survey so long as the user wants to continue.
		while (repeat == 'y')
		{
			System.out.println("");
			
			// Prompts the user for each response, then records it in the table.
			System.out.println("On a scale of 1 to 10, how do you feel about " + topics[0] + "?");
			userInput = scan.nextInt();
			responses[0][userInput - 1]++;
			
			System.out.println("On a scale of 1 to 10, how do you feel about " + topics[1] + "?");
			userInput = scan.nextInt();
			responses[1][userInput - 1]++;
			
			System.out.println("On a scale of 1 to 10, how do you feel about " + topics[2] + "?");
			userInput = scan.nextInt();
			responses[2][userInput - 1]++;
			
			System.out.println("On a scale of 1 to 10, how do you feel about " + topics[3] + "?");
			userInput = scan.nextInt();
			responses[3][userInput - 1]++;
			
			System.out.println("On a scale of 1 to 10, how do you feel about " + topics[4] + "?");
			userInput = scan.nextInt();
			responses[4][userInput - 1]++;
			
			System.out.println("Would you like to enter additional responses? (y\\n)");
			repeat = scan.next().charAt(0);
		}
		
		// Sets up top row.
		System.out.print("\t\t");
		for (i = 1; i <= 10; i++)
		{
			System.out.print(i + ":\t");
		}
		System.out.print("\n");
		
		// Fills in the remainder of the table.
		for (i = 0; i < 5; i++)
		{
			System.out.print(topics[i] + "\t");
			
			for (j = 0; j < 10; j++)
			{
				System.out.print(responses[i][j] + "\t");

				// Adds to the average is a nonzero value is present.
				if (responses[i][j] > 0)
				{
					average += (j + 1);
					count++;
				}
			}
			
			// Calculates and prints the average for each row.
			average /= count;
			System.out.printf("Average: %.2f", average);
			average = 0.0;
			count = 0;
			
			System.out.print("\n");
		}
		
		System.out.print("\n");
		
		// Sets up the minimum total points to the first row as default.
		for (j = 0; j < 10; j++)
		{
			if (responses[0][j] > 0)
				total += (j + 1);
		}
		
		minTotal = total;
		total = 0;
		
		// Calculates the highest and lowest total points for the entire table, then prints their corresponding 
		// topics and values.
		for (i = 0; i < 5; i++)
		{
			for (j = 0; j < 10; j++)
			{
				if (responses[i][j] > 0)
					total += (responses[i][j] * (j + 1));
			}
			
			if (total > maxTotal)
			{
				maxTotal = total;
				maxIndex = i;
			}
			if (total < minTotal)
			{
				minTotal = total;
				minIndex = i;
			}
			
			total = 0;
		}
		
		System.out.println("The topics that received the highest point total was " + topics[maxIndex] + " with " + maxTotal + " points.");
		System.out.println("The topics that received the lowest point total was " + topics[minIndex] + " with " + minTotal + " points.");
		
		scan.close();
	}
}
