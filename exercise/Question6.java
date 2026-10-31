import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Question6 {
    public static void main(String[] args) {
        List<Integer> amounts = Arrays.asList(500, 1200, 300, 2500, 800, 1800, 2500);

        Optional<Integer> result = amounts.stream()
                .filter(amount -> amount > 1000)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        System.out.println(result);
    }
}
