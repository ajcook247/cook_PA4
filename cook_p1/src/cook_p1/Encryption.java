package cook_p1;
import java.util.Scanner;

public class Encryption {

	// Takes in a 4-digit code, and performs various operations on it to encrypt it.
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int userCode, i, temp1, temp2;
		int[] encryption = new int[4];
		
		System.out.println("Enter a 4-digit code to encrypt:");
		userCode = scan.nextInt();
		
		// Places all digits of the user code in an array.
		for (i = 0; i < 4; i++)
		{
			encryption[3 - i] = ((userCode % 10) + 7) % 10;
			userCode /= 10;
		}
		
		// Swaps the first and third digit.
		temp1 = encryption[0];
		encryption[0] = encryption[2];
		encryption[2] = temp1;
		
		// Swaps the second and fourth digit.
		temp2 = encryption[1];
		encryption[1] = encryption[3];
		encryption[3] = temp2;
		
		System.out.println("Your encrypted code: " + encryption[0] + "" + encryption[1] + "" + encryption[2] + "" + encryption[3]);
		
		scan.close();
	}
}
