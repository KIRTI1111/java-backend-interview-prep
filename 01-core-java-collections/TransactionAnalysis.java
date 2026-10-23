import java.util.Arrays;
import java.util.List;

public class TransactionAnalysis {
    public static void main(String[] args) {

        List<Integer> transactions = Arrays.asList(500, -200, 1200, -300, 800, -100);
        // List<Integer> sampleTransactions = Arrays.asList(-200, -500, -100);

        int totalDeposits = 0;
        int totalWithdrawals = 0;
        int netBalance = 0;
        int largestDeposit = 0;

        for (int transaction : transactions) {
            netBalance += transaction;
            if (transaction > 0) {
                totalDeposits += transaction;
                if (largestDeposit < transaction) {
                    largestDeposit = transaction;
                }
            } else if (transaction < 0) {
                totalWithdrawals += Math.abs(transaction);
            }
        }
        String result = largestDeposit > 0 ? String.valueOf(largestDeposit) : "No Deposits found";
        System.out.println("Total deposits: " + totalDeposits);
        System.out.println("Total withdrawals: " + totalWithdrawals);
        System.out.println("Net balance: " + netBalance);
        System.out.println("Largest deposit: " + result);
    }
}
