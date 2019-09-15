package cook_p1;
import java.util.Scanner;

public class Decryption {

	// Takes in a 4-digit encoded input, and performs various operations on it to decrypt it.
		public static void main(String[] args)
		{
			Scanner scan = new Scanner(System.in);
			int userCode, i, original, temp1, temp2;
			int[] decryption = new int[4];
			
			System.out.println("Enter a 4-digit code to decrypt:");
			userCode = scan.nextInt();
			
			original = userCode;
			
			// Places all digits of the encrypted code in an array.
			for (i = 0; i < 4; i++)
			{
				decryption[3 - i] = (userCode % 10);
				userCode /= 10;
			}
			
			// Reverts the code to its Step #1 encrypted state (e.g. add 3, take its remainder of 10).
			for (i = 0; i < 4; i++)
			{
				decryption[3 - i] = ((original % 10) + 3) % 10;
				original /= 10;
			}
			
			// Swaps the first and third digit.
			temp1 = decryption[0];
			decryption[0] = decryption[2];
			decryption[2] = temp1;
			
			// Swaps the second and fourth digit.
			temp2 = decryption[1];
			decryption[1] = decryption[3];
			decryption[3] = temp2;

			System.out.println("Your decrypted code: " + decryption[0] + "" + decryption[1] + "" + decryption[2] + "" + decryption[3]);
			
			scan.close();
		}
}
