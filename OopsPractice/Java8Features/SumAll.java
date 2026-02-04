import java.util.Arrays;
import java.util.List;

public class SumAll {
    public static void main(String[] args) {
        
    // Find the sum of all numbers
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    // Expected output: 15

    int sum = numbers.stream()
    .mapToInt( n -> n)
    .sum();
    System.out.println("Sum: " + sum);
    
    }
}
