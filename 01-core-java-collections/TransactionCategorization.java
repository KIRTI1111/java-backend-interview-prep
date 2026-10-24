import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransactionCategorization {
    public static void main(String[] args) {

        List<Integer> transactions = Arrays.asList(
                500, -200, 1000, -500, 300, -200, 500, -100);

        List<Integer> deposits = new ArrayList<>();
        List<Integer> withdrawals = new ArrayList<>();
        int totalDeposits = 0;

        for (int transaction : transactions) {
            if (transaction > 0) {
                deposits.add(transaction);
            } else {
                withdrawals.add(transaction);
            }
        }
        for (int deposit : deposits) {
            totalDeposits += deposit;
        }

        if (!withdrawals.isEmpty()) {
            int largestWithdrawal = withdrawals.get(0);
            int totalWithdrawals = 0;
            for (int withdrawl : withdrawals) {
                totalWithdrawals += Math.abs(withdrawl);
                if (largestWithdrawal > withdrawl) {
                    largestWithdrawal = withdrawl;
                }
            }
            System.out.println(Math.abs(largestWithdrawal));
            System.out.println(totalWithdrawals);
        } else {
            System.out.println("No withdrawals found.");
        }
        System.out.println(deposits);
        System.out.println(withdrawals);

        System.out.println(totalDeposits);

    }
}