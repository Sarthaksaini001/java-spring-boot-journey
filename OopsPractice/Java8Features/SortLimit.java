import java.util.Arrays;
import java.util.List;

public class SortLimit {
    public static void main(String[] args) {
        
    // Get the top 3 smallest numbers
    List<Integer> numbers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
    // Expected output: [12, 15, 24]

    List<Integer> smallestNumber = numbers.stream()
    .sorted()
    .limit(3)
    .toList();
    
    System.out.println(smallestNumber);
    }
}
