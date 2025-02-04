import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV001", 1000.00, 0.025));
        accounts.add(new CheckingAccount("CHK001", 500.00, 100.00));

        for (BankAccount account : accounts) {
            System.out.println(account.getAccountInfo());
            account.deposit(100.00);
            account.applyMonthlyFees();
            System.out.println("Current Balance: $" + account.getBalance());
            System.out.println("Transaction History:");
            account.getTransactionHistory().forEach(System.out::println);
            System.out.println();
        }
    }
}