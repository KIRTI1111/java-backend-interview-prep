import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionFrequency {

    public static void main(String[] args) {

        List<Integer> transactions = Arrays.asList(500, 200, 500, 100, 200, 500, 300);
        Map<Integer, Integer> frequency = new HashMap<>();

        int mostFrequentTransaction = 0;
        int highestFrequency = 0;

        // for (int transaction : transactions) {

        // if (frequency.containsKey(transaction)) {
        // frequency.put(transaction, frequency.get(transaction) + 1);
        // } else {
        // frequency.put(transaction, 1);
        // }
        // }
        for (int transaction : transactions) {
            frequency.put(transaction, frequency.getOrDefault(transaction, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            // System.out.println(entry.getKey() + " -> " + entry.getValue());
            if (highestFrequency < entry.getValue()) {
                mostFrequentTransaction = entry.getKey();
                highestFrequency = entry.getValue();
            }
        }
        System.out.println(mostFrequentTransaction + " -> " + highestFrequency);
        System.out.println(frequency);
    }

}
