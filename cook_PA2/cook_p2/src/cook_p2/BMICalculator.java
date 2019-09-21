package cook_p2;
import java.util.Scanner;

public class BMICalculator {

	// Asks the user for their measurement system to use, then calculates their BMI based on their inputted
	// weight and height.
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int format;
		double bmi;
		int weightInPounds, heightInInches;
		double weightInKilograms, heightInMeters;
		
		System.out.println("Select the measurement system you would like to use (1 for Imperial, 2 for Metric):");
		format = scan.nextInt();
		
		// Imperial system
		if (format == 1)
		{
			System.out.println("Enter your weight in pounds and your height in inches:");
			weightInPounds = scan.nextInt();
			heightInInches = scan.nextInt();
			
			bmi = (703 * weightInPounds) / (Math.pow(heightInInches, 2));
		}
		// Metric system
		else if (format == 2)
		{
			System.out.println("Enter your weight in kilograms and your height in meters:");
			weightInKilograms = scan.nextDouble();
			heightInMeters = scan.nextDouble();
			
			bmi = (weightInKilograms) / (Math.pow(heightInMeters, 2));
		}
		// No proper input for measurement system.
		else
		{
			bmi = 0;
			System.out.println("Unknown. Please select a different measurement system.");
		}
		
		// Outputs user BMI and NHLB statistics.
		if (format == 1 || format == 2)
		{
			System.out.printf("Your BMI is: %.2f\n", bmi);
			System.out.println("The following are the BMI categories from the National Heart, Lung, and Blood Institute:");
			System.out.println("Underweight = Less than 18.5");
			System.out.println("Normal weight = 18.5 - 24.9");
			System.out.println("Overweight = 25 - 29.9");
			System.out.println("Obesity = 30 or greater");
		}
		
		scan.close();
	}
}
