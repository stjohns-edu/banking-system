public class SavingsAccount extends BankAccount {
    private double interestRate;
    private static final double MINIMUM_BALANCE = 100.00;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance - amount >= MINIMUM_BALANCE && amount > 0) {
            balance -= amount;
            logTransaction("WITHDRAWAL", amount);
            return true;
        }
        return false;
    }

    @Override
    public void applyMonthlyFees() {
        double interest = balance * interestRate;
        deposit(interest);
    }

    @Override
    public String getAccountInfo() {
        return String.format("Savings Account %s - Interest Rate: %.2f%%",
                accountNumber, interestRate * 100);
    }
}