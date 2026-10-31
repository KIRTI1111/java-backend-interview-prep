import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TransactionSummary {
    public static void main(String[] args) {
        List<Integer> transactions = Arrays.asList(1500, -500, 3000, -1000, 2500,
                -200, 3000, 800, -1500);

        int totalDeposits = transactions.stream()
                .filter(transaction -> transaction > 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Total deposits: " + totalDeposits);

        int totalwithdrawals = Math.abs(transactions.stream()
                .filter(transaction -> transaction < 0)
                .mapToInt(Integer::intValue)
                .sum());

        System.out.println("Total withdrawals: " + totalwithdrawals);

        Optional<Integer> largestDeposit = transactions.stream()
                .filter(transaction -> transaction > 0)
                .max(Comparator.naturalOrder());

        System.out.println("Largest deposit: " + largestDeposit);

        List<Integer> depositsAboveThousand = transactions.stream()
                .filter(transaction -> transaction > 1000)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(depositsAboveThousand);

    }
}
