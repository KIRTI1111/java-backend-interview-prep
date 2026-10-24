import java.util.ArrayList;
import java.util.List;

public class TransactionProcessor {

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("TXN101", 500.0, "DEPOSIT"));
        transactions.add(new Transaction("TXN102", 200.0, "WITHDRAWAL"));
        transactions.add(new Transaction("TXN103", 1000.0, "DEPOSIT"));
        transactions.add(new Transaction("TXN104", 350.0, "WITHDRAWAL"));
        transactions.add(new Transaction("TXN105", 300.0, "DEPOSIT"));

        double totalDeposits = 0;
        // double totalWithdrawals = 0;
        // int depositCount = 0;
        // int withdrawalCount = 0;

        // for (Transaction t : transactions) {
        // System.out.println(
        // "Transaction Id: " + t.getTransactionId() + " " + "amount: " + " " +
        // t.getAmount()
        // + " " + "type: " + t.getType());
        // if (t.getType().equals("DEPOSIT")) {
        // totalDeposits += t.getAmount();
        // depositCount++;
        // } else if (t.getType().equals("WITHDRAWAL")) {
        // totalWithdrawals += t.getAmount();
        // withdrawalCount++;
        // }
        // }

        totalDeposits = transactions.stream()
                .filter(t -> t.getType().equals("DEPOSIT"))
                .mapToDouble(t -> t.getAmount())
                .sum();

        long withdrawalCountUsingStreams = transactions.stream()
                .filter(t -> t.getType().equals("WITHDRAWAL"))
                .count();

        // System.out.println(totalDeposits);
        // System.out.println(totalWithdrawals);
        // System.out.println(depositCount);
        // System.out.println(withdrawalCount);

        System.out.println("Total Deposits using Streams: " + totalDeposits);
        System.out.println("Withdrawal Count using Streams: " + withdrawalCountUsingStreams);

    }

}
