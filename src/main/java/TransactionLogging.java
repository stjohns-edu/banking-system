import java.util.List;

public interface TransactionLogging {
    void logTransaction(String type, double amount);

    List<String> getTransactionHistory();
}
