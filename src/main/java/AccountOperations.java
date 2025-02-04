public interface AccountOperations {
    boolean deposit(double amount);

    boolean withdraw(double amount);

    double getBalance();

    String getAccountInfo();
}
