package cook_p2;

class Application {
    // Prints the monthly balances for each month.
    public static void printMonthlyBalance(SavingsAccount saver)
    {
        int i;
        // Loop through each month, printing the current balance of the SavingsAccount.
        for (i = 1; i <= 12; i++)
        {
            System.out.print("Month #" + i + ": ");
            saver.calculateMonthlyInterest();
        }
        System.out.println("");
    }

    public static void main(String[] args)
    {
        SavingsAccount saver1 = new SavingsAccount(2000.00, 0.04);
        SavingsAccount saver2 = new SavingsAccount(3000.00, 0.04);

        // Prints the monthly balances for each saver.
        System.out.println("Saver1");
        printMonthlyBalance(saver1);

        System.out.println("Saver2");
        printMonthlyBalance(saver2);

        // Modifies the interest rate of both savers to 5%.
        saver1.modifyInterestRate(0.05);
        saver2.modifyInterestRate(0.05);

        System.out.println("Interest rate modified to 5%");
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
    }
}