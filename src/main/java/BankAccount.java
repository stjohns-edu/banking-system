import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BankAccount implements AccountOperations, TransactionLogging {
    protected double balance;
    protected String accountNumber;
    protected List<String> transactions;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            logTransaction("DEPOSIT", amount);
            return true;
        }
        return false;
    }

    @Override
    public void logTransaction(String type, double amount) {
        String transaction = String.format("%s: $%.2f - Date: %s",
            type, amount, LocalDateTime.now());
        transactions.add(transaction);
    }

    @Override
    public List<String> getTransactionHistory() {
        return Collections.unmodifiableList(transactions);
    }

    public abstract void applyMonthlyFees();
}

