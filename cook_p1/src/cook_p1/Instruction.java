package cook_p1;

import java.util.Scanner;
import java.security.SecureRandom;

public class Instruction {

    // Takes in an integer value and returns the bounds representing the difficulty level.
    private static int determineDifficulty(int value)
    {
        return (int)Math.pow(10.0, value);
    }

    // Takes in a value denoting the problem type, and the numbers to operate on, and generates a problem based on
    // that type (addition, subtraction, etc.) and returns the correct answer to it.
    private static double determineProblemType(int value, int first, int second)
    {
        SecureRandom rand = new SecureRandom();
        int mixed;

        // Prints the problem and returns the expected answer to the problem depending on the question type.
        if (value == 1)
        {
            System.out.printf("What is %d plus %d?\n", first, second);
            return (double)first + second;
        }
        else if (value == 2)
        {
            System.out.printf("What is %d minus %d?\n", first, second);
            return (double)first - second;
        }
        else if (value == 3)
        {
            System.out.printf("What is %d times %d?\n", first, second);
            return (double)first * second;
        }
        else if (value == 4)
        {
            System.out.printf("What is %d divided by %d? (Answer up to 3 decimal places)\n", first, second);
            return (double)first / second;
        }
        // If the user asked for mixed type, generate a random integer between 1-4 and call this method with that number.
        else
        {
            mixed = rand.nextInt(4) + 1;
            return determineProblemType(mixed, first, second);
        }
    }

    // Takes in a difficulty level, generates a randomized math question, prints it out, and returns its expected answer.
    private static double generateQuestion(int difficulty, int problemType){
        int firstNumber, secondNumber;
        double correctAnswer = 0.0;
        int factor = determineDifficulty(difficulty);

        SecureRandom rand = new SecureRandom();

        firstNumber = rand.nextInt(factor - 1) + 1;
        secondNumber = rand.nextInt(factor - 1) + 1;

        // Generates the problem type, along with the correct answer to that problem
        correctAnswer = determineProblemType(problemType, firstNumber, secondNumber);

        return correctAnswer;
    }

    // Takes in an integer representing if the answer is correct or not, then generates a random number and displays
    // different responses.
    private static String generateResponse(int success)
    {
        SecureRandom rand = new SecureRandom();
        String response = "";
        int number;

        number = rand.nextInt(4) + 1;

        // The answer was correct
        if (success == 1)
        {
            switch (number)
            {
                case 1:
                    response = "Very good!";
                    break;
                case 2:
                    response = "Excellent!";
                    break;
                case 3:
                    response = "Nice work!";
                    break;
                case 4:
                    response = "Keep up the good work!";
                    break;
                default:
                    break;
            }
        }
        // The answer was incorrect
        else
        {
            switch (number)
            {
                case 1:
                    response = "No. Please try again.";
                    break;
                case 2:
                    response = "Wrong. Try once more.";
                    break;
                case 3:
                    response = "Don’t give up!";
                    break;
                case 4:
                    response = "No. Keep trying.";
                    break;
                default:
                    break;
            }
        }

        return response;
    }

    // Takes in a double representing the number of correct answers, calculates the user's average percentage,
    // then displays text depending on its value denoting the end of the program.
    private static void endInstruction(double numberCorrect)
    {
        double avgPercent = (numberCorrect / 10.0) * 100.0;

        if (avgPercent > 75.0)
        {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
        else
        {
            System.out.println("Please ask your teacher for extra help.");
        }
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int i, difficulty, questionType;
        double answer, expected;
        double numCorrect;
        char newSession = 'y';

        while (newSession == 'y')
        {
            numCorrect = 0;

            System.out.println("Enter a difficulty (1 = 1 digit, 2 = 2 digit, 3 = 3 digit, 4 = 4 digit):");
            difficulty = scan.nextInt();

            // If the difficulty is invalid, keep reading input.
            while (!(difficulty >= 1 && difficulty <= 4))
            {
                System.out.println("Incorrect input. Enter a different difficulty:");
                difficulty = scan.nextInt();
            }

            System.out.println("Enter a question type (1 = Addition, 2 = Subtraction, 3 = Multiplication, 4 = Division, 5 = Mixed):");
            questionType = scan.nextInt();

            expected = generateQuestion(difficulty, questionType);

            answer = scan.nextDouble();

            // Allows the user 10 opportunities to answer questions. If correct, generate a new question;
            // otherwise, continue to prompt for the same question.
            for (i = 0; i < 9; i++)
            {
                if (Math.abs(answer - expected) <= 0.001)
                {
                    numCorrect++;
                    System.out.println(generateResponse(1));
                }
                else
                {
                    System.out.println(generateResponse(2));
                }
                System.out.println("");
                expected = generateQuestion(difficulty, questionType);
                answer = scan.nextDouble();
            }

            // Prints the final lines of the session: the number of correct and incorrect answers, and asks
            // the user if they would like too start a new session.
            System.out.println("");
            System.out.printf("Number of correct responses: %d\n", (int)numCorrect);
            System.out.printf("Number of incorrect responses: %d\n", (int)(10 - numCorrect));
            endInstruction(numCorrect);

            System.out.println("\nWould you like to enter a new session? (y = Yes, n = No)");
            newSession = scan.next().charAt(0);
            System.out.println("---------------------------------------");
        }
    }
}
