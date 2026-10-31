import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question5 {
    public static void main(String[] args) {
        List<Integer> amounts = Arrays.asList(500, 1200, 300, 2500, 800, 1800);

        List<Integer> result = amounts.stream()
                .filter(amount -> amount > 1000)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(result);
    }
}
