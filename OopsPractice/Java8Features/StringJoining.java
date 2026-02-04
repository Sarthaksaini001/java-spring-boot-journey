import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringJoining {
    public static void main(String[] args) {
    // Join all strings with a comma separator
    List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango");
    // Expected output: "Apple, Banana, Orange, Mango"
    // Hint: Use Collectors.joining()

    String finalResult = fruits.stream()
        .collect(Collectors.joining(", "));
    
    System.out.println(finalResult);
    }
}
