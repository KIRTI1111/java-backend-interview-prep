import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class TransactionStreams {

    public static void main(String[] args) {

        List<Integer> transactions = Arrays.asList(500, -200, 1200, -300, 800, -100);
        // List<Integer> sampleTransactions = Arrays.asList(-200, -500, -100);

        int totalDeposits = transactions.stream()
                .filter(transaction -> transaction > 0)
                .mapToInt(Integer::intValue)
                .sum();

        int totalWithdrawals = transactions.stream()
                .filter(transaction -> transaction < 0)
                .mapToInt(transaction -> Math.abs(transaction))
                .sum();

        OptionalInt largestDeposit = transactions.stream()
                .filter(transaction -> transaction > 0)
                .mapToInt(Integer::intValue)
                .max();

        if (largestDeposit.isPresent()) {
            System.out.println("Largest Deposit: " + largestDeposit.getAsInt());
        } else {
            System.out.println("No deposits found");
        }
        System.out.println("Total Deposits: " + totalDeposits);
        System.out.println("Total Withdrawals: " + totalWithdrawals);
    }

}
