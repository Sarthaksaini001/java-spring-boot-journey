import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Practice {
    public static void main(String[] args) {

        List<String> usernames = Arrays.asList(
            "Alice",
            null,
            "BOB",
            "charlie",
            "Dee",
            null,
            "Edward"
        );

        int totalCharachter = usernames.stream()
        .map(s -> Optional.ofNullable(s).orElse(""))
        .map(String::toLowerCase)
        .filter(s -> s.length() > 4)
        .map(String::length)
        .reduce(0, Integer::sum);

        System.out.println("Total: " + totalCharachter);
}
}

