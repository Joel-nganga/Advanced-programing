import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws InsufficientFundsException { // Declare the exception
        // Step 1: Initialize a bank account
        BankAccount account = new BankAccount(1000.0);

        // Step 2: Create a date object
        Calendar date = Calendar.getInstance();

        // Step 3: Create transactions
        DepositTransaction deposit = new DepositTransaction(500.0, date, "TXN001");
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(1200.0, date, "TXN002");

        // Step 4: Test deposit
        deposit.apply(account);
        System.out.println("Balance after deposit: " + account.getBalance());

        // Step 5: Test withdrawal with exception handling
        try {
            withdrawal.apply(account); // Attempt withdrawal
        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Step 6: Test partial withdrawal
        withdrawal.apply(account, true); // Allow partial withdrawal
        System.out.println("Unmet amount: " + withdrawal.getUnmetAmount());

        // Step 7: Test reversal
        System.out.println("\nReversing transactions...");
        deposit.reverse(); // Irreversible
        withdrawal.reverse(); // Reversible

        // Step 8: Demonstrate polymorphism
        BaseTransaction transaction = deposit;
        transaction.printTransactionDetails();

        transaction = withdrawal;
        transaction.printTransactionDetails();
        try {
            transaction.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println("Exception during polymorphic test: " + e.getMessage());
        }

        // Final balance
        System.out.println("Final balance: " + account.getBalance());
    }
}
