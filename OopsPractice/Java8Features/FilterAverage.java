import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAverage {
    public static void main(String[] args) {
        
    // Find average of numbers greater than 10
    List<Integer> numbers = Arrays.asList(5, 12, 8, 20, 15, 3, 25);
    // Expected output: 18.0
    // Hint: Use .average() and .ifPresent()

    List<Integer> greaterThanTen = numbers.stream()
    .filter( n -> n > 10 )
    .collect(Collectors.toList());
    System.out.println("List of numbers greater than 10 : " +greaterThanTen);

    greaterThanTen.stream()
    .mapToInt(Integer::intValue)
    .average()
    .ifPresent(avg -> System.out.println("Average: " + avg));

    }
}
