import java.util.function.Predicate;
import java.util.function.Function;

public class Question11 {

    public static void main(String[] args) {

        Predicate<Integer> isEligible = deposit -> deposit > 5000;
        Function<Integer, Integer> add = deposit -> deposit + 100;

        System.out.println("Is eligible: " + isEligible.test(8000));
        System.out.println("Amount after bonus: " + add.apply(8000));
    }

}
