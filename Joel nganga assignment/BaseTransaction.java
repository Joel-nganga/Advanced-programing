public abstract class BaseTransaction implements TransactionInterface {
    private double amount;
    private java.util.Calendar date;
    private String transactionID;
    protected BankAccount associatedAccount;

    public BaseTransaction(double amount, java.util.Calendar date, String transactionID) {
        this.amount = amount;
        this.date = date;
        this.transactionID = transactionID;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public java.util.Calendar getDate() {
        return date;
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Date: " + date.getTime());
        System.out.println("Amount: " + amount);
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        this.associatedAccount = ba;
    }

    @Override
    public boolean reverse() {
        System.out.println("Reverse operation not supported for this transaction.");
        return false;
    }
}
