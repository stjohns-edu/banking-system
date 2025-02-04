public class CheckingAccount extends BankAccount {
    private double overdraftLimit;
    private static final double MONTHLY_FEE = 5.00;

    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance + overdraftLimit >= amount && amount > 0) {
            balance -= amount;
            logTransaction("WITHDRAWAL", amount);
            return true;
        }
        return false;
    }

    @Override
    public void applyMonthlyFees() {
        withdraw(MONTHLY_FEE);
    }

    @Override
    public String getAccountInfo() {
        return String.format("Checking Account %s - Overdraft Limit: $%.2f",
                accountNumber, overdraftLimit);
    }
}
