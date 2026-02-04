
import java.util.Arrays;
import java.util.List;

public class CountEvements {
    
    public static void main(String[] args) {
    // Count how many numbers are greater than 5
    List<Integer> numbers = Arrays.asList(3, 7, 2, 9, 1, 6, 4, 8);
    // Expected output: 4
    long count = numbers.stream()
    .filter(n -> n > 5)
    .count();
    System.out.println(count);
    }
}
