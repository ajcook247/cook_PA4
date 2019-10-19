package cook_p2;

public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    // Default constructor, sets private fields to 0.
    public SavingsAccount()
    {
        savingsBalance = 0;
        annualInterestRate = 0;
    }

    // User-defined constructor, sets private fields to parameter starting balance and interest rate.
    public SavingsAccount(double balance, double interest)
    {
        savingsBalance = balance;
        annualInterestRate = interest;
    }

    // Calculates the monthly rate based on the given formula, adds it to savingsBalance, and prints the
    // current balance.
    public void newMonthlyInterest()
    {
        double monthlyRate = (savingsBalance * annualInterestRate) / 12.0;
        savingsBalance += monthlyRate;
        System.out.printf("$%.2f\n", savingsBalance);
    }

    // Modifies the value of annualInterestRate to parameter newRate.
    public static void modifyInterestRate(double newRate)
    {
        annualInterestRate = newRate;
    }
}
