import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionValidator {
    public static void main(String[] args) {

        List<Transaction> transactions = List.of(
                new Transaction("101", 500, "CREDIT"),
                new Transaction("102", -200, "DEBIT"),
                new Transaction("103", 1500, "CREDIT"),
                new Transaction("104", 0, "DEBIT"),
                new Transaction("105", 800, "CREDIT"));

        List<Transaction> validTransactions = new ArrayList<>();
        List<Transaction> inValidTransactions = new ArrayList<>();

        for (Transaction t : transactions) {

            String result = validateTransaction(t);
            if ("VALID".equals(result)) {
                validTransactions.add(t);
            } else {
                inValidTransactions.add(t);
                System.out.println("Transaction " + t.getTransactionId() + " rejected: " + result);
            }

        }

        Map<String, Long> transactionCounts = validTransactions.stream()
                .collect(Collectors.groupingBy(Transaction::getType, Collectors.counting()));

        System.out.println("Transaction Counts: " + transactionCounts);

        validTransactions.sort(Comparator.comparingDouble(Transaction::getAmount).reversed());

        for (Transaction t : validTransactions) {
            System.out.println("Transaction " + t.getTransactionId() + ": " + t.getAmount());
        }

        List<String> validTransactionsIds = new ArrayList<>();
        List<String> invalidTransactionsIds = new ArrayList<>();

        for (Transaction t : validTransactions) {
            validTransactionsIds.add(t.getTransactionId());
        }

        for (Transaction t : inValidTransactions) {
            invalidTransactionsIds.add(t.getTransactionId());
        }

        System.out.println("Valid transaction IDs: " + String.join(", ", validTransactionsIds));
        System.out.println("InValid transaction IDs: " + String.join("| ", invalidTransactionsIds));

    }

    public static String validateTransaction(Transaction t) {
        if (t.getAmount() < 0) {
            return "NEGATIVE_AMOUNT";
        } else if (t.getAmount() == 0) {
            return "ZERO_AMOUNT";
        } else {
            return "VALID";
        }
    }
}