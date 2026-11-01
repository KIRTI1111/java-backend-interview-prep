import java.util.List;

public class Question7 {
    public static void main(String[] args) {
        List<Integer> transactions = List.of(200, 100, 400, 200, 100);

        int limit = 500;
        int left = 0;
        int currentSum = 0;
        int maxLength = 0;

        for (int right = 0; right < transactions.size(); right++) {

            currentSum += transactions.get(right);

            while (currentSum > limit) {
                currentSum -= transactions.get(left);
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);

        }
        System.out.println("Maximum consecutive transactions: " + maxLength);

    }

}
